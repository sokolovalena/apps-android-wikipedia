package org.wikipedia.lesson19.homeworks

import io.github.kakaocup.kakao.common.actions.BaseActions
import org.wikipedia.lesson18.homeworks.extensions.getName

class Actions(private val steps: StepDefinitions) : StepsDSL<Actions>() {

    override val self = this

    fun click(element: BaseActions) {
        steps.click("Нажимает на '${element.getName()}'", element)
    }
}