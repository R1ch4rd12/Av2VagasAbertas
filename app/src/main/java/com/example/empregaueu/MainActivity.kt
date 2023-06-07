package com.example.empregaueu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.empregaueu.databinding.ActivityMainBinding
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val edNome = binding.textName

        val btLogin = binding.button

        btLogin.setOnClickListener {

            // Write a message to the database
            val database = Firebase.database
            val myRef = database.getReference("message")

            myRef.setValue("Hello, World!")


            if(edNome.text.toString() == "xablau") {
                val intent = Intent(this, SegundaTela::class.java)
                intent.putExtra("chaveNomeUsuario", edNome.text.toString())
                startActivity(intent)
            }else{
                Toast.makeText(this, "Usuario inválido", Toast.LENGTH_SHORT).show()
            }
        }
    }
}