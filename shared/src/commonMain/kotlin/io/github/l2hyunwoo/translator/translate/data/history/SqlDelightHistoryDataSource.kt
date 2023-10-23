package io.github.l2hyunwoo.translator.translate.data.history

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import io.github.l2hyunwoo.translator.TranslateDatabase
import io.github.l2hyunwoo.translator.core.domain.util.CommonFlow
import io.github.l2hyunwoo.translator.core.domain.util.asCommonFlow
import io.github.l2hyunwoo.translator.translate.domain.history.HistoryDataSource
import io.github.l2hyunwoo.translator.translate.domain.history.HistoryItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.map
import kotlinx.datetime.Clock

class SqlDelightHistoryDataSource(
    private val database: TranslateDatabase,
) : HistoryDataSource {
    private val queries = database.translateQueries
    override fun getHistory(): CommonFlow<List<HistoryItem>> {
        return queries.getHistory()
            .asFlow()
            .mapToList(Dispatchers.IO)
            .map { history ->
                history.map { it.toHistoryItem() }
            }.asCommonFlow()
    }

    override suspend fun insertHistoryItem(item: HistoryItem) {
        queries.insertHistoryEntity(
            id = item.id,
            fromLanguageCode = item.fromLanguageCode,
            fromText = item.fromText,
            toLanguageCode = item.toLanguageCode,
            toText = item.toText,
            timeStamp = Clock.System.now().toEpochMilliseconds()
        )
    }
}