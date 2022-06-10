package com.ivanmanzaba

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class Segunda_pantalla : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda_pantalla)
    }

    override fun onStart() {
        super.onStart()
        val informacion = findViewById<TextView>(R.id.txtInformacion)
        val bundle = this.getIntent().getExtras();
        informacion.setText(
            "Hola " + bundle?.getString("nombre")
                    + ", su genero es: " + bundle?.getString("genero") +
                    ", su fecha de nacimiento es: " + bundle?.getString("fecha")
                    + " y su número telefónico es: " + bundle?.getString("telefono")+"."
        )
    }

    public fun regresar(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}