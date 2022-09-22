package com.example.practicamovil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.practicamovil.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mhandler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Inicializar handler
        mhandler = Handler(mainLooper)
        binding.btnIniciar.setOnClickListener{
            //pasarPantalla()
            cargarPantalla()
            desactivarBoton()
        }
    }

    private fun desactivarBoton() {

    }

    private fun cargarPantalla() {

        Thread{

            try {
                //TODO(PORQUE FALLA?)
                if (binding.btnIniciar.isEnabled){
                    for (i in 0 .. 100){
                        Thread.sleep(100)
                        mhandler.post{
                            binding.btnIniciar.setEnabled(false);
                            binding.apply {
                                txtPorcentaje.text = "$i % Descargando archivo"
                                progressBar.progress = i
                                if (i == 100){
                                    txtPorcentaje.text = "COMPLETADO"
                                    binding.btnIniciar.setEnabled(true);
                                }
                            }
                        }
                    }
                }
            } catch (e: InterruptedException){
                e.printStackTrace()
            }
        }.start()
    }

    private fun pasarPantalla() {
        val mensaje = "Texto ejemplo"
        val numero = 10
        val intent = Intent(this, Home::class.java)
        intent.apply {
            putExtra("texto", mensaje)
            putExtra("valor", numero)
        }
        startActivity(intent)
    }
}