package com.example.verifikasiin.ui.auth

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.verifikasiin.R
import com.example.verifikasiin.databinding.FragmentLoginBinding
import com.example.verifikasiin.ui.main.MainActivity


class LoginFragment : Fragment(), View.OnClickListener {

    private lateinit var loginBinding: FragmentLoginBinding

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
        loginBinding.btnMasuk.setOnClickListener(this)
        loginBinding.btnDaftar.setOnClickListener(this)
    }

    companion object {

    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.btn_masuk -> {
                startActivity(Intent(requireContext(), MainActivity::class.java))
            }
            R.id.btn_daftar -> {

            }
        }
    }
}