package io.github.l2hyunwoo.translator.translate.domain.translate

import io.github.l2hyunwoo.translator.core.domain.language.Language

interface TranslateClient {
    suspend fun translate(
        fromLanguage: Language,
        fromText: String,
        toLanguage: Language
    ): String
}
