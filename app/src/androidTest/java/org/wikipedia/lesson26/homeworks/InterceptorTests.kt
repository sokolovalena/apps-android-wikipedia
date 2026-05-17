package org.wikipedia.lesson26.homeworks

import androidx.test.espresso.matcher.ViewMatchers.withText
import org.junit.Test
import org.wikipedia.R
import org.wikipedia.lesson08.homeworks.ExploreScreen.cardsList
import org.wikipedia.lesson08.homeworks.FeaturedArticlesItem
import org.wikipedia.lesson18.homeworks.ExploreScreen
import org.wikipedia.lesson18.homeworks.OnboardingScreen
import org.wikipedia.lesson19.homeworks.action
import org.wikipedia.lesson19.homeworks.verify
import org.wikipedia.lesson20.homeworks.BaseTest
import org.wikipedia.lesson22.homeworks.ArticleScreen.themeButton
import org.wikipedia.lesson22.homeworks.BottomSheet
import org.wikipedia.lesson23.homeworks.ArticleScreen

class InterceptorTest : BaseTest() {

    @Test
    fun openArticle() {
        before{
            testLogger.i("TEST_TAG", "BEFORE SECTION")
        }.after {
            testLogger.i("TEST_TAG", "AFTER SECTION")
        }.run {
            testLogger.i("TEST_TAG", "AFTER SECTION")

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
                verify.isDisplayed(title)
            }
        }
    }
}