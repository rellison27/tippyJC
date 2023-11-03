package com.rellidev.tippy

import org.junit.Test
import org.junit.Assert.*
import java.text.NumberFormat

class TipCalculatorTests
{
    @Test
    fun `When calculateTip is invoked with no tipPercent it will calculate 15 percent by default`()
    {
        // given
        val bill = 100.00
        val actualValue = calculateTip(bill, roundUp = false)
        val expectedValue = NumberFormat.getCurrencyInstance().format(15.00)

        // then
        assertEquals(expectedValue, actualValue)
    }

    @Test
    fun `When calculateTip is invoked with a tipPercent value of 20 and bill amount 100 value of 20 is returned`()
    {
        // given
        val bill = 100.00
        val tipPercent = 20.0
        val actualValue = calculateTip(bill, tipPercent = tipPercent, roundUp = false)
        val expectedValue = NumberFormat.getCurrencyInstance().format(20.00)

        // then
        assertEquals(expectedValue, actualValue)
    }

    @Test
    fun `When calculateTip is invoked with a true value for roundUp the value returned is rounded up`()
    {
        // given
        val bill = 100.50
        val tipPercent = 20.0
        val actualValue = calculateTip(bill, tipPercent = tipPercent, roundUp = true)
        val expectedValue = NumberFormat.getCurrencyInstance().format(21.00)

        // then
        assertEquals(expectedValue, actualValue)
    }
}