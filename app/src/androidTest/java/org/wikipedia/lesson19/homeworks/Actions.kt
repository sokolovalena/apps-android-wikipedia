package org.wikipedia.lesson19.homeworks

import io.github.kakaocup.compose.node.action.NodeActions
import io.github.kakaocup.kakao.common.actions.BaseActions
import io.github.kakaocup.kakao.switch.SwitchableActions
import org.wikipedia.lesson18.homeworks.extensions.getName
import org.wikipedia.lesson24.homeworks.ext.getName

class Actions(private val steps: StepDefinitions) : StepsDSL<Actions>() {

    override val self = this

    fun click(element: BaseActions) {
        steps.click("Нажимает на '${element.getName()}'", element)
    }

    fun swipeSwitchLeft(element: SwitchableActions){
        element.swipeSwitchThumb (SwitchableActions.Direction.LEFT)
    }
    fun swipeSwitchRight(element: SwitchableActions){
        element.swipeSwitchThumb (SwitchableActions.Direction.RIGHT)
    }

    fun clickIfEnabled(element: NodeActions) {
        steps.clickIfEnabled("Click if enabled '${element.getName()}'", element)
    }
}