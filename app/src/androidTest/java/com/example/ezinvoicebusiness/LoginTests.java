package com.example.ezinvoicebusiness;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class LoginTests {

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

//    @Before
//    public void init(){
//        ActivityScenarioRule.getActivity()
//                .getSupportFragmentManager().beginTransaction();
//    }
//    @Rule
//    public ActivityScenarioRule<LoginActivity> activityRule =
//            new ActivityScenarioRule<>(LoginActivity.class);

    @Test
    public void validLoginDetails() {
//        onView(withId(R.id.btn_login));

//        onView(withId(R.id.container)).check(matches(isDisplayed()));
//        onView(withId(R.id.frag)).check(matches(isDisplayed()))

//        onView(withId(R.id.btn_login)).check(matches(isDisplayed()));
//        getViewAssertion(ViewMatchers.Visibility.VISIBLE);
//        onView(withId(R.id.progressBar)).isVisible();
//        onView(withId(R.id.btn_login)).check(matches(isDisplayed()));

//        try {
//            onView(withText("Login")).perform(click());
//            Log.d("tag_here", "click successful");
//            // View is in hierarchy
//
//        } catch (NoMatchingViewException e) {
//            // View is not in hierarchy
//            Log.d("tag_here", "no action was taken :(");
//        }
//        onView(withText("Login")).check(matches(isDisplayed()));
        onView(withId(R.id.email)).perform(typeText("m@rio.com"));
//        onView(withId(R.id.password)).perform(typeText("pass"));
        onView(withId(R.id.btn_login)).perform(click());
        onView(withId(R.id.btn_login)).check(matches((isDisplayed())));

//        onView.getContext();
//        onView(getClass())

//        intended(isDisplayed(MainActivity.class));

//        String templatePictureActivityClassName = TemplatePictureCaptureActivity.class.getName();
//        Espresso.registerIdlingResources(new WaitActivityIsResumedIdlingResource(templatePictureActivityClassName));
//        Intents.init();
//        rule.launchActivity(new Intent());
//
//        Intent receivedIntent = Iterables.getOnlyElement(Intents.getIntents());
//
//        intended(hasComponent(hasShortClassName(".MainActivity")));
//        intended(hasComponent(LoginActivity.class.getName()));
//        Intents.release();
//        intended(hasComponent(new ComponentName(getTargetContext(), LoginActivity.class)));
//        intended(hasComponent(LoginActivity.class.getName()));

//        intended(hasComponent(new ComponentName(getTargetContext(), MainActivity.class)));
//        onView(withText("My Invoices")).check(matches(isDisplayed()));
    }

    @Test
    public void invalidLoginDetails() {

    }
//    private View decorView;

    @Test
    public void noEmail() throws InterruptedException {
        onView(withId(R.id.btn_login)).perform(click());
//        onView(withText(R.string.enter_email_address))
//                .inRoot(withDecorView(not(rule.getActivity().getWindow().getDecorView())))
//                .check(matches(isDisplayed()));

//        onView(withText(R.string.enter_email_address)).inRoot(withDecorView((is(rule.getActivity().getWindow().getDecorView())))).check(matches(isDisplayed()));
//        rule.getActivity().getWindow().getDecorView().check(matches(not(isDisplayed())));

//        onView(withText("Enter email address"))
//                .inRoot(withDecorView(not(rule.getActivity().getWindow().getDecorView())))
//                .check(matches(isDisplayed()));
//        onView(withText(R.string.please_input_all_fields))
//                .inRoot(ToastMatcher())
//                .check(matches(isDisplayed()))

//        onView(withText(R.string.toast_text)).inRoot(withDecorView(not(mActivityRule.getActivity().getWindow().getDecorView()))).check(matches(isDisplayed()))
//        onView(withText(R.string.enter_email_address)).
//                inRoot(withDecorView(not(is(rule.getActivity().getWindow().getDecorView())))).
//                check(matches(isDisplayed()));
//        decorView = getClass().getWindow().getDecorView();

//        onView(withText(R.string.enter_email_address))
//                .inRoot(withDecorView(not(decorView)))// Here we use decorView
//                .check(matches(isDisplayed()));
    }

    @Test
    public void noPassword() throws InterruptedException {
        onView(withId(R.id.email)).perform(typeText("m@rio.com"));
        onView(withId(R.id.btn_login)).perform(click());
//        IntentsTestRule<AccountDetailsActivity> rule = new IntentsTestRule<>(AccountDetailsActivity.class);
        TimeUnit.SECONDS.sleep(5);
    }
}
//    public void noPassword() throws InterruptedException {
//        onView(withId(R.id.email)).perform(typeText("m@rio.com"));
//        onView(withId(R.id.btn_login)).perform(click());
////        IntentsTestRule<MainActivity> rule = new IntentsTestRule<>(MainActivity.class);
//        onView(withId(R.id.nav_view)).perform(NavigationViewActions.navigateTo(R.id.navigation_account_details));
//        TimeUnit.SECONDS.sleep(5);