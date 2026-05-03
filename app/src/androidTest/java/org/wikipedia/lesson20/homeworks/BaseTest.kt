package org.wikipedia.lesson20.homeworks

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.wikipedia.main.MainActivity
import com.kaspersky.components.composesupport.config.ComposeConfig

open class BaseTest : TestCase(
            Kaspresso.Builder.withForcedAllureSupport()
        .apply { ComposeConfig.Builder.default(this) {} }
) {

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)
}

private fun Kaspresso.Builder.Companion.withForcedAllureSupport(): Kaspresso.Builder {
    TODO("Not yet implemented")
}
