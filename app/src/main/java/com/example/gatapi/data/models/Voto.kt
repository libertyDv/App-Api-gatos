package com.example.gatapi.data.models

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class Voto(
    @field:Json(name = "image_id")
    val imageId: String,
    @field:Json(name = "sub_id")
    val subId: String,
    @field:Json(name = "value")
    val value: Int
) : Parcelable
