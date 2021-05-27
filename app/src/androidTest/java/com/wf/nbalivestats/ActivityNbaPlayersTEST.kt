package com.wf.nbalivestats

import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.wf.nbalivestats.NbaPlayers.ActivityNbaPlayers
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ActivityNbaPlayersTEST {

    //DO this
    @Before
    fun before() {
        Intents.init()
    }

    @get:Rule
    val activityRule = ActivityScenarioRule(ActivityNbaPlayers::class.java)

    @Test
    fun useEditText() {
        Espresso.onView(withId(R.id.et_pick_your_player))
            .perform(ViewActions.clearText()).perform(ViewActions.click()).perform(
                ViewActions.typeText("Michael Jordan")
            )
    }

    @Test
    fun useFindBtn() {
        Espresso.onView(withId(R.id.btn_find_your_player)).perform(ViewActions.click())
    }

    //TODO: Check if recyclerview comes into view
    /*
    @Test
    fun findRecyclerView(){
        Espresso.onView(withId(R.id.rv_players)).perform()
    }
    */

    @After
    fun after() {
        Intents.release()
    }
}