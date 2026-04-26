package org.wikipedia.lesson23.homeworks

import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.web.KWebView
import org.wikipedia.R
import org.wikipedia.lesson18.homeworks.extensions.name

object ArticleScreen : BaseScreen<ArticleScreen>() {
    override val screenName: String = "Экран статьи"

    val popupCloseButton = KImageView {
        withId(R.id.closeButton)
    }.name(withParent("Кнопка закрытия попапа"))

    private val webView by lazy {
        KWebView {
            withId(R.id.page_web_view)
        }
    }

    val title by lazy {
        webView.withXPath("//h1")
            .name(withParent("Заголовок"))
    }

    val references by lazy {
        webView.withXPath("//*[@id=\"References\"]")
            .name(withParent("Блок ссылок"))
    }

    val referencesList by lazy {
        KWebViewList(webView, "//div[@class = 'mw-references-wrap']/ol")
            .name(withParent("Список со ссылками"))
    }

    fun referenceItem(index: Int, fnc: ReferencesItem.() -> Unit) {
        referencesList.childAt(index, fnc)
    }
}