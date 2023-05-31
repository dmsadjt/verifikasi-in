package com.example.verifikasiin.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.verifikasiin.R
import com.example.verifikasiin.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment(), View.OnClickListener {

    private lateinit var registerBinding : FragmentRegisterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        registerBinding = FragmentRegisterBinding.inflate(inflater, container, false)
        return registerBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        registerBinding.btnDaftar.setOnClickListener(this)
        registerBinding.btnMasuk.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.btn_masuk -> {
                redirectToLoginPage()
            }
            R.id.btn_daftar -> {
                Toast.makeText(requireContext(), "Berhasil mendaftar", Toast.LENGTH_LONG).show()
                redirectToLoginPage()
            }
        }
    }

    private fun redirectToLoginPage() {
        val loginFragment = LoginFragment()
        val fragmentManager = parentFragmentManager
        fragmentManager.beginTransaction().apply {
            replace(R.id.frame_container, loginFragment, LoginFragment::class.java.simpleName)
            addToBackStack(null)
            commit()
        }
    }


}