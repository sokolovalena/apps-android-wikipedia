package org.wikipedia.lesson18.homeworks

class NameHierarchy(private val name: String, private val parent: NameHierarchy? = null) {

    fun withParent(name: String): NameHierarchy {
        return NameHierarchy(name, this)
    }

    override fun toString(): String {
        return (parent?.let { "$it : " } ?: "") + name
    }
}