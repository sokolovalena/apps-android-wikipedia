package org.wikipedia.lesson10.homeworks

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.main.MainActivity

class OnboardingTests : TestCase() {

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkOnboardingUiScreenOne() {
        run {
            step("Проверка первого слайда"){
                OnboardingPageScreen{
                    primaryHeader.containsText("Encyclopedia")
                }
            }
        }
    }
    @Test
    fun checkOnboardingUiScreenTwo() {
        run {
            step("Переход ко второму слайду") {
                OnboardingPageScreen {
                    continueButton.click()
                }
            }
            step("Проверка второго слайда") {
                OnboardingPageScreen {
                    primaryHeader.containsText("New ways")
                }
            }
        }
    }
    @Test
    fun checkOnboardingUiScreenThree() {
        run {
            step("Переход на 2 слайд") {
                OnboardingPageScreen { continueButton.click() }
            }
            step("Переход на 3 слайд") {
                OnboardingPageScreen { continueButton.click() }
            }
            step("Проверяет текст 3 слайда") {
                OnboardingPageScreen {
                    primaryHeader.containsText("Reading lists")
                }
            }
        }
    }
    @Test
    fun checkOnboardingUiScreenFour() {
        run {
            step("Переход на 2 слайд") {
                OnboardingPageScreen { continueButton.click() }
            }
            step("Переход на 3 слайд") {
                OnboardingPageScreen { continueButton.click() }
            }
            step("Переход на 4 слайд") {
                OnboardingPageScreen { continueButton.click() }
            }
            step("Проверяет текст 4 слайда") {
                OnboardingPageScreen {
                    primaryHeader.containsText("Data")
                }
            }
        }
    }
}