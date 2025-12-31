package com.atclabs.triangulo
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test
import org.junit.Assert.assertEquals // Este import quita el error de assertEquals

class TriangleValidatorTest {

    @Test
    fun testValidateWithMockk() {
        // 1. Creamos el mock de la clase Demo que ya es 'open'
        val demoMock = mockk<Demo>()

        // 2. Creamos el validador usando el mock
        val validator = TriangleValidator(demoMock)

        // 3. Programamos el comportamiento (Stubbing)
        every { demoMock.isTriangle(3.0, 3.0, 3.0) } returns true

        // 4. Ejecutamos la lógica del validador
        val result = validator.validate(3.0, 3.0, 3.0)

        // 5. Verificamos resultados
        assertEquals("Es un triángulo válido", result)

        // Verificamos que el validador realmente consultó a la clase Demo
        verify(exactly = 1) { demoMock.isTriangle(3.0, 3.0, 3.0) }
    }
    @Test
    fun testValidate_InvalidTriangle_ReturnsErrorMessage() {
        // 1. Preparamos el mock
        val demoMock = mockk<Demo>()
        val validator = TriangleValidator(demoMock)

        // 2. Programamos el mock para que devuelva FALSE
        // No importa que 3,3,3 sea un triángulo real, el mock obedecerá y dirá que no lo es
        every { demoMock.isTriangle(3.0, 3.0, 3.0) } returns false

        // 3. Ejecutamos
        val result = validator.validate(3.0, 3.0, 3.0)

        // 4. Verificamos que devuelva el mensaje de error del 'else'
        assertEquals("No es un triángulo", result)

        // Verificamos la interacción
        verify(exactly = 1) { demoMock.isTriangle(3.0, 3.0, 3.0) }
    }
}