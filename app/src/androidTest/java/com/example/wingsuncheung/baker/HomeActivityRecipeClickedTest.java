package com.example.wingsuncheung.baker;


import android.app.Activity;
import android.app.Instrumentation;
import android.os.Parcelable;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.ViewAssertion;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.espresso.matcher.RootMatchers;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.wingsuncheung.baker.model.Bake;
import com.example.wingsuncheung.baker.model.Ingredient;
import com.example.wingsuncheung.baker.model.Step;
import com.example.wingsuncheung.baker.ui.HomeActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.parceler.Parcel;
import org.parceler.Parcels;

import static android.support.test.espresso.Espresso.onView;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.Intents.intending;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasData;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasExtra;
import static android.support.test.espresso.intent.matcher.IntentMatchers.isInternal;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.not;


import android.support.test.espresso.contrib.RecyclerViewActions;


@RunWith(AndroidJUnit4.class)
public class HomeActivityRecipeClickedTest {

    @Before
    public void stubInternalIntents () {
        intending(not(isInternal())).respondWith(new Instrumentation.ActivityResult(Activity.RESULT_OK, null));
    }

    @Rule
    public IntentsTestRule<HomeActivity> mHomeIntentRuleTest
            = new IntentsTestRule<>(HomeActivity.class);

    @Test
    public void clickOnTheFirstRecipe_showDetailView() {

        onView(withId(R.id.rv_recycler_recipe))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));

        Parcelable mock = mHomeIntentRuleTest.getActivity().getMock(); // Nutella pie

        Parcelable wrappedBake = Parcels.wrap(mock);

        intended(allOf(hasComponent(Bake.class.getName())));

    }
}
















