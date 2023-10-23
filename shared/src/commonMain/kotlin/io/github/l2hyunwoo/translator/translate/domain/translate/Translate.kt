package io.github.l2hyunwoo.translator.translate.domain.translate

import io.github.l2hyunwoo.translator.core.domain.language.Language
import io.github.l2hyunwoo.translator.core.domain.util.Resource
import io.github.l2hyunwoo.translator.translate.domain.history.HistoryDataSource
import io.github.l2hyunwoo.translator.translate.domain.history.HistoryItem

class Translate(
    private val client: TranslateClient,
    private val historyDataSource: HistoryDataSource
) {
    suspend fun execute(
        fromLanguage: Language,
        fromText: String,
        toLanguage: Language
    ): Resource<String> {
        return try {
            val translatedText = client.translate(fromLanguage, fromText, toLanguage)
            historyDataSource.insertHistoryItem(
                HistoryItem(
                    null,
                    fromLanguage.langCode,
                    fromText,
                    toLanguage.langCode,
                    translatedText
                )
            )
            Resource.Success(translatedText)
        } catch (e: TranslateException) {
            e.printStackTrace()
            Resource.Error(e)
        }
    }
}
