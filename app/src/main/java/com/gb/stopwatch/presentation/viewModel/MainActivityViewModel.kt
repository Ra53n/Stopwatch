package com.gb.stopwatch.presentation.viewModel

import com.gb.stopwatch.domain.StopwatchListOrchestrator
import com.gb.stopwatch.domain.state.StopwatchStateHolder
import com.gb.stopwatch.domain.utils.ElapsedTimeCalculator
import com.gb.stopwatch.domain.utils.StopwatchStateCalculator
import com.gb.stopwatch.domain.utils.TimestampMillisecondsFormatter
import com.gb.stopwatch.domain.utils.TimestampProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.StateFlow

class MainActivityViewModel(
) : MainActivityViewModelContract.ViewModel() {

    private val timestampProvider = object : TimestampProvider {
        override fun getMilliseconds() = System.currentTimeMillis()
    }

    private val stopwatchListOrchestrator =
        StopwatchListOrchestrator(
            StopwatchStateHolder(
                StopwatchStateCalculator(
                    timestampProvider,
                    ElapsedTimeCalculator(timestampProvider)
                ),
                ElapsedTimeCalculator(timestampProvider),
                TimestampMillisecondsFormatter()
            ),
            CoroutineScope(Dispatchers.Main + SupervisorJob())
        )

    override val stopwatchState: StateFlow<String> = stopwatchListOrchestrator.ticker

    override fun onStopwatchStartClick() {
        stopwatchListOrchestrator.start()
    }

    override fun onStopwatchStartPause() {
        stopwatchListOrchestrator.pause()
    }

    override fun onStopwatchStartStop() {
        stopwatchListOrchestrator.stop()
    }

}