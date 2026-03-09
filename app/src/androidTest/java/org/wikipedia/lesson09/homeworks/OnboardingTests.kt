package org.wikipedia.lesson09.homeworks

import androidx.compose.ui.test.hasText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.wikipedia.lesson08.homeworks.*
import org.junit.Rule
import org.junit.Test
import org.wikipedia.main.MainActivity


// 1 . Описать (если ещё не описан) экраны онбординга и добавления новых языков
// 2 . Написать тест на прокликивание онбординга до последнего слайда и проверку отображения кнопки Skip
// и текста кнопки переключения на каждом из слайдов.
// 3 . Написать тест добавления нового языка (добавить язык, проверить у обоих языков после добавления).

class OnboardingTests : TestCase() {

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkOnboardingScreen() {
        run {
            OnboardingScreen {
                step("Проверяет что кнопка Skip отображается") {
                    skipButton.isDisplayed()
                }
                step("Нажимает на кнопку Continue") {
                    continueButton.click()
                }
                step("Проверяет что кнопка Skip отображается") {
                    skipButton.isDisplayed()
                }
            }
        }
    }

    @Test
    fun checkLanguageRow() {
        run {
            step("Проверяет отображение списка языков на первом экране") {
                OnboardingScreen.pager.childAt<PagerItem>(0) {
                    image.isDisplayed()
                    languages.childWith<LanguageItem> {
                        containsText("Eng")
                    }.perform {
                        isDisplayed()
                        hasText("1.\t\tEnglish")
                    }
                }
            }
        }
    }
}