package com.alfianyusufabdullah.koinstarter.counter

import android.view.Gravity
import android.widget.LinearLayout
import org.jetbrains.anko.*

class CounterActivityView : AnkoComponent<CounterActivity> {

    companion object {
        const val ID_TEXT_RESULT = 0
        const val ID_BTN_INCREMENT = 1
        const val ID_BTN_DECREMENT = 2
    }
    override fun createView(ui: AnkoContext<CounterActivity>) = with(ui) {
        relativeLayout {
            verticalLayout {

                textView("1") {
                    id = ID_TEXT_RESULT
                    textSize = 60f
                    gravity = Gravity.CENTER
                }

                linearLayout {
                    orientation = LinearLayout.HORIZONTAL

                    button("increment") {
                        id = ID_BTN_INCREMENT
                    }

                    button("decrement") {
                        id = ID_BTN_DECREMENT
                    }
                }.lparams(width = matchParent) {
                    topMargin = 16
                }

            }.lparams { centerInParent() }
        }
    }
}