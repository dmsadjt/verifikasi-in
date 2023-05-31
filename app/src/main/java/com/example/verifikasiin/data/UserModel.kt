package com.example.verifikasiin.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserModel(
    var id : String? = null,
    var name: String? = null,
    var email: String? = null,
    var nik: String? = null,
    var password: String? = null,
    var token: String? = null
) : Parcelable