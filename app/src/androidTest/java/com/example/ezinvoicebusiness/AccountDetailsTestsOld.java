package com.example.ezinvoicebusiness;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.navigation.testing.TestNavHostController;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class AccountDetailsTestsOld {

//    @Before
//    public void setUp() throws Exception{
//        Intents.init();
////        Intents.release();
//    }

//    @After
//    public void tearDown() throws Exception{
//        Intents.release();
//    }

    @Rule
//    public ActivityTestRule<LoginActivity> activityActivityTestRule = new ActivityTestRule<LoginActivity>(LoginActivity.class);
//    public ActivityScenarioRule<LoginActivity> rules = new ActivityScenarioRule<>(LoginActivity.class);
    public IntentsTestRule<LoginActivity> rule = new IntentsTestRule<>(LoginActivity.class);

    @Test
    public void noPassword() throws InterruptedException {
        onView(ViewMatchers.withId(R.id.email)).perform(typeText("m@rio.com"));
        onView(withId(R.id.btn_login)).perform(click());
//        IntentsTestRule<MainActivity> rule = new IntentsTestRule<>(MainActivity.class);
//        onView(withId(R.id.nav_view)).perform(NavigationViewActions.navigateTo(R.id.navigation_account_details));
        onView(withText("Account Details"));
        TestNavHostController navController = new TestNavHostController(
                ApplicationProvider.getApplicationContext());
//        TimeUnit.SECONDS.sleep(5);

    }
}
