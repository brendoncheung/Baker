package com.example.wingsuncheung.baker;


import android.support.test.espresso.Espresso;
import android.support.test.espresso.ViewAssertion;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.wingsuncheung.baker.ui.HomeActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;


@RunWith(AndroidJUnit4.class)
public class HomeActivityRecipeClickedTest {

    @Rule
    public ActivityTestRule<HomeActivity>  mHomeActivityRuleTest
            = new ActivityTestRule<>(HomeActivity.class);

    @Test
    public void clickOnRecipe_showDetailView() {

        // 1) Find the view

        onView(withId(R.id.rv_recycler_recipe))
                .perform(click());

        // 2) Perform the action

        onView(withId(R.id.fl_detail_container))
                .check(matches(isDisplayed()));



        // 3) Check if the view does what you expected hello



    }

}
