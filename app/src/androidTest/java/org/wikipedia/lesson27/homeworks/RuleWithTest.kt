package org.wikipedia.lesson27.homeworks

import android.util.Log
import io.qameta.allure.kotlin.AllureId
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

class RuleWithTest : TestRule {
    override fun apply(
        base: Statement,
        description: Description
    ): Statement {
        Log.i("KASPRESSO", "Test Rule START")
        Log.i("KASPRESSO", "Test Rule description = ${description.annotations}")

        //return SimpleStatement(base, description)
        return object : Statement() {
            override fun evaluate() {
                val allureId = description?.getAnnotation<AllureId>(AllureId::class.java)?.value
                Log.i("KASPRESSO", "SimpleStatement allure id = $allureId")

                if (allureId !in Config.testsId) {
                    throw NoSuchElementException("Test didn't run")
                }

                try {
                    base?.evaluate()
                } catch (e: Throwable) {
                    Log.i("KASPRESSO", e.message ?: "empty message")
                }

                Log.i("KASPRESSO", "Test Rule END")
            }
        }
    }
}

object Config {
    val testsId = listOf("1", "2", "3")
}

class SimpleTest {

    @get:Rule
    val baseRule = RuleWithTest()

    @Test
    @AllureId("1")
    fun test() {
        Log.i("KASPRESSO", "Log in test")
        Assert.assertTrue(false)
    }
}

class SimpleStatement(val base: Statement?, val description: Description) : Statement() {
    override fun evaluate() {
        val allureId = description?.getAnnotation<AllureId>(AllureId::class.java)?.value
        Log.i("KASPRESSO", "SimpleStatement allure id = $allureId")

        if (allureId !in Config.testsId) {
            throw NoSuchElementException("Test didn't run")
        }

        try {
            base?.evaluate()
        } catch (e: Throwable) {
            Log.i("KASPRESSO", e.message ?: "empty message")
        }

        Log.i("KASPRESSO", "Test Rule END")
    }
}