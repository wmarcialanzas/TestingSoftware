package com.atclabs.triangulo

class TriangleValidator(private val demo: Demo) {

    fun validate(a: Double, b: Double, c: Double): String {
        return if (demo.isTriangle(a, b, c)) {
            "Es un triángulo válido"
        } else {
            "No es un triángulo"
        }
    }
}