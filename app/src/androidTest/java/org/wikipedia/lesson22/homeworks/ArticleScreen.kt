package org.wikipedia.lesson22.homeworks

import androidx.test.espresso.matcher.ViewMatchers.withParent
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.tabs.KTabLayout
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R
import org.wikipedia.lesson18.homeworks.NamedScreen
import org.wikipedia.lesson18.homeworks.extensions.name

object ArticleScreen : NamedScreen<ArticleScreen>() {

    override val screenName = "Экран статьи"
    override val layoutId = null
    override val viewClass = null

    val themeButton by lazy {
        KTextView {
            withText("Theme")
            isDescendantOfA { withId(R.id.page_actions_tab_layout) }
        }.name(withParent("Кнопка Тема"))
    }

    val popupCloseButton = KImageView {
        withId(R.id.closeButton)
    }.name(withParent("Кнопка закрытия"))
}