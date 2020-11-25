package com.example.mvitestapp

import androidx.lifecycle.LiveData

interface IModel<S : IState, I : IIntent> {
    val intents : SingleLiveEvent<I>
    val state : LiveData<S>
}