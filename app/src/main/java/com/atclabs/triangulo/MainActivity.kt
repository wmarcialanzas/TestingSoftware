package com.atclabs.triangulo

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Instancia de nuestra clase lógica
    private val demo = Demo()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sideA = findViewById<EditText>(R.id.sideA)
        val sideB = findViewById<EditText>(R.id.sideB)
        val sideC = findViewById<EditText>(R.id.sideC)
        val btnCheck = findViewById<Button>(R.id.btnCheck)
        val txtResult = findViewById<TextView>(R.id.txtResult)

        btnCheck.setOnClickListener {
            val a = sideA.text.toString().toDoubleOrNull() ?: 0.0
            val b = sideB.text.toString().toDoubleOrNull() ?: 0.0
            val c = sideC.text.toString().toDoubleOrNull() ?: 0.0

            // Usamos la función isTriangle() adaptada del proyecto original
            val result = demo.isTriangle(a, b, c)

            if (result) {
                txtResult.text = "✅ ¡Es un triángulo válido!"
                txtResult.setTextColor(android.graphics.Color.GREEN)
            } else {
                txtResult.text = "❌ No es un triángulo"
                txtResult.setTextColor(android.graphics.Color.RED)
            }
        }
    }
}