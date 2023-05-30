package com.example.verifikasiin.data

import android.content.Context

class UsersPreference(context : Context) {

    private val preference = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    fun setUser(value : UserModel) {
        val editor = preference.edit()
        editor.putString(USERID, value.id)
        editor.putString(EMAIL, value.email)
        editor.putString(NAME, value.name)
        editor.putString(PASSWORD, value.password)
        editor.putString(NIK, value.nik)
        editor.putString(TOKEN, value.token)
        editor.apply()
    }

    fun getUser() : UserModel {
        val model = UserModel(
            id = preference.getString(USERID, ""),
            email = preference.getString(EMAIL, ""),
            name = preference.getString(NAME, ""),
            nik = preference.getString(NIK, ""),
            password = preference.getString(PASSWORD, ""),
            token = preference.getString(TOKEN, "")
        )
        return model
    }


    companion object {
        private const val PREFS_NAME = "user_pref"
        private const val EMAIL = "email"
        private const val PASSWORD = "password"
        private const val USERID = "userid"
        private const val NAME = "name"
        private const val TOKEN = "token"
        private const val NIK = "nik"
    }
}