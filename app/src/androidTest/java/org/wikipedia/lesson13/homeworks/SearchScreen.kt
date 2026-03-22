package org.wikipedia.lesson13.homeworks

import com.kaspersky.components.kautomator.component.text.UiButton
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.edit.KEditText

object SearchScreen : KScreen<SearchScreen>() {
    override val layoutId = null
    override val viewClass = null

    val search = KEditText {
        withId(androidx.appcompat.R.id.search_src_text)
    }

    val catsText = UiButton {
        withText("Cats")
    }
}