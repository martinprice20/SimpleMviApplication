package com.example.mvitestapp

data class MainState(
        val isCheckBoxOneChecked: Boolean = false,
        val isCheckBoxTwoChecked: Boolean = false,
        val areBothCheckBoxesChecked: Boolean = false,
        val error: Throwable? = null
) : IState