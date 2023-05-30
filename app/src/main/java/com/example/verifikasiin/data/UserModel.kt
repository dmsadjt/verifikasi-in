package com.example.verifikasiin.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserModel(
    val id : String? = null,
    val name: String? = null,
    val email: String? = null,
    val nik: String? = null,
    val password: String? = null,
    val token: String? = null
) : Parcelable