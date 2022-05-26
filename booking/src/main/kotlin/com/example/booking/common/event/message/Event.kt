package com.example.booking.common.event.message

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Event (
    @SerializedName("code")
    val code: String? = "",

    @SerializedName("name")
    val name: String? = "",

    @SerializedName("value")
    val value: String? = ""
) : Serializable