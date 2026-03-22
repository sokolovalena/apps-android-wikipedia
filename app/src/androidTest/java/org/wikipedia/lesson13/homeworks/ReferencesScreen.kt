package org.wikipedia.lesson13.homeworks

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R

object ReferencesScreen : KScreen<ReferencesScreen>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val title = KTextView() {
        withId(R.id.reference_title_text)
    }
    val refId = KTextView(){
        withId(R.id.reference_id)
    }
    val refText = KTextView(){
        withId(R.id.reference_text)
    }
}