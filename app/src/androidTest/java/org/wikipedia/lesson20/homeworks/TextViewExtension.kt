package org.wikipedia.lesson20.homeworks

import io.github.kakaocup.kakao.text.TextViewAssertions

fun TextViewAssertions.equalsWithTrim(expected: String) {
    view.check(Assertion(expected))
}