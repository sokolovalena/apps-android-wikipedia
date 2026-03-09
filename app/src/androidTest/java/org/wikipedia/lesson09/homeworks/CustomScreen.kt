package org.wikipedia.lesson09.homeworks

import android.view.View
import androidx.appcompat.widget.AppCompatImageButton
import androidx.appcompat.widget.AppCompatImageView
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.check.KCheckBox
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

object CustomScreen: KScreen<CustomScreen>() {
    override val layoutId = null
    override val viewClass = null

    val title = KTextView {
        isInstanceOf(AppCompatImageView::class.java)
    }
    val backButton = KImageView{
        withParent{
            withId(R.id.toolbar)
        }
        isInstanceOf(AppCompatImageButton::class.java)
    }
    val items = KRecyclerView(
        builder = {
            withId(R.id.content_types_recycler)
        },
        itemTypeBuilder = {
            itemType(::CustomizeRecycler)
        }
    )
}

class CustomizeRecycler(matcher: Matcher<View>): KRecyclerItem<CustomizeRecycler>(matcher){
    val title = KTextView(matcher){
        withId(R.id.feed_content_type_title)
    }
    val checkbox = KCheckBox(matcher){
        withId(R.id.feed_content_type_checkbox)
    }
}