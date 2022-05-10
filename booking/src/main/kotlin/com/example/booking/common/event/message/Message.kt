package com.example.booking.common.event.message

import com.fasterxml.jackson.annotation.JsonProperty
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Message (
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("value")
    val value: String? = ""
) : Serializable