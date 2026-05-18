package org.wikipedia.lesson28.homeworks

import com.kaspersky.components.kautomator.component.text.UiTextView
import io.qameta.allure.kotlin.Description
import org.junit.Rule
import org.junit.Test
import org.wikipedia.lesson13.homeworks.SearchScreen
import org.wikipedia.lesson18.homeworks.ExploreScreen
import org.wikipedia.lesson18.homeworks.OnboardingScreen
import org.wikipedia.lesson19.homeworks.action
import org.wikipedia.lesson20.homeworks.BaseTest

class SearchTestsWithRule : BaseTest() {

    @get:Rule
    val validateRule = ValidateRule()

    private fun searchArticle() {
        run {

            action.click(OnboardingScreen.skipButton)

            action.click(ExploreScreen.searchField)

            SearchScreen {
                searchField {
                    isDisplayed()
                    click()
                    replaceText(validateRule.testData)
                }
            }
        }
    }

    @Test
    @Description("valid")
    fun validSearchArticle() {
        run {

            searchArticle()

            val article = UiTextView {
                withIndex(1) { containsText(validateRule.testData) }
            }
            article {
                isDisplayed()
            }
        }
    }

    @Test
    @Description("no result")
    fun noSearchArticle() {
        run {

            searchArticle()

            SearchScreen {
                noResultText {
                    isDisplayed()
                }
            }
        }
    }
}