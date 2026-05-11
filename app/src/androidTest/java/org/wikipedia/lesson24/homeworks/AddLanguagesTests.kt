package org.wikipedia.lesson24.homeworks

import androidx.compose.ui.test.ExperimentalTestApi
import org.junit.Test
import org.wikipedia.lesson18.homeworks.OnboardingScreen
import org.wikipedia.lesson19.homeworks.action
import org.wikipedia.lesson19.homeworks.verify
import org.wikipedia.lesson20.homeworks.BaseTest
import org.wikipedia.lesson24.homeworks.screens.AddLanguageScreen
import org.wikipedia.lesson24.homeworks.screens.LanguagesScreen

class AddLanguageTest : BaseTest() {

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun addLanguageTest() {
        run {
            OnboardingScreen.page(0) {
                action.click(addLanguageButton)
            }
            LanguagesScreen {
                action.click(wikiLanguageTitle)
            }

            AddLanguageScreen().getLang {
                verify.assertTrimmedTextIsEquals(titleLanguage, "Français")
                verify.assertTrimmedTextIsEquals(subtitleLanguage, "French")
                action.clickIfEnabled(titleLanguage)
            }

            device.uiDevice.pressBack()

            OnboardingScreen.page(0) {
                verify.hasText(languageLabel, "日本語")
            }
        }
    }
}