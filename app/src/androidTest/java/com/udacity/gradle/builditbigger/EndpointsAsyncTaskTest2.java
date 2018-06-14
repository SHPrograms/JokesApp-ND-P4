package com.udacity.gradle.builditbigger;

import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.filters.LargeTest;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.toPackage;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

//import android.support.v4.util.Pair;

//V1
/*

@RunWith(AndroidJUnit4.class)
public class EndpointsAsyncTaskTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void buttonTestShowJoke() {
        onView(withId(R.id.instructions_text_view)).perform(click());

        onView(withId(R.id.joke_tv)).check(matches(not(withText(""))));
    }
}
*/


// v2

@RunWith(AndroidJUnit4.class)
@LargeTest
public class EndpointsAsyncTaskTest2 {
        @Rule
        public IntentsTestRule<MainActivity> mActivityRule =
                new IntentsTestRule<MainActivity>(MainActivity.class);
    @Test
    public void buttonTestShowJoke() {
        onView(withId(R.id.instructions_text_view)).perform(click());
        onView(withId(R.id.joke_tv)).check(matches(isDisplayed()));
//         intended(toPackage("com.sh.study.udacitynano.jokeandroidlibrary.JokesActivity"));
    }
}

// v3
/*
@RunWith(AndroidJUnit4.class)
public class EndpointsAsyncTaskTest {
    public void test() throws InterruptedException, ExecutionException, TimeoutException {
        EndpointsAsyncTask test = new EndpointsAsyncTask(InstrumentationRegistry.getContext());
        test.execute(new Pair<Context, String>(InstrumentationRegistry.getContext(), null));
        String joke = test.get(5, TimeUnit.SECONDS);
        Assert.assertEquals("Some greate joke", joke);
    }
}
*/

// v4
/*
public class EndpointsAsyncTaskTest extends InstrumentationTestCase {
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
//                super.onPostExecute(result);
                assertNotNull(result);
                signal.countDown();
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
*/


// Other configurations:
/*
    //    public void test() throws Throwable {
    public void testAsync() throws Throwable {

        final EndpointsAsyncTask jokefetch = new EndpointsAsyncTask(null) {
            @Override
            protected String doInBackground(Pair<Context, String>... params) {
                Log.d(DEBUG, CLASS + "doInBackground: start");
                return super.doInBackground(params);
            }

            @Override
            protected void onPostExecute(String result) {
                Log.d(DEBUG, CLASS + "onPostExecute: start, result= " + result);
//                super.onPostExecute(result);
                assertNotNull(result);
                signal.countDown();
            }
            *//*
            @Override
            protected void onPostExecute(ArrayList<String> result) {
                assertNotNull(result);
                String resultCode = result.get(0);
                String resultString = result.get(1);
//                assertEquals(Utilities.SUCCESS, resultCode);
                assertNotNull(resultString);
                signal.countDown();
            }
*//*
        };

        runTestOnUiThread(new Runnable() {
            @Override
            public void run() {
                Log.d(DEBUG, CLASS + "run: start");
*//*
                EndpointsAsyncTask asyncTask = new EndpointsAsyncTask(null);
                asyncTask.execute(new Pair<Context, String>(InstrumentationRegistry.getContext(), "Hey This is joke"));
                jokefetch.execute(new Pair<Context, String>(InstrumentationRegistry.getContext(), null));
*//*
                String joke = null;
                try {
                    joke = jokefetch.get(5, TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (TimeoutException e) {
                    e.printStackTrace();
                }
                Assert.assertEquals("Some greate joke",joke);

            }
        });
        signal.await(30, TimeUnit.SECONDS);
    }*/

