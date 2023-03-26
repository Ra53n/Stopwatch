package com.gb.stopwatch.presentation.viewModel

import kotlinx.coroutines.flow.StateFlow

interface MainActivityViewModelContract {
    abstract class ViewModel : androidx.lifecycle.ViewModel() {
        abstract fun onStopwatchStartClick()

        abstract fun onStopwatchStartPause()

        abstract fun onStopwatchStartStop()

        abstract val stopwatchState: StateFlow<String>

    }
}