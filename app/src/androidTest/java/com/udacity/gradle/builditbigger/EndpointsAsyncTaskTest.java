package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
//import android.support.v4.util.Pair;
import android.test.InstrumentationTestCase;
import android.util.Log;
import android.util.Pair;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.toPackage;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.*;

import com.udacity.gradle.builditbigger.EndpointsAsyncTask;

//V1
/*

@RunWith(AndroidJUnit4.class)
public class EndpointsAsyncTaskTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void buttonTestShowJoke() {
        onView(withId(R.id.instructions_text_view)).perform(click());

        onView(withId(R.id.joke_tv)).check(matches(isDisplayed()));
    }
}
*/

// v2
@RunWith(AndroidJUnit4.class)
@LargeTest
public class EndpointsAsyncTaskTest {
        @Rule
        public IntentsTestRule<MainActivity> mActivityRule =
                new IntentsTestRule<MainActivity>(MainActivity.class);
    @Test
    public void buttonTestShowJoke() {
        onView(withId(R.id.instructions_text_view)).perform(click());
        onView(withId(R.id.joke_tv)).check(matches(isDisplayed()));
         intended(toPackage("com.sh.study.udacitynano.jokeandroidlibrary.JokesActivity"));
    }
}
