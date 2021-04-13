package com.example.testing2

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

//Espresso UI Testing
@RunWith(AndroidJUnit4::class)
class AddToBehaviorTest {
    @get:Rule
    var activityTestRule = androidx.test.rule.ActivityTestRule(MainActivity::class.java)
    @Test
    fun testAddToFavorite_CheckBoxNotChecked() {
        onView(withId(R.id.favorite_BTN))
            .perform(click())
        onView(withId(R.id.CB_Favorite))
            .check(matches(isNotChecked()))
    }
    @Test
    fun testAddToFavorite_CheckBoxChecked() {
        onView(withId(R.id.favorite_BTN))
            .perform(click())
        onView(withId(R.id.CB_Favorite))
            .check(matches(isChecked()))
    }
}