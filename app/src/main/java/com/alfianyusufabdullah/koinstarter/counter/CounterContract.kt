package com.alfianyusufabdullah.koinstarter.counter

import com.alfianyusufabdullah.koinstarter.entity.Counter

interface CounterContract {

    interface Presenter{
        fun increment(value: Int)
        fun decrement(value: Int)
    }

    interface View{
        fun onResult(counter: Counter)
    }
}