package com.example.empregaueu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.empregaueu.databinding.ActivitySegundaTelaBinding
import com.example.empregaueu.databinding.ActivityTela3Binding

class Tela3Activity : AppCompatActivity() {
    private lateinit var binding: ActivityTela3Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela3)

        binding = ActivityTela3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val btParaTela4 = binding.button6
        btParaTela4.setOnClickListener {
            val intent = Intent(this,Tela4Activity::class.java)
            startActivity(intent)
        }

    }
}