package org.wikipedia.lesson20.homeworks

import org.wikipedia.lesson18.homeworks.ExploreScreen
import org.wikipedia.lesson18.homeworks.OnboardingScreen
import org.wikipedia.lesson19.homeworks.action
import android.widget.Checkable
import org.wikipedia.lesson20.homeworks.equalsWithTrim
import org.wikipedia.lesson20.homeworks.multiAction
import org.junit.Test
import org.wikipedia.lesson13.homeworks.SearchScreen
import org.wikipedia.lesson13.homeworks.SearchScreen.searchField
import org.wikipedia.lesson18.homeworks.ExploreScreen.menuButton
import org.wikipedia.lesson19.homeworks.BottomSheet
import org.wikipedia.lesson19.homeworks.BottomSheet.settings
import org.wikipedia.lesson19.homeworks.SettingScreen
import org.wikipedia.lesson19.homeworks.verify

class MultiScenarioTest : BaseTest() {

    @Test
    fun multiActionTest() {
        run {
            OnboardingScreen {
                skipButton.multiAction()
            }
            ExploreScreen {
                verify.isDisplayed(searchField)
                action.click(searchField)
            }
            SearchScreen {
                searchField.multiAction()
                searchField {
                    equalsWithTrim("text")
                }
            }
            repeat(2) {
                device.uiDevice.pressBack()
            }
            ExploreScreen {
                action.apply {
                    click(menuButton)
                    click(settings)
                }
            }
            SettingScreen.switchBlock {
                switch.multiAction()
                verify.isChecked(switch)
            }
        }
    }
}