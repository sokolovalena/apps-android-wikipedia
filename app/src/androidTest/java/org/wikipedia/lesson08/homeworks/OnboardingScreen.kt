package org.wikipedia.lesson08.homeworks

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.pager2.KViewPager2
import io.github.kakaocup.kakao.pager2.KViewPagerItem
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.tabs.KTabLayout
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import io.github.kakaocup.kakao.toolbar.KToolbar
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.onboarding.OnboardingPageView

object OnboardingScreen : KScreen<OnboardingScreen>() {
    override val layoutId: Int = R.layout.fragment_onboarding_pager
    override val viewClass: Class<*> = OnboardingPageView::class.java

    val pager = KViewPager2(
        builder = {
            withId(R.id.fragment_pager)
        },
        itemTypeBuilder = {
            itemType(::PagerItem)
        }
    )

    val skipButton = KButton {
        withId(R.id.fragment_onboarding_skip_button)
    }

    val tabs = KTabLayout {
        withId(R.id.view_onboarding_page_indicator)
    }

    val continueButton = KButton {
        withId(R.id.fragment_onboarding_forward_button)
    }
}

class PagerItem(matcher: Matcher<View>) : KViewPagerItem<PagerItem>(matcher) {

    val image = KImageView(matcher) {
        withId(R.id.imageViewCentered)
    }
    val title = KTextView(matcher) {
        withId(R.id.primaryTextView)
    }
    val secondaryText = KTextView(matcher) {
        withId(R.id.secondaryTextView)
    }
    val languages = KRecyclerView(
        parent = matcher,
        builder = {
            withId(R.id.languageList)
        },
        itemTypeBuilder = {
            itemType(::LanguageItem)
        }
    )
    val addLanguageButton = KButton(matcher) {
        withId(R.id.addLanguageButton)
    }

}

class LanguageItem(matcher: Matcher<View>) : KRecyclerItem<LanguageItem>(matcher) {
    val listLanguage = KTextView(matcher) {
        withId(R.id.option_label)
    }
}

class AddNewLanguages(matcher: Matcher<View>) : KRecyclerItem<AddNewLanguages>(matcher) {
    val toolbar = KToolbar{
        withId(R.id.toolbar)
    }

    val recyclerLanguageList = KRecyclerView(
        parent = matcher,
        builder = {
            withId(R.id.wikipedia_languages_recycler)
        },
        itemTypeBuilder = {
            itemType(::WikipediaLanguageRecycler)
        }
    )
}

class WikipediaLanguageRecycler(matcher: Matcher<View>) : KRecyclerItem<AddNewLanguages>(matcher) {
    val title = KTextView(matcher) {
        withId(R.id.section_header_text)
    }
    val languageOrder = KTextView(matcher) {
        withId(R.id.wiki_language_order)
    }
    val languageCode = KView(matcher){
        withId(R.id.wiki_language_code)
    }
    val languageTitle = KTextView(matcher) {
        withId(R.id.wiki_language_title)
    }
    val addIcon = KImageView(matcher) {
        isInstanceOf(AppCompatImageView::class.java)
    }
    val addLanguageText = KTextView(matcher) {
        withId(R.id.wiki_language_title)
    }
}
