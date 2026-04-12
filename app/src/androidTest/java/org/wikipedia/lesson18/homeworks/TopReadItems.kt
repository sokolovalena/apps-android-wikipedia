package org.wikipedia.lesson18.homeworks

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.lesson18.homeworks.extensions.name
import org.wikipedia.lesson18.homeworks.extensions.withParent

class TopReadItems(matcher: Matcher<View>) : KRecyclerItem<TopReadItems>(matcher) {

    val listItemHeader by lazy{
        KTextView(matcher) {
            withId(R.id.view_list_card_item_title)
        }.name(withParent("Заголовок списка"))
    }

    val listItemDescription by lazy{
        KTextView(matcher) {
            withId(R.id.view_list_card_item_subtitle)
        }.name(withParent("Описание списка"))
    }

    val listNumberIcon by lazy{
        KTextView(matcher) {
            withId(R.id.view_list_card_number)
        }.name(withParent("Иконка очередности в списке"))
    }

    val listItemImage by lazy{
        KImageView(matcher) {
            withId(R.id.view_list_card_item_image)
        }.name(withParent("Картинка в списке"))
    }
}