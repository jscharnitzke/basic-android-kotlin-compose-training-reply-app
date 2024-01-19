package com.example.reply.test

import androidx.activity.ComponentActivity
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.example.reply.R
import com.example.reply.ui.ReplyApp
import org.junit.Rule
import org.junit.Test

class ReplyAppTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    @TestCompactWidth
    fun compactDevice_verifyUsingBottomNavigation() {
        composeTestRule.setContent {
            ReplyApp(
                windowSize = WindowWidthSizeClass.Compact
            )
        }

        composeTestRule.onNodeWithTagForStringId(R.string.navigation_bottom).assertExists()
    }

    @Test
    @TestMediumWidth
    fun mediumDevice_verifyUsingRailNavigation() {
        composeTestRule.setContent {
            ReplyApp(
                windowSize = WindowWidthSizeClass.Medium
            )
        }

        composeTestRule.onNodeWithTagForStringId(R.string.navigation_rail).assertExists()
    }

    @Test
    @TestExpandedWidth
    fun expandedDevice_verifyUsingPermanentDrawerNavigation() {
        composeTestRule.setContent {
            ReplyApp(
                windowSize = WindowWidthSizeClass.Expanded
            )
        }

        composeTestRule.onNodeWithTagForStringId(R.string.navigation_drawer).assertExists()
    }
}