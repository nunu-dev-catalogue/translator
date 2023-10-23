package io.github.l2hyunwoo.translator.translate.data.history

import io.github.l2hyunwoo.translator.HistoryEntity
import io.github.l2hyunwoo.translator.translate.domain.history.HistoryItem

fun HistoryEntity.toHistoryItem(): HistoryItem {
    return HistoryItem(
        id = id,
        fromLanguageCode = fromLanguageCode,
        fromText = fromText,
        toLanguageCode = toLanguageCode,
        toText = toText,
    )
}
