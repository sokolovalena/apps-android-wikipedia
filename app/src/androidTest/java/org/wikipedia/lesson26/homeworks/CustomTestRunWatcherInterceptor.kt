package org.wikipedia.lesson26.homeworks

import android.util.Log
import com.kaspersky.kaspresso.interceptors.watcher.testcase.TestRunWatcherInterceptor
import com.kaspersky.kaspresso.testcases.models.info.TestInfo

class CustomTestRunWatcherInterceptor : TestRunWatcherInterceptor {

    override fun onTestStarted(testInfo: TestInfo) {
        Log.d("KASPRESSO", "TEST STARTED: ${testInfo.testName}")
    }

    override fun onBeforeSectionStarted(testInfo: TestInfo) {
        Log.d("KASPRESSO", "BEFORE SECTION STARTED")
    }

    override fun onBeforeSectionFinishedSuccess(testInfo: TestInfo) {
        Log.d("KASPRESSO", "BEFORE SECTION FINISHED SUCCESS")
    }

    override fun onMainSectionStarted(testInfo: TestInfo) {
        Log.d("KASPRESSO", "RUN SECTION STARTED")
    }

    override fun onMainSectionFinishedSuccess(testInfo: TestInfo) {
        Log.d("KASPRESSO", "RUN SECTION FINISHED SUCCESS")
    }

    override fun onAfterSectionStarted(testInfo: TestInfo) {
        Log.d("KASPRESSO", "AFTER SECTION STARTED")
    }

    override fun onAfterSectionFinishedSuccess(testInfo: TestInfo) {
        Log.d("KASPRESSO", "AFTER SECTION FINISHED SUCCESS")
    }

    override fun onTestFinished(testInfo: TestInfo, success: Boolean) {
        Log.d(
            "KASPRESSO",
            "TEST FINISHED: ${testInfo.testName}, success = $success"
        )
    }
}