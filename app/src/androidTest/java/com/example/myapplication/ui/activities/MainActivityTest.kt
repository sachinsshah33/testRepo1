package com.example.myapplication.ui.activities

import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.myapplication.ui.theme.MyApplicationTheme
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun dashboardTest() {
        composeTestRule.setContent {
            MyApplicationTheme {
                Dashboard()
            }
        }
        //todo, need to mock viewModel properly

        composeTestRule.onNodeWithTag("Refresh").performClick()
        composeTestRule.onNodeWithTag("SubscriptionMilesLeftCircularProgressIndicator_Text").assertTextEquals("747")
        composeTestRule.onNodeWithTag("LastEnergyLevelCircularProgressIndicator_Text").assertTextEquals("72")
    }
}