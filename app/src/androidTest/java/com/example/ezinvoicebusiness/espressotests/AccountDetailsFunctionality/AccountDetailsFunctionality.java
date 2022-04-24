package com.example.ezinvoicebusiness.espressotests.AccountDetailsFunctionality;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.example.ezinvoicebusiness.LoginActivity;
import com.example.ezinvoicebusiness.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.TypeSafeMatcher;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import java.util.concurrent.TimeUnit;

@LargeTest
@RunWith(AndroidJUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AccountDetailsFunctionality {

    @Rule
    public ActivityTestRule<LoginActivity> mActivityTestRule = new ActivityTestRule<>(LoginActivity.class);

//    @Test
//    public void testOrder() throws InterruptedException {
//        Test1_loadAccountDetails();
//        Test2_changeEmail();
//        Test3_changePassword();
//        Test4_resetAccountDetails();
//    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }

    @Test
    public void Test1_loadAccountDetails() throws InterruptedException {
        ViewInteraction appCompatEditText = onView(
                Matchers.allOf(ViewMatchers.withId(R.id.email),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText.perform(replaceText("business@email.com"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.password),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        appCompatEditText2.perform(replaceText("password"), closeSoftKeyboard());

        ViewInteraction materialButton = onView(
                allOf(withId(R.id.btn_login), withText("Login"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        materialButton.perform(click());

        ViewInteraction bottomNavigationItemView = onView(
                allOf(withId(R.id.navigation_account_details), withContentDescription("Account Details"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_view),
                                        0),
                                2),
                        isDisplayed()));
        TimeUnit.SECONDS.sleep(2);
        bottomNavigationItemView.perform(click());

        ViewInteraction textView = onView(
                allOf(withId(R.id.lblAccountType), withText("Account Type: Business"),
                        withParent(withParent(withId(R.id.container))),
                        isDisplayed()));
        TimeUnit.SECONDS.sleep(2);
        textView.check(matches(withText("Account Type: Business")));

        ViewInteraction textView2 = onView(
                allOf(withId(R.id.lblDisplayName), withText("Business Name: Auto Repairs"),
                        withParent(withParent(withId(R.id.container))),
                        isDisplayed()));
        textView2.check(matches(withText("Business Name: Auto Repairs")));

        ViewInteraction textView3 = onView(
                allOf(withId(R.id.lblEmail), withText("Email:  business@email.com"),
                        withParent(withParent(withId(R.id.container))),
                        isDisplayed()));
        textView3.check(matches(withText("Email:  business@email.com")));
    }

    @Test
    public void Test2_changeEmail() throws InterruptedException {
        ViewInteraction appCompatEditText = onView(
                Matchers.allOf(ViewMatchers.withId(R.id.email),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText.perform(replaceText("business@email.com"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.password),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        appCompatEditText2.perform(replaceText("password"), closeSoftKeyboard());

        ViewInteraction materialButton = onView(
                allOf(withId(R.id.btn_login), withText("Login"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        materialButton.perform(click());

        ViewInteraction bottomNavigationItemView = onView(
                allOf(withId(R.id.navigation_account_details), withContentDescription("Account Details"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_view),
                                        0),
                                2),
                        isDisplayed()));
        TimeUnit.SECONDS.sleep(2);
        bottomNavigationItemView.perform(click());

        ViewInteraction materialButton2 = onView(
                allOf(withId(R.id.btnChangeEmail), withText("Change Email"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.container),
                                        1),
                                4),
                        isDisplayed()));
        TimeUnit.SECONDS.sleep(2);
        materialButton2.perform(click());

        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.newEmail),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.container),
                                        1),
                                2),
                        isDisplayed()));
        appCompatEditText3.perform(replaceText("auto@repairs.com"), closeSoftKeyboard());

        ViewInteraction appCompatEditText4 = onView(
                allOf(withId(R.id.newEmail), withText("auto@repairs.com"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.container),
                                        1),
                                2),
                        isDisplayed()));
        appCompatEditText4.perform(click());

        ViewInteraction appCompatEditText5 = onView(
                allOf(withId(R.id.newEmail), withText("auto@repairs.com"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.container),
                                        1),
                                2),
                        isDisplayed()));
        appCompatEditText5.perform(replaceText("auto@repairs.com"));

        ViewInteraction materialButton3 = onView(
                allOf(withId(R.id.btnUpdateEmail), withText("update email"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.container),
                                        1),
                                5),
                        isDisplayed()));
        materialButton3.perform(click());

        ViewInteraction textView4 = onView(
                allOf(withId(R.id.lblEmail), withText("Email:  auto@repairs.com"),
                        withParent(withParent(withId(R.id.container))),
                        isDisplayed()));
        textView4.check(matches(withText("Email:  auto@repairs.com")));
        TimeUnit.SECONDS.sleep(2);
    }

    @Test
    public void Test3_changePassword() throws InterruptedException {
        ViewInteraction appCompatEditText = onView(
                Matchers.allOf(ViewMatchers.withId(R.id.email),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText.perform(replaceText("auto@repairs.com"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.password),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        appCompatEditText2.perform(replaceText("password"), closeSoftKeyboard());

        ViewInteraction materialButton = onView(
                allOf(withId(R.id.btn_login), withText("Login"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        materialButton.perform(click());

        ViewInteraction bottomNavigationItemView = onView(
                allOf(withId(R.id.navigation_account_details), withContentDescription("Account Details"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_view),
                                        0),
                                2),
                        isDisplayed()));
        TimeUnit.SECONDS.sleep(2);
        bottomNavigationItemView.perform(click());

        ViewInteraction materialButton4 = onView(
                allOf(withId(R.id.btnChangePassword), withText("Change Password"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.container),
                                        1),
                                7),
                        isDisplayed()));
        TimeUnit.SECONDS.sleep(2);
        materialButton4.perform(click());

        ViewInteraction appCompatEditText8 = onView(
                allOf(withId(R.id.currentPassword),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.container),
                                        1),
                                0),
                        isDisplayed()));
        appCompatEditText8.perform(replaceText("password"), closeSoftKeyboard());

        ViewInteraction appCompatEditText9 = onView(
                allOf(withId(R.id.newPassword),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.container),
                                        1),
                                1),
                        isDisplayed()));
        appCompatEditText9.perform(replaceText("newpassword"), closeSoftKeyboard());

        ViewInteraction materialButton5 = onView(
                allOf(withId(R.id.btnUpdatePassword), withText("Update Password"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.container),
                                        1),
                                6),
                        isDisplayed()));
        materialButton5.perform(click());
        TimeUnit.SECONDS.sleep(2);
    }

    @Test
    public void Test4_resetAccountDetails() throws InterruptedException {
        ViewInteraction appCompatEditText = onView(
                Matchers.allOf(ViewMatchers.withId(R.id.email),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText.perform(replaceText("auto@repairs.com"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.password),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        appCompatEditText2.perform(replaceText("newpassword"), closeSoftKeyboard());

        ViewInteraction materialButton = onView(
                allOf(withId(R.id.btn_login), withText("Login"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        materialButton.perform(click());

        ViewInteraction bottomNavigationItemView = onView(
                allOf(withId(R.id.navigation_account_details), withContentDescription("Account Details"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_view),
                                        0),
                                2),
                        isDisplayed()));
        TimeUnit.SECONDS.sleep(2);
        bottomNavigationItemView.perform(click());

        ViewInteraction materialButton2 = onView(
                allOf(withId(R.id.btnChangeEmail), withText("Change Email"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.container),
                                        1),
                                4),
                        isDisplayed()));
        materialButton2.perform(click());

        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.newEmail),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.container),
                                        1),
                                2),
                        isDisplayed()));
        appCompatEditText3.perform(replaceText("business@email.com"), closeSoftKeyboard());

        ViewInteraction materialButton3 = onView(
                allOf(withId(R.id.btnUpdateEmail), withText("update email"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.container),
                                        1),
                                5),
                        isDisplayed()));
        materialButton3.perform(click());

        ViewInteraction textView = onView(
                allOf(withId(R.id.lblEmail), withText("Email:  business@email.com"),
                        withParent(withParent(withId(R.id.container))),
                        isDisplayed()));
        TimeUnit.SECONDS.sleep(2);
        textView.check(matches(withText("Email:  business@email.com")));

        ViewInteraction materialButton4 = onView(
                allOf(withId(R.id.btnChangePassword), withText("Change Password"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.container),
                                        1),
                                7),
                        isDisplayed()));
        materialButton4.perform(click());

        ViewInteraction appCompatEditText4 = onView(
                allOf(withId(R.id.currentPassword),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.container),
                                        1),
                                0),
                        isDisplayed()));
        appCompatEditText4.perform(replaceText("newpassword"), closeSoftKeyboard());

        ViewInteraction appCompatEditText5 = onView(
                allOf(withId(R.id.newPassword),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.container),
                                        1),
                                1),
                        isDisplayed()));
        appCompatEditText5.perform(replaceText("password"), closeSoftKeyboard());

        ViewInteraction materialButton5 = onView(
                allOf(withId(R.id.btnUpdatePassword), withText("Update Password"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.container),
                                        1),
                                6),
                        isDisplayed()));
        materialButton5.perform(click());
        TimeUnit.SECONDS.sleep(2);
    }
}
