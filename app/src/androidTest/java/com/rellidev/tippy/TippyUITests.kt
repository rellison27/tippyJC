package com.rellidev.tippy

import androidx.compose.ui.test.isToggleable
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.test.performTouchInput
import androidx.compose.ui.test.printToLog
import androidx.compose.ui.test.swipeRight
import androidx.test.espresso.action.ViewActions.swipeRight
import com.rellidev.tippy.ui.theme.TippyTheme
import org.junit.Rule
import org.junit.Test
import java.text.NumberFormat

class TippyUITests
{
    @JvmField
    @Rule
    val composeTestRule = createComposeRule()

    @Test
    fun calculateTip_at_10Percent(){
        composeTestRule.setContent {
            TippyTheme {
                Tippy()
            }
        }

        composeTestRule.onNodeWithText("Bill Amount")
            .performTextInput("100")
        composeTestRule.onNodeWithTag("Slider").performClick()
        val expectedTip = NumberFormat.getCurrencyInstance().format(10)
        composeTestRule.onNodeWithText("Tip Amount: $expectedTip")
            .assertExists("No node with this text was found.")
    }

    @Test
    fun calculateTip_at_10PercentRoundsUp(){
        composeTestRule.setContent {
            TippyTheme {
                Tippy()
            }
        }

        composeTestRule.onNodeWithText("Bill Amount")
            .performTextInput("100.50")
        composeTestRule.onNodeWithTag("Slider").performClick()
        composeTestRule.onNode(isToggleable()).performClick()
        val expectedTip = NumberFormat.getCurrencyInstance().format(11)
        composeTestRule.onNodeWithText("Tip Amount: $expectedTip")
            .assertExists("No node with this text was found.")
    }
}