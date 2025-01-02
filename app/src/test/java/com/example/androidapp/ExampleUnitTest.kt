package com.example.androidapp

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
}
class CredentialsManagerTest{
    private val credentialsManager = CredentialsManager
    @Test
    fun `test email with empty string returns false`(){
        val email = ""
        val result = credentialsManager.isEmailValid(email)
        assertFalse("Empty email string should be invalid", result)
    }
    @Test
    fun `test email with wrong format returns false`() {
        val email = "invalidemail.com"
        val result = credentialsManager.isEmailValid(email)
        assertFalse("Email without '@' or proper domain should be invalid", result)
    }

    @Test
    fun `test well-formatted email returns true`() {
        val email = "test@example.com"
        val result = credentialsManager.isEmailValid(email)
        assertTrue("Properly formatted email should be valid", result)
    }

    @Test
    fun `test password with empty string returns false`() {
        val password = ""
        val result = credentialsManager.isPasswordValid(password)
        assertFalse("Empty password string should be invalid", result)
    }

    @Test
    fun `test password with non-empty string returns true`() {
        val password = "securePassword123"
        val result = credentialsManager.isPasswordValid(password)
        assertTrue("Non-empty password string should be valid", result)
    }
}