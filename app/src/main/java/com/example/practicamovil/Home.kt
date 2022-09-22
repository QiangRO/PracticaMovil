package com.example.practicamovil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.practicamovil.databinding.ActivityHomeBinding
import com.example.practicamovil.databinding.ActivityMainBinding

class Home : AppCompatActivity() {
    private lateinit var homeBinding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(homeBinding.root)
        val mensaje = """
            el texto es: ${intent.getStringExtra("texto")}
            el numero es: ${intent.getIntExtra("valor", 0)}
        """.trimIndent()
        homeBinding.txtResultado.text = mensaje
    }
}