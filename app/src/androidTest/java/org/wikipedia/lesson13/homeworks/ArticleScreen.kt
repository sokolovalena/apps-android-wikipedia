package org.wikipedia.lesson13.homeworks

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.web.KWebView
import org.wikipedia.R

object ArticleScreen : KScreen<ArticleScreen>() {
    override val layoutId = null
    override val viewClass = null

    val webview = KWebView {
        withId(R.id.page_web_view)
    }

    val openNewButton = KButton{
        withId(R.id.link_preview_secondary_button)
    }

    val readArticleButton = KButton{
        withId(R.id.link_preview_primary_button)
    }
}