package org.wikipedia.lesson18.homeworks

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.pager2.KViewPagerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.lesson18.homeworks.extensions.name
import org.wikipedia.lesson18.homeworks.extensions.withParent

class TopReadItemNamed(matcher: Matcher<View>) : KViewPagerItem<TopReadItemNamed>(matcher) {

    val headerTitle by lazy{
        KTextView(matcher) {
            withId(R.id.view_card_header_title)
        }.name(withParent(""))
    }

    val headerMenu by lazy{
        KImageView(matcher) {
            withId(R.id.view_list_card_header_menu)
        }.name(withParent(""))
    }

    val topReadItems by lazy{
        KRecyclerView(
            parent = matcher,
            builder = {
                withId(R.id.view_list_card_list)},
            itemTypeBuilder = {
                itemType(::TopReadItems)
            }).name(withParent("Список статей Top Read"))
    }
}