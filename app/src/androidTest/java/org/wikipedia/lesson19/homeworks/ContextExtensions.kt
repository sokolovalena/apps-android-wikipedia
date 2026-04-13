package org.wikipedia.lesson19.homeworks

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext

private val steps = mutableMapOf<String, StepsDSL<*>>()

val TestContext<*>.action: Actions
    get() {
        return steps.getOrPut(getId(this, "action")) {
            Actions(StepDefinitions(this)).also {
                steps[getId(this, "action")] = it
            }
        } as Actions

    }

val TestContext<*>.verify: Verify
    get() {
        return steps.getOrPut(getId(this, "verify")) {
            Verify(StepDefinitions(this)).also {
                steps[getId(this, "action")] = it
            }
        } as Verify
    }

private fun getId(testContext: TestContext<*>, stepType: String): String {
    return "${testContext.hashCode()}-$stepType"
}