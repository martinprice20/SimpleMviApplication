package com.example.mvitestapp

sealed class UserIntent : IIntent {
    object BoxOneCheck : UserIntent()
    object BoxOneUncheck : UserIntent()
    object BoxTwoCheck : UserIntent()
    object BoxTwoUncheck : UserIntent()
}