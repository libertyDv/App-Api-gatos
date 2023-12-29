package com.example.gatapi.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Respuesta(
    val results: List<RazasItem>,
    val weight: Weight
    ) : Parcelable

