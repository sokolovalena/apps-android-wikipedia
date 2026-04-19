package org.wikipedia.lesson21.homewroks

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import org.wikipedia.lesson18.homeworks.extensions.getName
import org.wikipedia.lesson18.homeworks.extensions.name
import kotlin.math.min

inline fun <reified T : KRecyclerItem<T>> KRecyclerView.invokeAtIndexAndClass(
    index: Int,
    startWith: Int,
    limit: Int,
    clazz: Class<out View>,
    name: String = "$index",
    fnc: T.() -> Unit
) {
    val recycler = this
    val numberOfElements = recycler.getSize()
    val lastIndex = min(limit, numberOfElements - 1)
    val firstIndex = min(startWith, lastIndex)
    var counter = 0
    for (i in firstIndex..lastIndex) {
        childAt<T>(i) {
            val isElementWithClass = hasClassOrChildWithClass(clazz)
            if (isElementWithClass && counter++ == index) {
                name(recycler.getName().withParent(name))
                fnc()
                return
            }
        }
    }
}

inline fun <reified T : KRecyclerItem<T>> KRecyclerView.invokeAtIndexAndId(
    index: Int,
    startWith: Int,
    limit: Int,
    resourceId: Int,
    name: String = "$index",
    fnc: T.() -> Unit
) {
    val recycler = this
    val numberOfElements = recycler.getSize()
    val lastIndex = min(limit, numberOfElements - 1)
    val firstIndex = min(startWith, lastIndex)
    var counter = 0
    for (i in firstIndex..lastIndex) {
        childAt<T>(i) {
            val isElementWithId = hasIdOrChildWithId(resourceId)
            if (isElementWithId && counter++ == index) {
                name(recycler.getName().withParent(name))
                fnc()
                return
            }
        }
    }
}