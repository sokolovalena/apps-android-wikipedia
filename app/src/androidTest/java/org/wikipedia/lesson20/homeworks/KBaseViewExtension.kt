package org.wikipedia.lesson20.homeworks

import io.github.kakaocup.kakao.common.views.KBaseView

fun KBaseView<*>.multiAction() {
    view.perform(MultiAction("On"))
}