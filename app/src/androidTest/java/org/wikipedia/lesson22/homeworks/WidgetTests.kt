package org.wikipedia.lesson22.homeworks

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.R
import org.wikipedia.lesson08.homeworks.ExploreScreen.items
import org.wikipedia.lesson08.homeworks.TopReadItem
import org.wikipedia.lesson18.homeworks.ExploreScreen
import org.wikipedia.lesson18.homeworks.OnboardingScreen
import org.wikipedia.lesson19.homeworks.action
import org.wikipedia.lesson19.homeworks.verify
import org.wikipedia.main.MainActivity

class WidgetTests : TestCase(Kaspresso.Builder.withForcedAllureSupport()) {

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun changeFont() {
        run {

            action.click(OnboardingScreen.skipButton)

            ExploreScreen.items {
                items.childWith<TopReadItem> {
                    withDescendant { withText(R.string.view_featured_article_card_title) }
                } perform {
                    isDisplayed()
                    click()
                }
            }

            ArticleScreen {
                popupCloseButton {
                    isDisplayed()
                    click()
                }

                action.click(themeButton)

                WidgetsBottomSheet {
                    textSizeSettingWidget {
                        isDisplayed()
                        action.click(maxSizeButton)

                        verify.hasText(textSize, "110%")

                        action.click(minSizeButton)
                        action.click(minSizeButton)

                        verify.hasText(textSize, "90%")
                    }
                }
            }
        }

        @Test
        fun changeSystemTheme() {
            run {

                action.click(OnboardingScreen.skipButton)

                ExploreScreen.items {
                    items.childWith<TopReadItem> {
                        withDescendant { withText(R.string.view_featured_article_card_title) }
                    } perform {
                        isDisplayed()
                        click()
                    }
                }

                ArticleScreen {
                    popupCloseButton {
                        isDisplayed()
                        click()
                    }

                    action.click(themeButton)
                }

                WidgetsBottomSheet {
                    themeWidget {
                        isDisplayed()
                        action.swipeSwitchLeft(themeSwitch)
                        verify.isDisplayed(darkThemeButton)
                        action.swipeSwitchRight(themeSwitch)
                        darkThemeButton.isDisabled()
                    }
                }
            }
        }
    }
}
