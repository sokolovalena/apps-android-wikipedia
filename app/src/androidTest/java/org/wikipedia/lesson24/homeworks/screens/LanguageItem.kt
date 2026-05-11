package org.wikipedia.lesson24.homeworks.screens

import androidx.compose.ui.semantics.SemanticsNode
import androidx.compose.ui.test.SemanticsNodeInteractionsProvider
import com.kaspersky.components.composesupport.core.KNode
import io.github.kakaocup.compose.node.element.lazylist.KLazyListItemNode
import org.wikipedia.compose.extensions.uiTest.Tags.LOCALIZED_LANGUAGE_NAME
import org.wikipedia.compose.extensions.uiTest.Tags.SUBTITLE
import org.wikipedia.lesson24.homeworks.ext.name
import org.wikipedia.lesson24.homeworks.ext.withParent

class LanguageItem(
    semanticNode: SemanticsNode,
    semanticsProvider: SemanticsNodeInteractionsProvider? = null
) : KLazyListItemNode<LanguageItem>(semanticNode, semanticsProvider) {

    val titleLanguage by lazy {
        child<KNode>{
            hasTestTag(LOCALIZED_LANGUAGE_NAME)
        }.name(withParent("Заголовок язык локализации"))
    }

    val subtitleLanguage by lazy {
        child<KNode>{
            hasTestTag(SUBTITLE)
        }.name(withParent("Подзаголовок языка"))
    }
}