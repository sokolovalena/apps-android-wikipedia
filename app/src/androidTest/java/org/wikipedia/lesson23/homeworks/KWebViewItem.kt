package org.wikipedia.lesson23.homeworks

import io.github.kakaocup.kakao.web.KWebView

abstract class KWebViewItem(
    kWebView: KWebView,
    listContainerXpath: String
) : KWebViewElementBase<KWebViewItem>(kWebView, listContainerXpath)