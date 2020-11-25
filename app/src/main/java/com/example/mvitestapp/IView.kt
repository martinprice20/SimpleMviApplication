package com.example.mvitestapp

interface IView<S: IState> {
    fun render(state: S)
}