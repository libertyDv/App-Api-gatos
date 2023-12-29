package com.example.gatapi.data.models


import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class Weight(
    @Json(name = "imperial")
    val imperial: String,
    @Json(name = "metric")
    val metric: String
) : Parcelable