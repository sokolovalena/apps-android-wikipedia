package org.wikipedia.lesson27.homeworks

import android.util.Log
import io.qameta.allure.kotlin.AllureId
import org.junit.AssumptionViolatedException
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

class CustomRule : TestRule {
    override fun apply(
        base: Statement,
        description: Description
    ): Statement {
        Log.i("KASPRESSO", "Test Rule START")
        Log.i("KASPRESSO", "Test Rule description = ${description.annotations}")

        return object : Statement() {
            override fun evaluate() {
                val allureId = description?.getAnnotation<AllureId>(AllureId::class.java)?.value
                Log.i("KASPRESSO", "SimpleStatement allure id = $allureId")

                if (allureId !in Config.testsId) {
                    throw NoSuchElementException("Test didn't run")
                }

                val deprecatedAnnotation =
                    description?.getAnnotation<Deprecated>(Deprecated::class.java)

                Log.i("KASPRESSO", " deprecatedAnnotation $deprecatedAnnotation")
                Log.i("KASPRESSO", "deprecatedAnnotation message ${deprecatedAnnotation?.message}")

                if (deprecatedAnnotation != null) {
                    throw AssumptionViolatedException("The test is deprecated")
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