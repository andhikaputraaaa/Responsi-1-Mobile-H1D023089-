package com.innovape.responsi1mobileh1d023089.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class TeamResponse(
    @SerializedName("coach")
    val coach: Coach,
    @SerializedName("squad")
    val squad: List<Player>
)

data class Coach(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("dateOfBirth")
    val dateOfBirth: String,
    @SerializedName("nationality")
    val nationality: String,
)

data class Player(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("position")
    val position: String,
    @SerializedName("dateOfBirth")
    val dateOfBirth: String,
    @SerializedName("nationality")
    val nationality: String
) : Serializable

