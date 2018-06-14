package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.InstrumentationTestCase;
import android.util.Pair;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class EndpointsAsyncTaskTest extends InstrumentationTestCase {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void buttonTestShowJoke() {
        onView(withId(R.id.instructions_text_view)).perform(click());
        try {
            testAsyncTask();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }


    private static String DEBUG = "SHLog: test:";
    private static String CLASS = "EndpointsAsyncTaskTest:";
    private final CountDownLatch signal = new CountDownLatch(1);

    public void testAsyncTask() throws Throwable {

        final EndpointsAsyncTask task = new EndpointsAsyncTask(InstrumentationRegistry.getTargetContext()) {

            @Override
            protected String doInBackground(Pair<Context, String>... params) {
                return super.doInBackground(params);
            }

            @Override
            protected void onPostExecute(String result) {
                assertNotNull(result);
                signal.countDown();
                onView(withId(R.id.joke_tv)).check(matches(isDisplayed()));
            }
        };

        runTestOnUiThread(new Runnable() {

            @Override
            public void run() {
                task.execute();
            }
        });
        signal.await(30, TimeUnit.SECONDS);
    }
}