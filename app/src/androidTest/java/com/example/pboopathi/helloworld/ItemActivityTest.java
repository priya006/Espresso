package com.example.pboopathi.helloworld;

import android.app.Activity;
import android.support.test.rule.ActivityTestRule;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.*;
import static com.example.pboopathi.helloworld.custom.CustomMatcher.withToolbarTitle;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.AllOf.allOf;

public class ItemActivityTest {

    private static final int TOOLBAR = R.id.toolbar;
    private static final int EDIT_TEXT = R.id.editText;
    private static final int BUTTON = R.id.button;
    private static final int TEXT_VIEW = R.id.textView;
    private Activity activity;

    @Rule
    public ActivityTestRule<ItemActivity> itemActivityTestRule = new ActivityTestRule<ItemActivity>(ItemActivity.class);

    @Before
    public void setUp() throws Exception {
        activity = itemActivityTestRule.getActivity();
    }

    @Test
    public void itemPurchaseTest() {

        onView(withId(TOOLBAR)).check(matches(allOf(isDisplayed(), withToolbarTitle(activity.getString(R.string.title_activity_item)))));
        onView(withId(EDIT_TEXT)).check(matches(withId(EDIT_TEXT)));
        onView(withId(EDIT_TEXT)).check(matches(withText(" Total:  600")));
        onView(withId(EDIT_TEXT)).check(matches(withText(containsString("600"))));
        onView(withId(BUTTON)).check(matches(isDisplayed()));
        onView(withId(BUTTON)).check(matches(isClickable()));
        onView(withId(BUTTON)).check(matches(allOf(isEnabled(), isClickable()))).perform(click());
        onView(withId(TOOLBAR)).check(matches(allOf(isDisplayed(), withToolbarTitle(activity.getString(R.string.title_activity_success_screen)))));
        onView(withId(TEXT_VIEW)).check(matches(withText(R.string.message_activity_success_screen)));

    }
}