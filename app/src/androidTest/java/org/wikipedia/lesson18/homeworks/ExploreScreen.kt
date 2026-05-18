package org.wikipedia.lesson18.homeworks

import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.edit.KEditText
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import org.wikipedia.R
import org.wikipedia.feed.view.FeedView
import org.wikipedia.lesson08.homeworks.CustomizeItem
import org.wikipedia.lesson08.homeworks.DateItem
import org.wikipedia.lesson08.homeworks.NewsItem
import org.wikipedia.lesson08.homeworks.SearchItem
import org.wikipedia.lesson08.homeworks.TopReadItem
import org.wikipedia.lesson18.homeworks.extensions.invokeWithText
import org.wikipedia.lesson18.homeworks.extensions.name

object ExploreScreen : NamedScreen<ExploreScreen>() {

    override val layoutId: Int = R.layout.fragment_feed
    override val viewClass: Class<*> = FeedView::class.java
    override val screenName = "Explore screen"

    val logo = KImageView {
        withId(R.id.main_toolbar_wordmark)
    }

    val feedView = KView {
        withId(R.id.feed_view)
    }.name(withParent("Лента"))

    val items by lazy {
        KRecyclerView(
            builder = {
                withId(R.id.feed_view)
            },
            itemTypeBuilder = {
                itemType(::SearchItem)
                itemType(::CustomizeItem)
                itemType(::DateItem)
                itemType(::TopReadItem)
                itemType(::NewsItem)
            }
        ).name(withParent("Фиды"))

    }

    fun topReadBlock(fnc: TopReadItem.() -> Unit) {
        items.invokeWithText("Top read", fnc)
    }

    val menuButton = KButton {
        withId(com.google.android.material.R.id.navigation_bar_item_small_label_view)
        withText(R.string.nav_item_more)
    }.name(withParent("Кнопка More"))

    val closeButton by lazy {
        KImageView {
            withId(R.id.closeButton)
        }.name(withParent(("Кнопка закрыть")))
    }

    val searchField = KEditText {
        withText(R.string.search_hint)
    }.name(withParent("Текст Search Wikipedia"))
}