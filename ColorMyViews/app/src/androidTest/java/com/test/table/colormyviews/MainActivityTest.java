package com.test.table.colormyviews;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import static androidx.test.core.app.ApplicationProvider.getApplicationContext;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasBackground;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static org.hamcrest.core.AllOf.allOf;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.InputStream;



@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {

//    @BeforeClass
//    public static void setupClass() {
//        throw new RuntimeException("Sorry dude, you won't find any test!");
//    }

    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule =
            new ActivityScenarioRule<MainActivity>(MainActivity.class);


    @Test
    public void correctTextTest(){
        onView(ViewMatchers.withId(R.id.box_one_text)).check(matches(withText("Hello World!")));

//        ViewInteraction viewInteraction=onView(ViewMatchers.withId(R.id.box_one_text))
//                .perform(click());

////                hasBackground(Color.DKGRAY)));
    }

    @Test
    public void correctColorTest() {

        int backgroundColor=Color.DKGRAY;
        onView(ViewMatchers.withId(R.id.box_one_text)).perform(click());
        //onView(allOf(ViewMatchers.withId(R.id.box_one_text),ViewMatchers.hasBackground(backgroundColor))).check(matches(isDisplayed()));
        onView(ViewMatchers.withId(R.id.box_one_text)).check(matches(colorMatcher(backgroundColor)));
//        onView(ViewMatchers.withId(R.id.box_one_text)).check(matches(hasBackground(backgroundColor)));
    }

    public static Matcher<View> colorMatcher (final int expectedColor) {

        return new TypeSafeMatcher<View>() {
            @Override public boolean matchesSafely (final View view) {
                ColorDrawable colorDrawable=(ColorDrawable)view.getBackground();
                int actualColorInt=colorDrawable.getColor();
                int actualColorIntOuter=actualColorInt;
                return actualColorInt == expectedColor;
            }

            @Override public void describeTo (final Description description) {
                description.appendText ("expected Color int should be " + expectedColor);
            }

        };

    }


//    Button button = (Button) findViewById(R.id.my_button);
//    Drawable buttonBackground = button.getBackground();
//
//
//    ColorDrawable b_color = (ColorDrawable) button.getBackground();
//
//    int color = b_color.getColor();
//if (color == R.color.green) {
//        log("color is green");


//    @Test
//    public void correctColorTest() {
//        onView(ViewMatchers.withId(R.id.box_one_text)).check(matches(hasBackground(Color.DKGRAY)));
//    }
}
