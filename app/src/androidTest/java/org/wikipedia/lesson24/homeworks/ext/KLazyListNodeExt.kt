package org.wikipedia.lesson24.homeworks.ext

import androidx.compose.ui.test.ExperimentalTestApi
import io.github.kakaocup.compose.node.element.lazylist.KLazyListItemNode
import io.github.kakaocup.compose.node.element.lazylist.KLazyListNode

inline fun <reified T : KLazyListItemNode<*>> KLazyListNode.invokeAtIndex(
    index: Int,
    fnc: T.() -> Unit
) {
    val list = this
    childAt<T>(index) {
        name(list.withParent("$index"))
        fnc()
    }
}

inline fun <reified T : KLazyListItemNode<*>> KLazyListNode.invokeWithText(
    text: String,
    fnc: T.() -> Unit
) {
    childWith<T> {
        hasText(text, true)
    }.name(withParent(text))
        .fnc()
}