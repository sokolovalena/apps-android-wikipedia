package org.wikipedia.lesson25.homeworks

class PassInterferingScreens(private val screenBehaviors: List<ScreenBehaviorBase>) {

    /**
     * Вернёт true если мешающий экран был обнаружен и обработан
     */
    fun execute(): Boolean {
        return screenBehaviors.any { it.initBehavior() }
    }
}