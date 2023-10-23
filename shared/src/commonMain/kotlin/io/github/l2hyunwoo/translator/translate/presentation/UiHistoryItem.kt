package io.github.l2hyunwoo.translator.translate.presentation

import io.github.l2hyunwoo.translator.core.presentation.UiLanguage

data class UiHistoryItem(
    val id: Long,
    val fromText: String,
    val toText: String,
    val fromLanguage: UiLanguage,
    val toLanguage: UiLanguage
)
