package org.wikipedia.lesson18.homeworks

import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerView
import org.wikipedia.R
import org.wikipedia.feed.view.FeedView
import org.wikipedia.lesson08.homeworks.CustomizeItem
import org.wikipedia.lesson08.homeworks.DateItem
import org.wikipedia.lesson08.homeworks.NewsItem
import org.wikipedia.lesson08.homeworks.SearchItem
import org.wikipedia.lesson08.homeworks.TopReadItem
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
}