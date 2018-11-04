package com.alfianyusufabdullah.koinstarter.counter

import com.alfianyusufabdullah.koinstarter.repository.CounterRepository

class CounterPresenter(private val counterRepository: CounterRepository) : CounterContract.Presenter {

    private var mView: CounterContract.View? = null

    fun attachView(view: CounterContract.View) {
        mView = view
    }

    fun detachView() {
        mView = null
    }

    override fun increment(value: Int) {
        counterRepository.increment(value){
            mView?.onResult(it)
        }
    }

    override fun decrement(value: Int) {
        counterRepository.decrement(value){
            mView?.onResult(it)
        }
    }
}