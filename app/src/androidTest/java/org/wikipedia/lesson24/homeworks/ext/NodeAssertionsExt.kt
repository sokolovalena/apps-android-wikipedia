package org.wikipedia.lesson24.homeworks.ext

import io.github.kakaocup.compose.node.assertion.NodeAssertions

fun NodeAssertions.assertTrimmedTextIsEquals(expected: String) {
    delegate.check(TrimmedTextAssertions(expected))
}