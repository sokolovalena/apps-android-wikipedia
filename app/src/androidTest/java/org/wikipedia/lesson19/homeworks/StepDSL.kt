package org.wikipedia.lesson19.homeworks

abstract class StepsDSL<T : StepsDSL<T>> {

    abstract val self: T

    operator fun invoke(fnc: T.() -> Unit) {
        self.fnc()
    }
}