package com.example.companyapp.model

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.Drawable

data class Member(
    var name: String? = null,
    var job: String? = null,
    var imageId: Int? =  null,
    var check: Boolean = true

) {


}