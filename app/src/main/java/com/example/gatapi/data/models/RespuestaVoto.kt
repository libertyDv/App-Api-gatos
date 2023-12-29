package com.example.gatapi.data.models

import com.squareup.moshi.Json

data class RespuestaVoto(
    @field:Json(name = "country_code")
    val countryCode: String?,
    @field:Json(name = "id")
    val id: Int?,
    @field:Json(name = "image_id")
    val imageId: String?,
    @field:Json(name = "message")
    val message: String?,
    @field:Json(name = "sub_id")
    val subId: String?,
    @field:Json(name = "value")
    val value: Int?

)