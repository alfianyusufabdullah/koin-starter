package com.alfianyusufabdullah.koinstarter.module

import com.alfianyusufabdullah.koinstarter.counter.CounterPresenter
import com.alfianyusufabdullah.koinstarter.repository.CounterRepository
import org.koin.dsl.module.module

val calculatorModule = module {

    single { CounterRepository() }
    factory { CounterPresenter(get()) }
}