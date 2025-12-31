package com.atclabs.triangulo

open class Demo {
    /**
     * Determina si tres longitudes pueden formar un triángulo.
     * Basado en la lógica original de Demo.java.
     */
    open fun isTriangle(a: Double, b: Double, c: Double): Boolean {
        return (a + b > c) && (a + c > b) && (b + c > a)
    }
}