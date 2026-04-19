package org.wikipedia.lesson13.homeworks

import com.kaspersky.components.kautomator.component.text.UiButton
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.edit.KEditText
import io.github.kakaocup.kakao.text.KTextView

object SearchScreen : KScreen<SearchScreen>() {
    override val layoutId = null
    override val viewClass = null

    val search = KEditText {
        withId(androidx.appcompat.R.id.search_src_text)
    }

    val catsText = UiButton {
        withText("Cats")
    }

    val searchField = KEditText{
        withId(R.id.search_src_text)
    }

    val searchText = KTextView {
        withText("On")
    }
}