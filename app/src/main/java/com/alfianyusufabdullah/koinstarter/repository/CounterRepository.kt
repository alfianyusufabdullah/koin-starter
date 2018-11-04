package com.alfianyusufabdullah.koinstarter.repository

import com.alfianyusufabdullah.koinstarter.entity.Counter

class CounterRepository {

    fun decrement(value: Int, listener : (Counter) -> Unit) =
        listener(Counter(value - 1))

    fun increment(value: Int, listener : (Counter) -> Unit) =
        listener(Counter(value + 1))
}