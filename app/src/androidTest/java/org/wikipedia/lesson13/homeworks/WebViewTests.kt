package org.wikipedia.lesson13.homeworks

import androidx.test.espresso.web.webdriver.Locator
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.uiautomator.UiSelector
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.lesson08.homeworks.OnboardingScreen
import org.wikipedia.lesson08.homeworks.ExploreScreen
import org.wikipedia.lesson08.homeworks.SearchItem
import org.wikipedia.main.MainActivity

class WebviewTests: TestCase() {
    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun webviewTest() {
        run {
            OnboardingScreen {
                step("Нажать Skip") {
                    skipButton {
                        isDisplayed()
                        click()
                    }
                }
            }
            step("Закрыть попап, если он есть") {
                try {
                    PopUpScreen.closeButton.click()
                } catch (_: Exception) {
                }
            }
            step("Тап по поиску") {
                ExploreScreen {
                    items {
                        childWith<SearchItem> {
                            withDescendant { withContentDescription("Search Wikipedia") }
                        } perform {
                            searchHintText.click()
                        }
                    }
                }
            }
            step("Написать в поиске cats") {
                SearchScreen.search.typeText("cats")
            }
            step("Тап по первой статье") {
                device.uiDevice.findObject(UiSelector().text("Cats")).click()
                // закрыть попап
                try {
                    PopUpScreen.closeButton.click()
                } catch (_: Exception) {
                }
            }
            step("Скролл до References и проверить текст") {
                ArticleScreen.webview {
                    withElement(Locator.ID, "References") {
                        scroll()
                        hasText("References")
                    }
                }
            }
            step("Скролим до 5й ссылки и тапаем") {
                ArticleScreen.webview {
                    withElement(
                        Locator.XPATH,
                        "//*[@id=\"cite_ref-FOOTNOTEMurray202024-29_5-0\"]/a/span"
                    ) {
                        scroll()
                        click()
                        Thread.sleep(3000)
                    }
                }
            }
            step("Проверить тайтл") {
                ReferencesScreen.title.hasText("Reference ")
            }
            step("Проверить ссылку под номером 5") {
                ReferencesScreen.refId.hasText("5.")
            }
            step("Нажать назад") {
                device.uiDevice.pressBack()
                Thread.sleep(1000)
            }
            step("Найти вторую ссылку с CSS=mw-redirect нажали на нее") {
                ArticleScreen.webview {
                    withElement(Locator.XPATH, "//*[@id=\"pcs\"]/section[1]/p[4]/a[24]") {
                        scroll()
                        Thread.sleep(3000)
                        click()
                    }
                }
            }
            step("Тап на Read article") {
                ArticleScreen.readArticleButton.click()
            }
        }
    }
}