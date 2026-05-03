package org.wikipedia.lesson23.homeworks

import androidx.compose.ui.test.hasText
import org.junit.Test
import org.wikipedia.lesson08.homeworks.TopReadItems
import org.wikipedia.lesson18.homeworks.ExploreScreen
import org.wikipedia.lesson18.homeworks.OnboardingScreen
import org.wikipedia.lesson19.homeworks.action
import org.wikipedia.lesson19.homeworks.verify
import org.wikipedia.lesson20.homeworks.BaseTest

class WebViewTests: BaseTest() {

    @Test
    fun webviewtest(){
        run{
            OnboardingScreen{
                action.click(skipButton)
            }
            ExploreScreen.topReadBlock {
                items.childAt<TopReadItems>(0,{
                    action.click(this)
                })
            }
            ArticleScreen{
                verify.isDisplayed(popupCloseButton)
                popupCloseButton.click()

                verify.isDisplayed(title)
                verify.isDisplayed(references)

                references{
                    performWebViewAction {
                        click()
                    }
                }

                referenceItem(2){
                    performWebViewAction {
                        scroll()
                    }
                    hasText("[2]")
                }

                Thread.sleep(100_000)
            }
        }
    }
}