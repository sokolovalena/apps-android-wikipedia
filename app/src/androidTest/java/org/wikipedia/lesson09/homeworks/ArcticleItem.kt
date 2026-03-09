package org.wikipedia.lesson09.homeworks

import android.view.View
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class ArticleItem (matcher: Matcher<View>): KRecyclerItem<ArticleItem>(matcher) {
    val title = KTextView(matcher){
        withId(R.id.view_card_header_title)
    }
    val cardMenu = KImageView(matcher){
        withId(R.id.view_list_card_header_menu)
    }
    val articleImage = KImageView(matcher){
        withId(R.id.articleImage)
    }
    val articleTitle = KTextView(matcher){
        withId(R.id.articleTitle)
    }
    val articleDescription = KTextView(matcher){
        withId(R.id.articleDescription)
    }
    val articleExtract = KTextView(matcher){
        withId(R.id.articleExtract)
    }
    val actionButton = KButton(matcher){
        withId(R.id.footerActionButton)
    }

    val hideCard = KView(matcher) {
        withText("Hide this card")
    }
}