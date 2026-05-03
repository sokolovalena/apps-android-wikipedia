package org.wikipedia.lesson22.homeworks

import io.github.kakaocup.kakao.check.KCheckBox
import io.github.kakaocup.kakao.common.builders.ViewBuilder
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R
import org.wikipedia.lesson18.homeworks.extensions.name
import org.wikipedia.lesson18.homeworks.extensions.withParent

class ReadingWidget(builder: ViewBuilder.() -> Unit) :
    KWidget<ReadingWidget>(builder) {
    val switch by lazy {
        KCheckBox(matcher) {
            withId(R.id.theme_chooser_reading_focus_mode_switch)
        }.name(withParent("Свичер режима чтения"))
    }

    val description by lazy {
        KTextView(matcher) {
            withId(R.id.theme_chooser_reading_focus_mode_description)
        }.name(withParent("Описание режима чтения"))
    }
}