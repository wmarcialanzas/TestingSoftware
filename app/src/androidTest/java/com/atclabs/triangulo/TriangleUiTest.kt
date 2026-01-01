package com.atclabs.triangulo

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TriangleUiTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    // Caso 1: Triángulo Equilátero (Todos los lados iguales)
    @Test
    fun testEquilateralTriangle() {
        onView(withId(R.id.sideA)).perform(typeText("5"), closeSoftKeyboard())
        onView(withId(R.id.sideB)).perform(typeText("5"), closeSoftKeyboard())
        onView(withId(R.id.sideC)).perform(typeText("5"), closeSoftKeyboard())
        onView(withId(R.id.btnCheck)).perform(click())

        // Verifica el emoji y texto (ajusta según tus strings exactos)
        onView(withId(R.id.txtResult)).check(matches(withText("✅ Es un Triángulo Equilátero")))
    }

    // Caso 2: Triángulo Isósceles (Dos lados iguales)
    @Test
    fun testIsoscelesTriangle() {
        onView(withId(R.id.sideA)).perform(typeText("5"), closeSoftKeyboard())
        onView(withId(R.id.sideB)).perform(typeText("5"), closeSoftKeyboard())
        onView(withId(R.id.sideC)).perform(typeText("8"), closeSoftKeyboard())
        onView(withId(R.id.btnCheck)).perform(click())

        onView(withId(R.id.txtResult)).check(matches(withText("✅ Es un Triángulo Isósceles")))
    }

    // Caso 3: Triángulo Escaleno (Todos los lados diferentes)
    @Test
    fun testScaleneTriangle() {
        onView(withId(R.id.sideA)).perform(typeText("3"), closeSoftKeyboard())
        onView(withId(R.id.sideB)).perform(typeText("4"), closeSoftKeyboard())
        onView(withId(R.id.sideC)).perform(typeText("5"), closeSoftKeyboard())
        onView(withId(R.id.btnCheck)).perform(click())

        onView(withId(R.id.txtResult)).check(matches(withText("✅ Es un Triángulo Escaleno")))
    }

    // Caso 4: Lados que NO forman un triángulo (Desigualdad triangular)
    @Test
    fun testInvalidTriangleSides() {
        onView(withId(R.id.sideA)).perform(typeText("1"), closeSoftKeyboard())
        onView(withId(R.id.sideB)).perform(typeText("1"), closeSoftKeyboard())
        onView(withId(R.id.sideC)).perform(typeText("10"), closeSoftKeyboard())
        onView(withId(R.id.btnCheck)).perform(click())

        onView(withId(R.id.txtResult)).check(matches(withText("❌ No es un triángulo")))
    }

    // Caso 5: Entrada vacía (Manejo de errores/Crash)
    @Test
    fun testEmptyInputHandling() {
        // No escribimos nada y presionamos el botón directamente
        onView(withId(R.id.btnCheck)).perform(click())

        // Verifica que la app pida completar los datos en lugar de cerrarse
        onView(withId(R.id.txtResult)).check(matches(withText("⚠️ Ingrese todos los lados")))
    }
}