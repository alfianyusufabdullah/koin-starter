package com.alfianyusufabdullah.koinstarter.counter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.alfianyusufabdullah.koinstarter.entity.Counter
import org.jetbrains.anko.find
import org.jetbrains.anko.setContentView
import org.koin.android.ext.android.inject

class CounterActivity : AppCompatActivity(), CounterContract.View {

    private val tvResult by lazy {
        this.find<TextView>(CounterActivityView.ID_TEXT_RESULT)
    }

    private val btnIncrement by lazy {
        this.find<TextView>(CounterActivityView.ID_BTN_INCREMENT)
    }

    private val btnDecrement by lazy {
        this.find<TextView>(CounterActivityView.ID_BTN_DECREMENT)
    }

    override fun onResult(counter: Counter) {
        tvResult.text = counter.result.toString()
    }

    private val counterPresenter by inject<CounterPresenter>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CounterActivityView().setContentView(this)

        counterPresenter.attachView(this)

        btnIncrement.setOnClickListener {
            val value = tvResult.text.toString().toInt()
            counterPresenter.increment(value)
        }

        btnDecrement.setOnClickListener {
            val value = tvResult.text.toString().toInt()
            if (value > 0) counterPresenter.decrement(value)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        counterPresenter.detachView()
    }
}
