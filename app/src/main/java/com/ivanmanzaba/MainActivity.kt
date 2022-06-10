package com.ivanmanzaba

import android.app.AlertDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.RadioButton
import android.content.Intent
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    public fun btnEviar(view: View) {

        val nombre = findViewById<EditText>(R.id.txtNombre)
        val masculino = findViewById<RadioButton>(R.id.rbMasculino)
        val femenino = findViewById<RadioButton>(R.id.rbFemenino)
        val fecha = findViewById<EditText>(R.id.dtFechaNacimiento)
        val telefono = findViewById<EditText>(R.id.ptTelefono)
        if (nombre.toString()
                .isNotEmpty() && (masculino.isChecked || femenino.isChecked) && fecha.toString()
                .isNotEmpty() && telefono.toString().isNotEmpty()
        ) {
            val bundle = Bundle()
            bundle.putString("nombre", nombre.text.toString())
            val genero = if (masculino.isChecked) masculino else femenino
            bundle.putString("genero", genero.text.toString())
            bundle.putString("fecha", fecha.text.toString())
            bundle.putString("telefono", telefono.text.toString())

            val intent = Intent(this, Segunda_pantalla::class.java)
            intent.putExtras(bundle)
            startActivity(intent)
        }
        else
            showDialogAlertSimple("Error", "Todos los campos deben estar llenos")


    }
    fun showDialogAlertSimple(titulo:String , mensaje : String) {
        AlertDialog.Builder(this)
            .setTitle(titulo)
            .setMessage(mensaje)
            .setPositiveButton(android.R.string.ok,
                DialogInterface.OnClickListener { dialog, which ->
                    //botón OK pulsado
                })
            .show()
    }
}