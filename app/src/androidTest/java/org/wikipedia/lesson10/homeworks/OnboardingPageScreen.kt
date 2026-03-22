package org.wikipedia.lesson10.homeworks

import androidx.compose.ui.test.hasText
import com.kaspersky.components.kautomator.component.common.views.UiView
import com.kaspersky.components.kautomator.component.text.UiButton
import com.kaspersky.components.kautomator.component.text.UiTextView
import com.kaspersky.components.kautomator.component.text.UiTextViewAssertions
import com.kaspersky.components.kautomator.screen.UiScreen

object OnboardingPageScreen : UiScreen<OnboardingPageScreen>() {
    override val packageName = "org.wikipedia.alpha"

    val skipButton = UiButton {
        withId(this@OnboardingPageScreen.packageName, "fragment_onboarding_skip_button")
    }

    val continueButton = UiButton {
        withId(this@OnboardingPageScreen.packageName, "fragment_onboarding_forward_button")
    }

    val onboardingImage = UiView {
        withId(this@OnboardingPageScreen.packageName, "imageViewCentered")
    }

    val primaryHeader = UiTextView {
        withId(this@OnboardingPageScreen.packageName, "primaryTextView")
    }

    val secondaryHeader = UiTextView {
        withId(this@OnboardingPageScreen.packageName, "secondaryTextView")
    }

    val addLangButton = UiButton {
        withId(this@OnboardingPageScreen.packageName, "addLanguageButton")
    }

    val secondPrimaryHeader = UiTextView {
        withText("New ways")
    }

    val thirdPrimaryHeader = UiTextView {
        withText("Reading lists")
    }

    val forthPrimaryHeader = UiTextView {
        withText("Data")
    }

    val retryButton = UiButton{
        withId(this@OnboardingPageScreen.packageName,"view_wiki_error_button")
    }
}