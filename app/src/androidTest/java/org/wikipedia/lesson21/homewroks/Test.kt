package org.wikipedia.lesson21.homewroks

import org.junit.Test
import org.wikipedia.lesson18.homeworks.ExploreScreen
import org.wikipedia.lesson18.homeworks.OnboardingScreen
import org.wikipedia.lesson18.homeworks.featuredArticle
import org.wikipedia.lesson19.homeworks.verify
import org.wikipedia.lesson19.homeworks.BottomSheet
import org.wikipedia.lesson19.homeworks.SettingScreen
import org.wikipedia.lesson20.homeworks.equalsWithTrim
import org.wikipedia.lesson20.homeworks.multiAction
import org.wikipedia.lesson20.homeworks.BaseTest

class Test : BaseTest() {

    @Test
    fun invokeAtIndexAndClassTest() {
        run {
            OnboardingScreen.skipButton.multiAction()
            featuredArticle(1) { verify.isDisplayed(this) }
        }
    }

    @Test
    fun invokeAtIndexAndIdTest() {
        run {
            OnboardingScreen.skipButton.multiAction()
            ExploreScreen.menuButton.multiAction()
            BottomSheet.settings.multiAction()
            SettingScreen.switchAtIndex(0) {
                switch.multiAction()
                verify.isChecked(switch)
            }
            SettingScreen.switchAtIndex(1) {
                title.equalsWithTrim("Collapse tables")
            }
        }
    }
}