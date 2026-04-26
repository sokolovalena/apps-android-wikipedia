package org.wikipedia.lesson23.homeworks

import com.kaspersky.kaspresso.screens.KScreen
import org.wikipedia.lesson18.homeworks.NameHierarchy

abstract class BaseScreen<T: BaseScreen<T>>: KScreen<T>() {
    override val layoutId = null
    override val viewClass = null

    abstract val screenName: String

    private val nameHierarchy by lazy {
        NameHierarchy(screenName)
    }

    fun withParent(name: String): NameHierarchy {
        return NameHierarchy(name, nameHierarchy)
    }
}