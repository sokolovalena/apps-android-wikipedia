package org.wikipedia.lesson18.homeworks

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.pager2.KViewPager2
import io.github.kakaocup.kakao.pager2.KViewPagerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.lesson18.homeworks.ExploreScreen.withParent
import org.wikipedia.lesson18.homeworks.extensions.name

val pager = KViewPager2(
    builder = {
        withId(R.id.main_view_pager)
    },
    itemTypeBuilder = {
        itemType(::NewsItem)
    }
).name(withParent("pager"))

class NewsItem(matcher: Matcher<View>) : KViewPagerItem<NewsItem>(matcher) {

    val header by lazy{
        KTextView(matcher){
            withId(R.id.view_card_header_title)
        }.name(withParent("Заголовок новости"))
    }

    val menuIcon by lazy {
        KImageView(matcher){
            withId(R.id.view_list_card_header_menu)
        }.name(withParent("Иконка меню"))
    }

    val newsItems by lazy {
        KRecyclerView(
            parent = matcher,
            builder = {
                withId(R.id.news_cardview_recycler_view)
            },
            itemTypeBuilder = {
                itemType(::NewsItemsPage)
            }
        ).name(withParent("Список новостей"))
    }
}