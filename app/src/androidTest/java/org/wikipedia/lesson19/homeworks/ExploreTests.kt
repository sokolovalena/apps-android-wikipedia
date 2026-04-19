package org.wikipedia.lesson19.homeworks

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.lesson18.homeworks.ExploreScreen
import org.wikipedia.lesson18.homeworks.OnboardingScreen
import org.wikipedia.lesson18.homeworks.TopReadItems
import org.wikipedia.lesson18.homeworks.extensions.getByIndex
import org.wikipedia.lesson18.homeworks.extensions.invokeWithText
import org.wikipedia.main.MainActivity

private val steps = mutableMapOf<String, StepsDSL<*>>()

class ExploreTests() : TestCase() {

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun verifyThirdTopReadBlockImageOnExplore() {
        run {
            step("Пропустить онбординг") {
                action.click(OnboardingScreen.skipButton)
            }

            step("Проверить отображение картинки в третьем блоке Top Read") {
                ExploreScreen.topReadBlock {
                    items {
                        val thirdCard = getByIndex<TopReadItems>(2)
                        thirdCard {
                            listItemImage {
                                isDisplayed()
                            }
                        }
                    }
                }
            }
        }
    }

    @Test
    fun verifyLinkPreviewsDisabledInSettings() {
        run {
            step("Пропустить онбординг") {
                action.click(OnboardingScreen.skipButton)
            }
            step("Открыть нижнюю панель") {
                action.click(ExploreScreen.menuButton)
            }
            step("Перейти в Settings") {
                action.click(BottomSheet.settings)
            }
            step("Выключить Show link previews") {
                SettingScreen.items {
                    invokeWithText<SettingScreen.ItemWithSwitch>("Show link previews") {
                        switch {
                            click()
                        }
                    }
                }
            }
            step("Проверить, что Show link previews выключен") {
                SettingScreen.items {
                    invokeWithText<SettingScreen.ItemWithSwitch>("Show link previews") {
                        switch {
                            isNotSelected()
                        }
                    }
                }
            }
        }
    }
}