package org.wikipedia.lesson22.homeworks

import io.github.kakaocup.kakao.common.builders.ViewBuilder
import io.github.kakaocup.kakao.progress.KSeekBar
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R
import org.wikipedia.lesson18.homeworks.extensions.name
import org.wikipedia.lesson18.homeworks.extensions.withParent

class SizeTextsWidget(builder: ViewBuilder.() -> Unit) :
    KWidget<SizeTextsWidget>(builder) {
    val categoryName by lazy {
        KTextView(matcher) {
            withId(R.id.textSettingsCategory)
        }.name(withParent("Категория Чтение"))
    }

    val textSize by lazy {
        KTextView(matcher) {
            withId(R.id.text_size_percent)
        }.name(withParent("Размер текста"))
    }

    val minSizeButton by lazy {
        KTextView(matcher) {
            withId(R.id.buttonDecreaseTextSize)
        }.name(withParent("Кнопка уменьшения текста"))
    }

    val maxSizeButton by lazy {
        KTextView(matcher) {
            withId(R.id.buttonIncreaseTextSize)
        }.name(withParent("Кнопка увеличения текста"))
    }

    val slider by lazy {
        KSeekBar(matcher) {
            withId(R.id.text_size_seek_bar)
        }.name(withParent("Слайдер"))
    }
}