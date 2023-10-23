package io.github.l2hyunwoo.translator.android.translate.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.l2hyunwoo.translator.translate.domain.history.HistoryDataSource
import io.github.l2hyunwoo.translator.translate.domain.translate.Translate
import io.github.l2hyunwoo.translator.translate.presentation.TranslateEvent
import io.github.l2hyunwoo.translator.translate.presentation.TranslateViewModel
import javax.inject.Inject

@HiltViewModel
class AndroidTranslateViewModel @Inject constructor(
    private val translate: Translate,
    private val historyDataSource: HistoryDataSource
): ViewModel() {
    private val viewModel by lazy {
        TranslateViewModel(
            translate,
            historyDataSource,
            viewModelScope
        )
    }
    val state = viewModel.state

    fun onEvent(event: TranslateEvent) {
        viewModel.onEvent(event)
    }
}
