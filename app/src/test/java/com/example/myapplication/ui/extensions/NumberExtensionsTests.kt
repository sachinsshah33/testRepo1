package com.example.myapplication.ui.extensions

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Test

class NumberExtensionsTests {
    @Test
    fun `test toPercentageOutOf1() works`() {
        assertEquals(4.toPercentageOutOf1(), 0.04f)
    }

    @Test
    fun `test toPercentageOutOf1() doesnt work`() {
        assertNotEquals(4.toPercentageOutOf1(), 0.4f)
    }

    @Test
    fun `test toPercentageOutOf1() doesnt work 2`() {
        assertNotEquals(4.toPercentageOutOf1(10), 0.04f)
    }
}