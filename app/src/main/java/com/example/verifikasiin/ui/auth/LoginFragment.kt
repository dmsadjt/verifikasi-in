package com.example.verifikasiin.ui.auth

import android.app.Application
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.verifikasiin.R
import com.example.verifikasiin.data.UserModel
import com.example.verifikasiin.data.UsersPreference
import com.example.verifikasiin.databinding.FragmentLoginBinding
import com.example.verifikasiin.ui.ViewModelFactory
import com.example.verifikasiin.ui.main.MainActivity


class LoginFragment : Fragment(), View.OnClickListener, LoginViewModel.LoginCallback {

    private lateinit var loginBinding: FragmentLoginBinding
    private lateinit var user : UserModel
    private val loginViewModel by viewModels<LoginViewModel> {
        ViewModelFactory(requireContext().applicationContext as Application, requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        loginBinding = FragmentLoginBinding.inflate(inflater, container, false)
        return loginBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        checkAuth()
        loginBinding.btnMasuk.setOnClickListener(this)
        loginBinding.btnDaftar.setOnClickListener(this)
        loginViewModel.loginCallback = this
    }



    private fun checkAuth() {
        val userPreferences = UsersPreference(requireContext())
        user = userPreferences.getUser()
        if(user.nik != "") startActivity(Intent(requireContext(), MainActivity::class.java))
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.btn_masuk -> {
                loginViewModel.login(loginBinding.edtNik.toString(), loginBinding.edtPassword.toString())
            }
            R.id.btn_daftar -> {

            }
        }
    }

    companion object {
        private const val TAG = "LoginFragment"
    }

    override fun onLoginSuccess() {
        Log.e(TAG, "Test")
        Toast.makeText(requireContext(), "Berhasil masuk", Toast.LENGTH_SHORT).show()
        startActivity(Intent(requireContext(), MainActivity::class.java))
    }

    override fun onLoginError(errorMessage: String) {

    }
}