package com.org.retrofitexample.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class User(
    @Expose
    @SerializedName("email")
    val email: String? = null,

    @Expose
    @SerializedName("username")
    val username: String? = null
) {
    override fun toString(): String {
        return "User(email = $email, username = $username)"
    }
}