package com.codinfinity.splity.core.services.system

import android.content.Context
import android.content.Intent
import android.provider.MediaStore
import java.io.InputStream

class CameraService {
    // Function to open camera and return captured image as InputStream
    fun captureImageFromCamera(context: Context): InputStream? {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

        // Start activity to capture image
        (context as android.app.Activity).startActivityForResult(intent, REQUEST_CODE_CAPTURE_IMAGE)
        // Note: This implementation assumes you're calling this from an Activity or have access to request codes
        // The actual InputStream result would be obtained in onActivityResult method
        return null
    }

    companion object {
        private const val REQUEST_CODE_CAPTURE_IMAGE = 1002
    }
}