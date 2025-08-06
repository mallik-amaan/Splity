package com.codinfinity.splity.core.services.system

import android.content.Context
import android.content.Intent
import android.provider.MediaStore
import java.io.InputStream

class FilePickerService {

    // Function to pick image from gallery and return as InputStream
    fun pickImageFromGallery(context: Context): InputStream? {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        intent.type = "image/*"

        // Start activity to pick image
        (context as android.app.Activity).startActivityForResult(intent, REQUEST_CODE_PICK_IMAGE)

        // Note: This implementation assumes you are calling this from an Activity or have access to request codes
        // The actual InputStream result would be obtained in the onActivityResult method
        return null
    }

    companion object {
        private const val REQUEST_CODE_PICK_IMAGE = 1001
    }
}