package org.wikipedia.lesson26.homeworks

import android.util.Log
import android.view.View
import androidx.test.espresso.NoMatchingViewException
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.ViewInteraction
import com.kaspersky.kaspresso.interceptors.behavior.ViewBehaviorInterceptor
import com.kaspersky.kaspresso.interceptors.watcher.view.ViewAssertionWatcherInterceptor
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase

class LogBeforeAfterInterceptor : ViewBehaviorInterceptor {

    override fun <T> intercept(
        interaction: ViewInteraction,
        action: () -> T
    ): T {
        Log.d("KASPRESSO", "BEFORE ACTION")

        return try {
            action()
        } finally {
            Log.d("KASPRESSO", "AFTER ACTION")
        }
    }
}
class BrokenInterceptor : ViewBehaviorInterceptor {

    override fun <T> intercept(
        interaction: ViewInteraction,
        action: () -> T
    ): T {
        Log.d("KASPRESSO", "ACTION WAS INTERCEPTED, BUT NOT EXECUTED")
        throw IllegalStateException(
            "Мы специально не вызываем action(), поэтому Espresso-действие не выполнится"
        )
    }
}

class CheckStartWatcherInterceptor : ViewAssertionWatcherInterceptor {

    override fun intercept(
        viewAssertion: ViewAssertion,
        view: View?,
        exception: NoMatchingViewException?
    ) {
        Log.d("KASPRESSO", "CHECK START: ${viewAssertion::class.java.simpleName}")
    }
}

class AssertFailureWatcherInterceptor : ViewAssertionWatcherInterceptor {

    override fun intercept(
        viewAssertion: ViewAssertion,
        view: View?,
        exception: NoMatchingViewException?
    ) {
        if (exception != null) {
            Log.e(
                "KASPRESSO",
                "ASSERT FAILED: view was not found before assertion",
                exception
            )
        }
    }
}

class ActionTimeInterceptor : ViewBehaviorInterceptor {

    override fun <T> intercept(
        interaction: ViewInteraction,
        action: () -> T
    ): T {
        val startTime = System.currentTimeMillis()

        return try {
            action()
        } finally {
            val duration = System.currentTimeMillis() - startTime
            Log.d("KASPRESSO", "ACTION TOOK $duration ms")
        }
    }
}

abstract class BaseUiTest : TestCase(
    kaspressoBuilder = Kaspresso.Builder.simple().apply {
        viewBehaviorInterceptors.add(LogBeforeAfterInterceptor())
        // viewBehaviorInterceptors.add(BrokenInterceptor()) // только для задания 2

        viewAssertionWatcherInterceptors.add(CheckStartWatcherInterceptor())
        viewAssertionWatcherInterceptors.add(AssertFailureWatcherInterceptor())

        viewBehaviorInterceptors.add(ActionTimeInterceptor())
    }
)


