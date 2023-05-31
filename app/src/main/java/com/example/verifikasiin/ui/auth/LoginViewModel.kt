package com.example.verifikasiin.ui.auth

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.verifikasiin.data.UserModel
import com.example.verifikasiin.data.UsersPreference

class LoginViewModel(application: Application) : ViewModel() {
    private val _loading = MutableLiveData<Boolean>()
    val loading : LiveData<Boolean> = _loading

    private val context = application.applicationContext
    private val usersPreference = UsersPreference(context)

    private lateinit var userInfo : UserModel

    var loginCallback : LoginCallback? = null

    fun login(nik: String, password: String) {
        userInfo = UserModel()
        userInfo.nik = nik
        userInfo.password = password
        usersPreference.setUser(userInfo)
        loginCallback?.onLoginSuccess()
    }

//    fun saveUserLogin(user : UserModel) {
//        userInfo = UserModel()
//        userInfo.nik = user.email
//        userInfo.password = user.password
//        usersPreference.setUser(userInfo)
//    }

    interface LoginCallback {
        fun onLoginSuccess()
        fun onLoginError(errorMessage: String)
    }


    companion object {
        private const val TAG = "LoginViewModel"
    }
}