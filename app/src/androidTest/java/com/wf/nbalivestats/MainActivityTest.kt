package com.wf.nbalivestats

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import com.wf.nbalivestats.NbaPlayers.ActivityNbaPlayers
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@MediumTest

class MainActivityTEST {

    @Before
    fun before() {
        Intents.init()
    }

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkButtonPlayersClick() {
        onView(withId(R.id.id_btn_players)).perform(click())
        intended(hasComponent(ActivityNbaPlayers::class.java.name))
    }

    @After
    fun after() {
        Intents.release()
    }
}
