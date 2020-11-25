package com.example.mvitestapp

import android.os.Bundle
import android.widget.CompoundButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity(), MainView {

    private lateinit var viewModel: MainViewModel
    private lateinit var viewModelFactory: MainViewModelFactory
    private lateinit var checkBoxOne : CompoundButton
    private lateinit var checkBoxTwo : CompoundButton

    private var mOnCheckedChangeListener = CompoundButton.OnCheckedChangeListener { button: CompoundButton, isChecked ->
        run {
            if (isChecked) {
                if (button.id == R.id.checkBoxOne) {
                    viewModel.userAction(UserIntent.BoxOneCheck)
                } else {
                    viewModel.userAction(UserIntent.BoxTwoCheck)
                }
            } else {
                if (button.id == R.id.checkBoxOne) {
                    viewModel.userAction(UserIntent.BoxOneUncheck)
                } else {
                    viewModel.userAction(UserIntent.BoxTwoUncheck)
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModelFactory = MainViewModelFactory()
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        viewModel.state.observe(this, Observer {
            mainState -> updateView(mainState)
        })

        checkBoxOne = findViewById(R.id.checkBoxOne)
        checkBoxTwo = findViewById(R.id.checkBoxTwo)

        checkBoxOne.setOnCheckedChangeListener (mOnCheckedChangeListener)
        checkBoxTwo.setOnCheckedChangeListener (mOnCheckedChangeListener)


    }

    private fun updateView(mainState: MainState) {
        if (mainState.isCheckBoxOneChecked) {
            findViewById<TextView>(R.id.box_one_state).setText(R.string.box_one_checked_text)
        } else {
            findViewById<TextView>(R.id.box_one_state).setText(R.string.box_one_unchecked_text)
        }
        if (mainState.isCheckBoxTwoChecked) {
            findViewById<TextView>(R.id.box_two_state).setText(R.string.box_two_checked_text)
        } else {
            findViewById<TextView>(R.id.box_two_state).setText(R.string.box_two_unchecked_text)
        }
    }








}