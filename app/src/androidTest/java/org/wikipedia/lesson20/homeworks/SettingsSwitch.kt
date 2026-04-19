package org.wikipedia.lesson20.homeworks

import android.view.View
import io.github.kakaocup.kakao.check.KCheckBox
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import org.hamcrest.Matcher
import org.wikipedia.R

class SettingsSwitch(matcher: Matcher<View>) : KRecyclerItem<SettingsSwitch>(matcher) {

    val switcher by lazy {
        KCheckBox(matcher) {
            withId(R.id.switchWidget)
        }
    }
}