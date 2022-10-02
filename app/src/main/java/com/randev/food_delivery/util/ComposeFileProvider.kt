package com.randev.food_delivery.util

import android.content.Context
import android.net.Uri
import androidx.core.content.FileProvider
import com.randev.food_delivery.R
import java.io.File

/**
 * @author Raihan Arman
 * @date 02/10/22
 */

class ComposeFileProvider : FileProvider() {
    companion object {
        fun getImageUri(context: Context): Uri {
            val directory = File(context.cacheDir, "images")
            directory.mkdirs()
            val file = File.createTempFile(
                "selected_image_",
                ".jpg",
                directory,
            )
            val authority = context.packageName + ".fileprovider"
            return getUriForFile(
                context,
                authority,
                file,
            )
        }
    }
}
