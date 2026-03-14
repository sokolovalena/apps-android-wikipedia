package org.wikipedia.lesson11.homeworks

import android.view.Surface
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.wikipedia.lesson08.homeworks.ExploreScreen
import org.wikipedia.lesson10.homeworks.OnboardingPageScreen
import org.wikipedia.lesson10.homeworks.OnboardingPageScreen.primaryHeader
import org.wikipedia.lesson10.homeworks.OnboardingPageScreen.retryButton
import org.wikipedia.main.MainActivity
import java.util.Locale

class testsADBServer : TestCase() {

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    // поворот экрана и ориентация

    @Test
    fun checkOrientation() {
        before {
        }.after {
            // сделаем обычную ориентацию
            device.uiDevice.setOrientationNatural()
        }
            .run {
                step("Проверка смены ориентации устройства") {
                    OnboardingPageScreen {
                        device.uiDevice.setOrientationLandscape()
                        val act = device.uiDevice.getDisplayRotation()
                        val exp = Surface.ROTATION_90
                        Assert.assertEquals(exp, act)
                    }
                }
            }
    }

    // выключить включить экран
    @Test
    fun checkShutDown() {
        before {

        }.after {
            device.uiDevice.pressHome()
        }.run {
            step("Проверка отображения кнопки Продолжить") {
                OnboardingPageScreen {
                    continueButton.isDisplayed()
                    device.uiDevice.sleep()
                    device.uiDevice.wakeUp()
                    step("Проверка: после выключения экрана отображается кнопка Продолжить") {
                        continueButton.isDisplayed()
                    }
                }
            }
        }
    }

    // свернуть и развернуть приложение, проверить элементы
    @Test
    fun checkAfterRestore() {
        before {
        }.after {
            device.uiDevice.pressHome()
        }.run {
            step("Проверка экрана после восстановления") {
                OnboardingPageScreen {
                    onboardingImage.isDisplayed()
                    device.uiDevice.pressHome()
                    repeat(2) {
                        device.uiDevice.pressRecentApps()
                    }
                    onboardingImage.isDisplayed()
                }
            }
        }
    }

    // Включить-выключить сеть и проверить ошибку о сети
    @Test
    fun checkConnection() {
        before {
            adbServer.performAdb("shell svc data disable")
            adbServer.performAdb("shell svc wifi disable")
        }.after {
            adbServer.performAdb("shell svc data enable")
            adbServer.performAdb("shell svc wifi enable")
        }.run {
            step("Проверка кнопки Пропустить в онбординге") {
                OnboardingPageScreen {
                    skipButton.isDisplayed()
                    skipButton.click()
                }
            }
            step("Включить сеть и нажать кнопку Повторить") {
                ExploreScreen {
                    adbServer.performAdb("shell svc wifi enable")
                    retryButton.isDisplayed()
                    retryButton.click()
                    Thread.sleep(4000)
                    primaryHeader.isDisplayed()
                }
            }

        }
    }

    // поменять язык приложения и проверить текст
    @Test
    fun checkTextAfterLanguageChange() {
        before {
        }.after {
            device.uiDevice.pressHome()
            device.language.switchInApp(Locale("en"))
        }.run {
            step("Изменить текст приложения") {
                device.language.switchInApp(Locale("ru"))
                OnboardingPageScreen {
                    continueButton.hasText("Продолжить")
                }
            }
        }
    }

    // проверить, что активна MainActivity
    @Test
    fun checkMainActivity() {
        before {
        }.after {
            device.uiDevice.pressHome()
        }.run {
            step("Закрыть онбординг"){
                OnboardingPageScreen{
                    skipButton.click()
                }
            }
            step("Проверка, что MainActivity активна") {
                Thread.sleep(3000)
                device.activities.isCurrent(MainActivity::class.java)
            }
        }
    }
}




