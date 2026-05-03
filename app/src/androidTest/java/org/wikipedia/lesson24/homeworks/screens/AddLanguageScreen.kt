package org.wikipedia.lesson24.homeworks.screens


import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import org.hamcrest.Matcher
import org.wikipedia.compose.extensions.uiTest.Tags.LANGUAGE_LIST
import org.wikipedia.lesson24.homeworks.ext.createLazyList
import org.wikipedia.lesson24.homeworks.ext.invokeWithText

class AddLanguageScreen : ComposeScreenBase<AddLanguageScreen>() {
    override val screenName: String = "Экран добавления языков"

    val items by lazy {
        createLazyList(
            viewBuilderAction = {
                hasTestTag(LANGUAGE_LIST)
            },
            itemTypeBuilder = {
                itemType(::LanguageItem)
            }
        )
    }

    fun getLang(fnc: LanguageItem.() -> Unit) {
        items.invokeWithText("日本語", fnc)
    }
}