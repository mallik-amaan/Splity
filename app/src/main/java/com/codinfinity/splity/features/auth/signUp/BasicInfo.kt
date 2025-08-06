import android.content.ContentValues
import android.net.Uri
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.OutlinedFlag
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.codinfinity.splity.features.auth.signUp.SignUpViewModel
import com.codinfinity.splity.features.navigation.Screen
import com.codinfinity.splity.ui.components.CustomTextField
import com.codinfinity.splity.ui.components.PrimaryButton

@Composable
fun BasicInfo(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: SignUpViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val name = viewModel.name.collectAsState(initial = "")
    val country = viewModel.country.collectAsState(initial = "")
    val imageUri = viewModel.imageURI.collectAsState(initial = "")

    var cameraImageUri by remember { mutableStateOf<Uri?>(null) }
    var showImagePickerDialog by remember { mutableStateOf(false) }

    // Gallery Launcher
    val galleryLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        uri?.let {
            viewModel.onImageURIChange(it)
        }
    }

    // Camera Launcher
    val cameraLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicture()
    ) { success ->
        if (success && cameraImageUri != null) {
            viewModel.onImageURIChange(cameraImageUri!!)
        }
    }

    if (showImagePickerDialog) {
        AlertDialog(
            onDismissRequest = { showImagePickerDialog = false },
            title = { Text("Select Image") },
            text = { Text("Choose how to set your profile picture.") },
            confirmButton = {
                TextButton(onClick = {
                    showImagePickerDialog = false
                    galleryLauncher.launch("image/*")
                }) {
                    Text("Gallery")
                }
            },
            dismissButton = {
                TextButton(onClick = {
                    showImagePickerDialog = false
                    val contentValues = ContentValues().apply {
                        put(MediaStore.MediaColumns.DISPLAY_NAME, "profile_${System.currentTimeMillis()}.jpg")
                        put(MediaStore.MediaColumns.MIME_TYPE, "image/jpeg")
                        put(MediaStore.MediaColumns.DATE_ADDED, System.currentTimeMillis() / 1000)
                    }
                    val uri = context.contentResolver.insert(
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                        contentValues
                    )
                    cameraImageUri = uri
                    uri?.let { cameraLauncher.launch(it) }
                }) {
                    Text("Camera")
                }
            }
        )
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Image Placeholder
        Box(
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape)
                .background(Color.LightGray)
                .clickable { showImagePickerDialog = true },
            contentAlignment = Alignment.Center
        ) {
            if (imageUri.value != null) {
                Image(
                    painter = rememberAsyncImagePainter(model = imageUri.value),
                    contentDescription = "Profile Image",
                    modifier = Modifier.fillMaxSize()
                )
            } else {
                Icon(
                    imageVector = Icons.Rounded.Person,
                    contentDescription = "Profile Placeholder",
                    modifier = Modifier.size(60.dp),
                    tint = Color.White
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        CustomTextField(
            onClick = {},
            placeholder = "Name",
            icon = Icons.Rounded.Person,
            value = name.value,
            onValueChange = { viewModel.onNameChange(it) },
        )

        CustomTextField(
            onClick = {},
            placeholder = "Country",
            icon = Icons.Default.OutlinedFlag,
            value = country.value,
            onValueChange = { viewModel.onCountryChange(it) },
        )

        Spacer(modifier = Modifier.height(16.dp))

        PrimaryButton(
            onClick = {
                viewModel.addBasicInfo(
                    onConvertToInputStream = { imageUri ->
                        context.contentResolver.openInputStream(imageUri)
                    },
                    onComplete = {
                        navController.navigate(Screen.RegistrationCompleteScreen.route)
                    }
                )
            },
            text = "Next",
            modifier = Modifier.padding(16.dp)
        )
    }
}
