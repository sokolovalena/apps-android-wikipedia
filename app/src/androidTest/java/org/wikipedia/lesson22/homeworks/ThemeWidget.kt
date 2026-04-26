package org.wikipedia.lesson22.homeworks

import io.github.kakaocup.kakao.common.builders.ViewBuilder
import io.github.kakaocup.kakao.switch.KSwitch
import io.github.kakaocup.kakao.text.KButton
import org.wikipedia.R
import org.wikipedia.lesson18.homeworks.extensions.name
import org.wikipedia.lesson18.homeworks.extensions.withParent

class ThemeWidget(builder: ViewBuilder.() -> Unit) : KWidget<ThemeWidget>(builder) {
    val themeSwitch by lazy {
        KSwitch(matcher) {
            withId(R.id.theme_chooser_match_system_theme_switch)
        }.name(withParent("Свичер выбора системной темы"))
    }

    val darkThemeButton by lazy {
        KButton(matcher) {
            withId(R.id.button_theme_dark)
        }.name(withParent("Кнопка включения темной темы"))
    }
}