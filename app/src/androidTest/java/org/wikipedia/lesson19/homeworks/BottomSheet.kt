package org.wikipedia.lesson19.homeworks

import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.lesson18.homeworks.NamedScreen

object BottomSheet : NamedScreen<BottomSheet>() {
    override val screenName = "Панель боттомшит"
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val settings = KTextView {
        withText("Settings")
    }
}