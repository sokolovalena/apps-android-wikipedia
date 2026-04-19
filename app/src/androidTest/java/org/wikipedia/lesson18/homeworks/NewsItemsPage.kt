package org.wikipedia.lesson18.homeworks

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.feed.featured.FeaturedArticleCardView
import org.wikipedia.lesson18.homeworks.ExploreScreen.items
import org.wikipedia.lesson18.homeworks.extensions.name
import org.wikipedia.lesson18.homeworks.extensions.withParent
import org.wikipedia.lesson21.homewroks.invokeAtIndexAndClass

class NewsItemsPage(matcher: Matcher<View>): KRecyclerItem<NewsItemsPage>(matcher) {
    val image by lazy {
        KImageView(matcher) {
            withId(R.id.horizontal_scroll_list_item_image)
        }.name(withParent("Картинка ресайклера"))

        val scrollText by lazy {
            KTextView(matcher) {
                withId(R.id.horizontal_scroll_list_item_text)
            }.name(withParent("Текст skroll"))
        }
    }
}

    fun featuredArticle(index: Int, fnc: NewsItemsPage.() -> Unit) {
        items.invokeAtIndexAndClass(
            index,
            1,
            (index - 1) * 10,
            FeaturedArticleCardView::class.java,
            "$index блок Featured article",
            fnc
        )
    }
