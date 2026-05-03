package org.wikipedia.lesson24.homeworks.screens

import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R
import org.wikipedia.lesson18.homeworks.NamedScreen
import org.wikipedia.lesson18.homeworks.extensions.name
import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import org.hamcrest.Matcher

object LanguagesScreen : NamedScreen<LanguagesScreen>() {
    override val screenName = "Экран добавления языка"
    override val layoutId = null
    override val viewClass = null

    val languages by lazy {
        KRecyclerView(
            builder = {
                withId(R.id.wikipedia_languages_recycler)
            },
            itemTypeBuilder = {
                itemType(::WikiLanguagesItem)
            }
        ).name(withParent("Блоки языков"))


    }

    val wikiLanguageTitle by lazy{
        KTextView{
            withText("Add language")
        }.name(withParent("Кнопка Add language"))
    }
}


class WikiLanguagesItem(matcher: Matcher<View>) : KRecyclerItem<WikiLanguagesItem>(matcher) {
}