package org.wikipedia.lesson18.homeworks.extensions

import androidx.test.espresso.matcher.ViewMatchers
import io.github.kakaocup.kakao.common.actions.BaseActions
import io.github.kakaocup.kakao.pager2.KViewPager2
import io.github.kakaocup.kakao.pager2.KViewPagerItem
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import org.hamcrest.CoreMatchers.anyOf
import org.wikipedia.lesson18.homeworks.NameHierarchy

private val elements = mutableMapOf<BaseActions, NameHierarchy>()

fun <T : BaseActions> T.name(nameHierarchy: NameHierarchy): T {
    elements[this] = nameHierarchy
    return this
}

fun <T : BaseActions> T.getName(): NameHierarchy {
    return elements[this] ?: NameHierarchy("NO_LABEL", null)
}

fun <T : BaseActions> T.withParent(name: String): NameHierarchy {
    return getName().withParent(name)
}

inline fun <reified T : KViewPagerItem<T>> KViewPager2.invokeByIndex(
    index: Int,
    crossinline fnc: T.() -> Unit
) {
    val pager = this
    childAt<T>(index) {
        name(pager.withParent("$index"))
        fnc()
    }
}

inline fun <reified T : KRecyclerItem<T>> KRecyclerView.getByIndex(index: Int): T {
    return childWith<T> {
        onPosition(index)
    }.name(withParent("$index"))
}

inline fun <reified T : KRecyclerItem<T>> KRecyclerView.getByText(text: String): T {
    return childWith<T> {
        withMatcher(
            anyOf(
                ViewMatchers.withText(text),
                ViewMatchers.hasDescendant(ViewMatchers.withText(text))
            )
        )
    }.name(withParent(text))
}

inline fun <reified T : KRecyclerItem<T>> KRecyclerView.invokeAtIndex(index: Int, fnc: T.() -> Unit) {
    getByIndex<T>(index).fnc()
}

inline fun <reified T : KRecyclerItem<T>> KRecyclerView.invokeWithText(text: String, fnc: T.() -> Unit) {
    getByText<T>(text).fnc()
}

