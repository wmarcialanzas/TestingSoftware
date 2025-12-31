package com.atclabs.triangulo

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class DemoTest {

    private val demo = Demo()

    @Test
    fun testIsTriangle_Valid() {
        // Un triángulo equilátero simple
        assertTrue("Debería ser un triángulo válido", demo.isTriangle(3.0, 3.0, 3.0))
    }

    @Test
    fun testIsTriangle_Invalid() {
        // Un lado es demasiado largo
        assertFalse("No debería ser un triángulo", demo.isTriangle(1.0, 2.0, 10.0))
    }

    @Test
    fun testIsTriangle_ZeroSides() {
        // Lados con valor cero
        assertFalse("Lados en cero no forman un triángulo", demo.isTriangle(0.0, 0.0, 0.0))
    }


    @Test
    fun testIsTriangle_BoundaryCases() {
        // Falla la primera condición: a + b no es mayor que c
        assertFalse(demo.isTriangle(2.0, 2.0, 4.0))

        // Falla la segunda condición: a + c no es mayor que b
        assertFalse(demo.isTriangle(2.0, 4.0, 2.0))

        // Falla la tercera condición: b + c no es mayor que a
        assertFalse(demo.isTriangle(4.0, 2.0, 2.0))

        // Caso con números negativos
        assertFalse(demo.isTriangle(-1.0, 2.0, 2.0))
    }
}