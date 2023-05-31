package com.example.verifikasiin.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.verifikasiin.R
import com.example.verifikasiin.data.UsersPreference
import com.example.verifikasiin.databinding.ActivityMainBinding
import com.example.verifikasiin.ui.auth.AuthActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.option_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_logout -> {
                val usersPreference = UsersPreference(this)
                usersPreference.clearUser()
                Toast.makeText(this, "Berhasil logout", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, AuthActivity::class.java))
                return true
            }
            else -> return true
        }
    }

}