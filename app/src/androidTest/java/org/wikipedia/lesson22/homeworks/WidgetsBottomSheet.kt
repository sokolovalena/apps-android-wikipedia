package org.wikipedia.lesson22.homeworks

import org.wikipedia.R
import org.wikipedia.lesson18.homeworks.NamedScreen
import org.wikipedia.lesson18.homeworks.extensions.name

object WidgetsBottomSheet : NamedScreen<WidgetsBottomSheet>() {
    override val screenName: String = "Нижняя панель"
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val textSizeSettingWidget by lazy {
        SizeTextsWidget {
            withId(com.google.android.material.R.id.design_bottom_sheet)
        }.name(withParent("Виджет настройки шрифта"))
    }

    val focusModeWidget by lazy {
        ReadingWidget {
            withId(R.id.readingFocusModeContainer)
        }.name(withParent("Виджет Режим чтения"))
    }

    val themeWidget by lazy {
        ThemeWidget {
            withId(com.google.android.material.R.id.design_bottom_sheet)
        }.name(withParent("Виджет темы"))
    }
}