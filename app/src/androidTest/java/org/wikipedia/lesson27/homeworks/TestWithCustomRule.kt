package org.wikipedia.lesson27.homeworks

import android.util.Log
import io.qameta.allure.kotlin.AllureId
import org.junit.Rule
import org.junit.Test
import org.wikipedia.lesson20.homeworks.BaseTest

class TestWithCustomRule : BaseTest() {
    @get:Rule
    val baseRule = CustomRule()

    @Test
    @AllureId("1")
    fun first() {
        Log.i("KASPRESSO", "Log in first test")
    }

    @Test
    @AllureId("2")
    @Deprecated("")
    fun second() {
        Log.i("KASPRESSO", "Log in second test")
    }

    @Test
    @AllureId("3")
    fun third() {
        Log.i("KASPRESSO", "Log in third test")
    }
}