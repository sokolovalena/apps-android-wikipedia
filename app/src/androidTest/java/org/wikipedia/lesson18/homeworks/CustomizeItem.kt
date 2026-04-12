package org.wikipedia.lesson18.homeworks

import android.view.View
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.lesson18.homeworks.extensions.name
import org.wikipedia.lesson18.homeworks.extensions.withParent

class CustomizeItemV2(matcher: Matcher<View>) : KRecyclerItem<CustomizeItemV2>(matcher) {

    val imageHeader = KView(matcher) {
        withId(R.id.view_announcement_header_image)
    }.name(withParent("Иконка кастомизации"))

    val announcementText = KTextView(matcher) {
        withId(R.id.view_announcement_text)
    }.name(withParent("Текст кастомизации"))

    val positiveButton = KButton(matcher) {
        withId(R.id.view_announcement_action_positive)
    }.name(withParent("Кнопка включения кастомизации"))

    val negativeButton = KButton(matcher){
        withId(R.id.view_announcement_action_negative)
    }.name(withParent("Кнопка отмены кастомизации"))

}