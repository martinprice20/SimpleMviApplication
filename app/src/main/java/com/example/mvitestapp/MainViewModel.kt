package com.example.mvitestapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.Collections.copy

class MainViewModel : ViewModel(), IModel<MainState, UserIntent> {

    private val _intent : SingleLiveEvent<UserIntent> = SingleLiveEvent()
    override val intents: SingleLiveEvent<UserIntent>
        get() = _intent

    private val _state = MutableLiveData<MainState>().apply { value = MainState() }
    override val state: LiveData<MainState>
        get() = _state


    fun onReduceState(userIntent: UserIntent): MainState =
            when (userIntent) {
                is UserIntent.BoxOneCheck -> _state.value!!.copy(isCheckBoxOneChecked = true)
                is UserIntent.BoxOneUncheck -> _state.value!!.copy(isCheckBoxOneChecked = false)
                is UserIntent.BoxTwoCheck -> _state.value!!.copy(isCheckBoxTwoChecked = true)
                is UserIntent.BoxTwoUncheck -> _state.value!!.copy(isCheckBoxTwoChecked = false)
            }

    fun userAction(userIntent: UserIntent){
        when (userIntent){
            is UserIntent.BoxOneCheck   -> { sendViewAction(userIntent) }
            is UserIntent.BoxOneUncheck -> { sendViewAction(userIntent) }
            is UserIntent.BoxTwoCheck   -> { sendViewAction(userIntent) }
            is UserIntent.BoxTwoUncheck -> { sendViewAction(userIntent) }
        }
    }

    protected fun sendViewAction (userIntent: UserIntent) {
        _state.value = onReduceState(userIntent)
    }

}

