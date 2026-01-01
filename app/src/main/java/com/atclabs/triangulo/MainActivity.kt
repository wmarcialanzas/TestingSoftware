package com.atclabs.triangulo

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Instancia de la clase lógica Demo proporcionada
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
            val s1Str = sideA.text.toString()
            val s2Str = sideB.text.toString()
            val s3Str = sideC.text.toString()

            // 1. Validación de campos vacíos para corregir el error en testEmptyInputHandling
            if (s1Str.isEmpty() || s2Str.isEmpty() || s3Str.isEmpty()) {
                txtResult.text = "⚠️ Ingrese todos los lados"
                txtResult.setTextColor(android.graphics.Color.parseColor("#FFA500"))
            } else {
                val a = s1Str.toDoubleOrNull() ?: 0.0
                val b = s2Str.toDoubleOrNull() ?: 0.0
                val c = s3Str.toDoubleOrNull() ?: 0.0

                // 2. Uso del método isTriangle de la clase Demo
                val isValid = demo.isTriangle(a, b, c)

                if (isValid) {
                    // 3. Lógica de clasificación para que pasen los tests de Equilátero, Isósceles y Escaleno
                    val tipo = when {
                        a == b && b == c -> "Equilátero"
                        a == b || a == c || b == c -> "Isósceles"
                        else -> "Escaleno"
                    }
                    txtResult.text = "✅ Es un Triángulo $tipo"
                    txtResult.setTextColor(android.graphics.Color.GREEN)
                } else {
                    // 4. Mensaje para cuando la desigualdad triangular no se cumple
                    txtResult.text = "❌ No es un triángulo"
                    txtResult.setTextColor(android.graphics.Color.RED)
                }
            }
        }
    }
}