package com.example.verifikasiin.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.verifikasiin.R
import com.example.verifikasiin.databinding.ActivityAuthBinding

class AuthActivity : AppCompatActivity() {

    private lateinit var binding : ActivityAuthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}