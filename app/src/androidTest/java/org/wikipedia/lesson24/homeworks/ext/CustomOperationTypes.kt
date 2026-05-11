package org.wikipedia.lesson24.homeworks.ext

import io.github.kakaocup.compose.intercept.operation.ComposeOperationType

enum class CustomOperationTypes : ComposeOperationType {
    TRIMMED_TEXT_ASSERTION,
    CUSTOM_CLICK_ACTION
}