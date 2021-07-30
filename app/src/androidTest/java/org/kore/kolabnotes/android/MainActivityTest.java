package org.kore.kolabnotes.android;

import android.os.SystemClock;
import android.view.InputDevice;
import android.view.MotionEvent;
import android.view.View;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.action.CoordinatesProvider;
import androidx.test.espresso.action.GeneralLocation;
import androidx.test.espresso.action.GeneralSwipeAction;
import androidx.test.espresso.action.Press;
import androidx.test.espresso.action.Swipe;
import androidx.test.espresso.action.Tap;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.filters.LargeTest;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;

@LargeTest
public class MainActivityTest {

    @Rule
    public androidx.test.ext.junit.rules.ActivityScenarioRule<MainActivity> mActivityTestRule = new androidx.test.ext.junit.rules.ActivityScenarioRule<>(MainActivity.class);

    private static Matcher<View> classOrSuperClassesName(final Matcher<String> classNameMatcher) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Class name or any super class name ");
                classNameMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                Class<?> clazz = view.getClass();
                String canonicalName;

                do {
                    canonicalName = clazz.getCanonicalName();
                    if (canonicalName == null) {
                        return false;
                    }

                    if (classNameMatcher.matches(canonicalName)) {
                        return true;
                    }

                    clazz = clazz.getSuperclass();
                    if (clazz == null) {
                        return false;
                    }
                } while (!"java.lang.Object".equals(canonicalName));

                return false;
            }
        };
    }

    private static Matcher<View> withTextOrHint(final Matcher<String> stringMatcher) {
        return Matchers.anyOf(ViewMatchers.withText(stringMatcher), ViewMatchers.withHint(stringMatcher));
    }

    @Test
    public void mainActivityTest() {
        ViewInteraction root = Espresso.onView(ViewMatchers.isRoot());
        root.perform(getSwipeAction(540, 897, 540, 1794));

        waitToScrollEnd();

        ViewInteraction root2 = Espresso.onView(ViewMatchers.isRoot());
        root2.perform(getSwipeAction(540, 897, 540, 1794));

        waitToScrollEnd();

        ViewInteraction android_widget_ImageButton =
                Espresso.onView(
                        Matchers.allOf(
                                ViewMatchers.withContentDescription(IsEqualTrimmingAndIgnoringCase.equalToTrimmingAndIgnoringCase("Navigate up")),
                                VisibleViewMatcher.isVisible(),
                                ViewMatchers.isDescendantOfA(
                                        Matchers.allOf(
                                                ViewMatchers.withId(R.id.toolbar),
                                                ViewMatchers.isDescendantOfA(
                                                        Matchers.allOf(
                                                                ViewMatchers.withId(R.id.activity_main_frame),
                                                                ViewMatchers.isDescendantOfA(ViewMatchers.withId(R.id.activity_main))))))));
        android_widget_ImageButton.perform(getClickAction());

        ViewInteraction androidx_appcompat_widget_LinearLayoutCompat =
                Espresso.onView(
                        Matchers.allOf(
                                classOrSuperClassesName(Matchers.is("androidx.appcompat.widget.LinearLayoutCompat")),
                                VisibleViewMatcher.isVisible(),
                                ViewMatchers.hasDescendant(
                                        Matchers.allOf(
                                                ViewMatchers.withId(R.id.design_menu_item_text),
                                                withTextOrHint(IsEqualTrimmingAndIgnoringCase.equalToTrimmingAndIgnoringCase("Notes from all accounts")))),
                                ViewMatchers.isDescendantOfA(
                                        Matchers.allOf(
                                                ViewMatchers.withId(R.id.design_navigation_view),
                                                ViewMatchers.isDescendantOfA(
                                                        Matchers.allOf(
                                                                ViewMatchers.withId(R.id.navigation_view),
                                                                ViewMatchers.isDescendantOfA(ViewMatchers.withId(R.id.activity_main))))))));
        androidx_appcompat_widget_LinearLayoutCompat.perform(getClickAction());

        ViewInteraction root3 = Espresso.onView(ViewMatchers.isRoot());
        root3.perform(getSwipeAction(540, 897, 540, 1794));

        waitToScrollEnd();

        ViewInteraction android_widget_ImageView =
                Espresso.onView(
                        Matchers.allOf(
                                ViewMatchers.withContentDescription(IsEqualTrimmingAndIgnoringCase.equalToTrimmingAndIgnoringCase("More options")),
                                VisibleViewMatcher.isVisible(),
                                ViewMatchers.isDescendantOfA(
                                        Matchers.allOf(
                                                ViewMatchers.withId(R.id.toolbar),
                                                ViewMatchers.isDescendantOfA(
                                                        Matchers.allOf(
                                                                ViewMatchers.withId(R.id.activity_main_frame),
                                                                ViewMatchers.isDescendantOfA(ViewMatchers.withId(R.id.activity_main))))))));
        android_widget_ImageView.perform(getClickAction());

        ViewInteraction android_widget_LinearLayout =
                Espresso.onView(
                        Matchers.allOf(
                                classOrSuperClassesName(Matchers.is("android.widget.LinearLayout")),
                                VisibleViewMatcher.isVisible(),
                                ViewMatchers.hasDescendant(
                                        Matchers.allOf(
                                                ViewMatchers.withId(R.id.content),
                                                ViewMatchers.hasDescendant(
                                                        Matchers.allOf(
                                                                ViewMatchers.withId(R.id.title),
                                                                withTextOrHint(
                                                                        IsEqualTrimmingAndIgnoringCase.equalToTrimmingAndIgnoringCase("New Notebook"))))))));
        android_widget_LinearLayout.perform(getClickAction());

        ViewInteraction android_widget_EditText =
                Espresso.onView(
                        Matchers.allOf(
                                ViewMatchers.withId(R.id.dialog_text_input_field),
                                withTextOrHint(IsEqualTrimmingAndIgnoringCase.equalToTrimmingAndIgnoringCase("Summary")),
                                VisibleViewMatcher.isVisible()));
        android_widget_EditText.perform(ViewActions.replaceText("leucoplast"));

        Espresso.pressBackUnconditionally();

        ViewInteraction android_widget_TextView =
                Espresso.onView(
                        Matchers.allOf(
                                ViewMatchers.withId(R.id.action_search),
                                VisibleViewMatcher.isVisible(),
                                ViewMatchers.isDescendantOfA(
                                        Matchers.allOf(
                                                ViewMatchers.withId(R.id.toolbar),
                                                ViewMatchers.isDescendantOfA(
                                                        Matchers.allOf(
                                                                ViewMatchers.withId(R.id.activity_main_frame),
                                                                ViewMatchers.isDescendantOfA(ViewMatchers.withId(R.id.activity_main))))))));
        android_widget_TextView.perform(getClickAction());

        ViewInteraction android_widget_TextView2 =
                Espresso.onView(
                        Matchers.allOf(
                                ViewMatchers.withId(R.id.tag_list),
                                VisibleViewMatcher.isVisible(),
                                ViewMatchers.isDescendantOfA(
                                        Matchers.allOf(
                                                ViewMatchers.withId(R.id.toolbar),
                                                ViewMatchers.isDescendantOfA(
                                                        Matchers.allOf(
                                                                ViewMatchers.withId(R.id.activity_main_frame),
                                                                ViewMatchers.isDescendantOfA(ViewMatchers.withId(R.id.activity_main))))))));
        android_widget_TextView2.perform(getClickAction());

        ViewInteraction android_widget_ImageButton2 =
                Espresso.onView(
                        Matchers.allOf(
                                ViewMatchers.withContentDescription(IsEqualTrimmingAndIgnoringCase.equalToTrimmingAndIgnoringCase("Navigate up")),
                                VisibleViewMatcher.isVisible(),
                                ViewMatchers.isDescendantOfA(
                                        Matchers.allOf(
                                                ViewMatchers.withId(R.id.toolbar_tag_list),
                                                ViewMatchers.isDescendantOfA(ViewMatchers.withId(R.id.activity_tag_list))))));
        android_widget_ImageButton2.perform(getClickAction());

        Espresso.pressBackUnconditionally();

        ViewInteraction android_widget_ImageView2 =
                Espresso.onView(
                        Matchers.allOf(
                                ViewMatchers.withContentDescription(IsEqualTrimmingAndIgnoringCase.equalToTrimmingAndIgnoringCase("More options")),
                                VisibleViewMatcher.isVisible(),
                                ViewMatchers.isDescendantOfA(
                                        Matchers.allOf(
                                                ViewMatchers.withId(R.id.toolbar),
                                                ViewMatchers.isDescendantOfA(
                                                        Matchers.allOf(
                                                                ViewMatchers.withId(R.id.activity_main_frame),
                                                                ViewMatchers.isDescendantOfA(ViewMatchers.withId(R.id.activity_main))))))));
        android_widget_ImageView2.perform(getClickAction());

        ViewInteraction android_widget_LinearLayout2 =
                Espresso.onView(
                        Matchers.allOf(
                                classOrSuperClassesName(Matchers.is("android.widget.LinearLayout")),
                                VisibleViewMatcher.isVisible(),
                                ViewMatchers.hasDescendant(
                                        Matchers.allOf(
                                                ViewMatchers.withId(R.id.content),
                                                ViewMatchers.hasDescendant(
                                                        Matchers.allOf(
                                                                ViewMatchers.withId(R.id.title),
                                                                withTextOrHint(
                                                                        IsEqualTrimmingAndIgnoringCase.equalToTrimmingAndIgnoringCase("Export notebook"))))))));
        android_widget_LinearLayout2.perform(getClickAction());

        ViewInteraction root4 = Espresso.onView(ViewMatchers.isRoot());
        root4.perform(getSwipeAction(540, 897, 540, 1794));

        waitToScrollEnd();

        ViewInteraction root5 = Espresso.onView(ViewMatchers.isRoot());
        root5.perform(getSwipeAction(540, 897, 540, 1794));

        waitToScrollEnd();

        ViewInteraction android_widget_ImageButton3 =
                Espresso.onView(
                        Matchers.allOf(
                                ViewMatchers.withId(R.id.fab_button),
                                VisibleViewMatcher.isVisible(),
                                ViewMatchers.isDescendantOfA(
                                        Matchers.allOf(
                                                ViewMatchers.withId(R.id.coordinator_overview),
                                                ViewMatchers.isDescendantOfA(
                                                        Matchers.allOf(
                                                                ViewMatchers.withId(R.id.overview_fragment),
                                                                ViewMatchers.isDescendantOfA(
                                                                        Matchers.allOf(
                                                                                ViewMatchers.withId(R.id.activity_main_frame),
                                                                                ViewMatchers.isDescendantOfA(ViewMatchers.withId(R.id.activity_main))))))))));
        android_widget_ImageButton3.perform(getClickAction());

        Espresso.pressBackUnconditionally();

        ViewInteraction android_widget_EditText2 =
                Espresso.onView(
                        Matchers.allOf(
                                ViewMatchers.withId(R.id.search_src_text),
                                withTextOrHint(IsEqualTrimmingAndIgnoringCase.equalToTrimmingAndIgnoringCase("   Note summary")),
                                VisibleViewMatcher.isVisible(),
                                ViewMatchers.isDescendantOfA(
                                        Matchers.allOf(
                                                ViewMatchers.withId(R.id.search_plate),
                                                ViewMatchers.isDescendantOfA(
                                                        Matchers.allOf(
                                                                ViewMatchers.withId(R.id.search_edit_frame),
                                                                ViewMatchers.isDescendantOfA(
                                                                        Matchers.allOf(
                                                                                ViewMatchers.withId(R.id.search_bar),
                                                                                ViewMatchers.isDescendantOfA(
                                                                                        Matchers.allOf(
                                                                                                ViewMatchers.withId(R.id.action_search),
                                                                                                ViewMatchers.isDescendantOfA(
                                                                                                        Matchers.allOf(
                                                                                                                ViewMatchers.withId(R.id.toolbar),
                                                                                                                ViewMatchers.isDescendantOfA(
                                                                                                                        Matchers.allOf(
                                                                                                                                ViewMatchers.withId(R.id.activity_main_frame),
                                                                                                                                ViewMatchers.isDescendantOfA(
                                                                                                                                        ViewMatchers.withId(
                                                                                                                                                R.id
                                                                                                                                                        .activity_main))))))))))))))));
        android_widget_EditText2.perform(ViewActions.replaceText("florescent"));

        ViewInteraction android_widget_TextView3 =
                Espresso.onView(
                        Matchers.allOf(
                                ViewMatchers.withId(R.id.tag_list),
                                VisibleViewMatcher.isVisible(),
                                ViewMatchers.isDescendantOfA(
                                        Matchers.allOf(
                                                ViewMatchers.withId(R.id.toolbar),
                                                ViewMatchers.isDescendantOfA(
                                                        Matchers.allOf(
                                                                ViewMatchers.withId(R.id.activity_main_frame),
                                                                ViewMatchers.isDescendantOfA(ViewMatchers.withId(R.id.activity_main))))))));
        android_widget_TextView3.perform(getClickAction());

        ViewInteraction android_widget_ImageButton4 =
                Espresso.onView(
                        Matchers.allOf(
                                ViewMatchers.withContentDescription(IsEqualTrimmingAndIgnoringCase.equalToTrimmingAndIgnoringCase("Navigate up")),
                                VisibleViewMatcher.isVisible(),
                                ViewMatchers.isDescendantOfA(
                                        Matchers.allOf(
                                                ViewMatchers.withId(R.id.toolbar_tag_list),
                                                ViewMatchers.isDescendantOfA(ViewMatchers.withId(R.id.activity_tag_list))))));
        android_widget_ImageButton4.perform(getClickAction());

        ViewInteraction android_widget_ImageView3 =
                Espresso.onView(
                        Matchers.allOf(
                                ViewMatchers.withContentDescription(IsEqualTrimmingAndIgnoringCase.equalToTrimmingAndIgnoringCase("More options")),
                                VisibleViewMatcher.isVisible(),
                                ViewMatchers.isDescendantOfA(
                                        Matchers.allOf(
                                                ViewMatchers.withId(R.id.toolbar),
                                                ViewMatchers.isDescendantOfA(
                                                        Matchers.allOf(
                                                                ViewMatchers.withId(R.id.activity_main_frame),
                                                                ViewMatchers.isDescendantOfA(ViewMatchers.withId(R.id.activity_main))))))));
        android_widget_ImageView3.perform(getClickAction());

        ViewInteraction android_widget_LinearLayout3 =
                Espresso.onView(
                        Matchers.allOf(
                                classOrSuperClassesName(Matchers.is("android.widget.LinearLayout")),
                                VisibleViewMatcher.isVisible(),
                                ViewMatchers.hasDescendant(
                                        Matchers.allOf(
                                                ViewMatchers.withId(R.id.content),
                                                ViewMatchers.hasDescendant(
                                                        Matchers.allOf(
                                                                ViewMatchers.withId(R.id.title),
                                                                withTextOrHint(
                                                                        IsEqualTrimmingAndIgnoringCase.equalToTrimmingAndIgnoringCase("New Notebook"))))))));
        android_widget_LinearLayout3.perform(getClickAction());

        Espresso.pressBackUnconditionally();

        ViewInteraction android_widget_ImageView4 =
                Espresso.onView(
                        Matchers.allOf(
                                ViewMatchers.withId(R.id.search_close_btn),
                                VisibleViewMatcher.isVisible(),
                                ViewMatchers.isDescendantOfA(
                                        Matchers.allOf(
                                                ViewMatchers.withId(R.id.search_plate),
                                                ViewMatchers.isDescendantOfA(
                                                        Matchers.allOf(
                                                                ViewMatchers.withId(R.id.search_edit_frame),
                                                                ViewMatchers.isDescendantOfA(
                                                                        Matchers.allOf(
                                                                                ViewMatchers.withId(R.id.search_bar),
                                                                                ViewMatchers.isDescendantOfA(
                                                                                        Matchers.allOf(
                                                                                                ViewMatchers.withId(R.id.action_search),
                                                                                                ViewMatchers.isDescendantOfA(
                                                                                                        Matchers.allOf(
                                                                                                                ViewMatchers.withId(R.id.toolbar),
                                                                                                                ViewMatchers.isDescendantOfA(
                                                                                                                        Matchers.allOf(
                                                                                                                                ViewMatchers.withId(R.id.activity_main_frame),
                                                                                                                                ViewMatchers.isDescendantOfA(
                                                                                                                                        ViewMatchers.withId(
                                                                                                                                                R.id
                                                                                                                                                        .activity_main))))))))))))))));
        android_widget_ImageView4.perform(getClickAction());

        ViewInteraction android_widget_ImageButton5 =
                Espresso.onView(
                        Matchers.allOf(
                                ViewMatchers.withContentDescription(IsEqualTrimmingAndIgnoringCase.equalToTrimmingAndIgnoringCase("Collapse")),
                                VisibleViewMatcher.isVisible(),
                                ViewMatchers.isDescendantOfA(
                                        Matchers.allOf(
                                                ViewMatchers.withId(R.id.toolbar),
                                                ViewMatchers.isDescendantOfA(
                                                        Matchers.allOf(
                                                                ViewMatchers.withId(R.id.activity_main_frame),
                                                                ViewMatchers.isDescendantOfA(ViewMatchers.withId(R.id.activity_main))))))));
        android_widget_ImageButton5.perform(getClickAction());

        ViewInteraction android_widget_ImageView5 =
                Espresso.onView(
                        Matchers.allOf(
                                ViewMatchers.withContentDescription(IsEqualTrimmingAndIgnoringCase.equalToTrimmingAndIgnoringCase("More options")),
                                VisibleViewMatcher.isVisible(),
                                ViewMatchers.isDescendantOfA(
                                        Matchers.allOf(
                                                ViewMatchers.withId(R.id.toolbar),
                                                ViewMatchers.isDescendantOfA(
                                                        Matchers.allOf(
                                                                ViewMatchers.withId(R.id.activity_main_frame),
                                                                ViewMatchers.isDescendantOfA(ViewMatchers.withId(R.id.activity_main))))))));
        android_widget_ImageView5.perform(getLongClickAction());

        ViewInteraction android_widget_ImageView6 =
                Espresso.onView(
                        Matchers.allOf(
                                ViewMatchers.withContentDescription(IsEqualTrimmingAndIgnoringCase.equalToTrimmingAndIgnoringCase("More options")),
                                VisibleViewMatcher.isVisible(),
                                ViewMatchers.isDescendantOfA(
                                        Matchers.allOf(
                                                ViewMatchers.withId(R.id.toolbar),
                                                ViewMatchers.isDescendantOfA(
                                                        Matchers.allOf(
                                                                ViewMatchers.withId(R.id.activity_main_frame),
                                                                ViewMatchers.isDescendantOfA(ViewMatchers.withId(R.id.activity_main))))))));
        android_widget_ImageView6.perform(getClickAction());

        ViewInteraction android_widget_LinearLayout4 =
                Espresso.onView(
                        Matchers.allOf(
                                classOrSuperClassesName(Matchers.is("android.widget.LinearLayout")),
                                VisibleViewMatcher.isVisible(),
                                ViewMatchers.hasDescendant(
                                        Matchers.allOf(
                                                ViewMatchers.withId(R.id.content),
                                                ViewMatchers.hasDescendant(
                                                        Matchers.allOf(
                                                                ViewMatchers.withId(R.id.title),
                                                                withTextOrHint(
                                                                        IsEqualTrimmingAndIgnoringCase.equalToTrimmingAndIgnoringCase("Import notebook"))))))));
        android_widget_LinearLayout4.perform(getClickAction());
    }

    private ViewAction getSwipeAction(
            final int fromX, final int fromY, final int toX, final int toY) {
        return ViewActions.actionWithAssertions(
                new GeneralSwipeAction(
                        Swipe.SLOW,
                        new CoordinatesProvider() {
                            @Override
                            public float[] calculateCoordinates(View view) {
                                float[] coordinates = {fromX, fromY};
                                return coordinates;
                            }
                        },
                        new CoordinatesProvider() {
                            @Override
                            public float[] calculateCoordinates(View view) {
                                float[] coordinates = {toX, toY};
                                return coordinates;
                            }
                        },
                        Press.FINGER));
    }

    private void waitToScrollEnd() {
        SystemClock.sleep(500);
    }

    private ClickWithoutDisplayConstraint getClickAction() {
        return new ClickWithoutDisplayConstraint(
                Tap.SINGLE,
                GeneralLocation.VISIBLE_CENTER,
                Press.FINGER,
                InputDevice.SOURCE_UNKNOWN,
                MotionEvent.BUTTON_PRIMARY);
    }

    private ClickWithoutDisplayConstraint getLongClickAction() {
        return new ClickWithoutDisplayConstraint(
                Tap.LONG,
                GeneralLocation.CENTER,
                Press.FINGER,
                InputDevice.SOURCE_UNKNOWN,
                MotionEvent.BUTTON_PRIMARY);
    }
}
