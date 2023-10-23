package io.github.l2hyunwoo.translator.translate.domain.history

import io.github.l2hyunwoo.translator.core.domain.util.CommonFlow

interface HistoryDataSource {
    fun getHistory(): CommonFlow<List<HistoryItem>>
    suspend fun insertHistoryItem(item: HistoryItem)
}
