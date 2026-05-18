package org.wikipedia.lesson28.homeworks

import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement
import org.wikipedia.BuildConfig
import io.qameta.allure.kotlin.Description as AnnotationDescription

class ValidateRule : TestRule {
    var testData = ""

    override fun apply(
        base: Statement, description: Description
    ): Statement {

        return object : Statement() {
            override fun evaluate() {

                var annotationDescription =
                    description?.getAnnotation<AnnotationDescription>(AnnotationDescription::class.java)?.value

                if (annotationDescription == "valid") {
                    testData = BuildConfig.VALID_SEARCH_RESULT
                } else {
                    testData = BuildConfig.NO_SEARCH_RESULT
                }

                base?.evaluate()
            }
        }
    }
}