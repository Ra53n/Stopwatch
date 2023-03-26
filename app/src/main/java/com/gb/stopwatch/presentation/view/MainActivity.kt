package com.gb.stopwatch.presentation.view

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.gb.stopwatch.R
import com.gb.stopwatch.presentation.viewModel.MainActivityViewModelContract
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val viewModel: MainActivityViewModelContract.ViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.text_time)
        CoroutineScope(Dispatchers.Main).launch {
            viewModel.stopwatchState.collect() {
                textView.text = it
            }
        }

        findViewById<Button>(R.id.button_start).setOnClickListener {
            viewModel.onStopwatchStartClick()
        }
        findViewById<Button>(R.id.button_pause).setOnClickListener {
            viewModel.onStopwatchStartPause()
        }
        findViewById<Button>(R.id.button_stop).setOnClickListener {
            viewModel.onStopwatchStartStop()
        }

    }
}