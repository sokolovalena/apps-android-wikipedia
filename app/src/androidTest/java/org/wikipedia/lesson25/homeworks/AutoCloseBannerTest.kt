package org.wikipedia.lesson25.homeworks

import androidx.test.espresso.matcher.ViewMatchers.withText
import org.junit.Test
import org.wikipedia.R
import org.wikipedia.lesson08.homeworks.ExploreScreen.cardsList
import org.wikipedia.lesson08.homeworks.FeaturedArticlesItem
import org.wikipedia.lesson18.homeworks.ExploreScreen
import org.wikipedia.lesson18.homeworks.OnboardingScreen
import org.wikipedia.lesson19.homeworks.action
import org.wikipedia.lesson20.homeworks.BaseTest
import org.wikipedia.lesson22.homeworks.ArticleScreen.themeButton
import org.wikipedia.lesson22.homeworks.WidgetsBottomSheet
import org.wikipedia.lesson23.homeworks.ArticleScreen

class AutoCloseBannerTest : BaseTest() {

    @Test
    fun autoCloseBanner() {
        run {

            action.click(OnboardingScreen.skipButton)

            ExploreScreen.cardsList {
                cardsList.childWith<FeaturedArticlesItem> {
                    withDescendant { withText(R.string.view_featured_article_card_title) }
                } perform {
                    isDisplayed()
                    click()
                }
            }

            ArticleScreen {

                action.click(themeButton)
            }

            WidgetsBottomSheet {
                textSizeSettingWidget {
                    action.click(increaseSizeButton)
                }
            }
        }
    }
}