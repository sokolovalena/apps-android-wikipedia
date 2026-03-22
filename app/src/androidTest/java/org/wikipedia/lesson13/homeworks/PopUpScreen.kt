package org.wikipedia.lesson13.homeworks

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.text.KButton
import org.wikipedia.R

object PopUpScreen : KScreen<PopUpScreen>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val closeButton = KButton {
        withId(R.id.closeButton)
    }
}