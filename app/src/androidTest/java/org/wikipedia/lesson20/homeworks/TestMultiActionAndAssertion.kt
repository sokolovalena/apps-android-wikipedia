package org.wikipedia.lesson20.homeworks

import org.junit.Test
import org.wikipedia.lesson18.homeworks.OnboardingScreen

class  TestMultiActionAndAssertion() : BaseTest() {


    @Test
    fun multiActionTest() {
        run {
            OnboardingScreen.skipButton.multiAction()
        }
    }

    @Test
    fun assertionTest() {
        run {
            OnboardingScreen.page(1) {
                title.equalsWithTrim("New ways to explore")
            }
        }
    }
}