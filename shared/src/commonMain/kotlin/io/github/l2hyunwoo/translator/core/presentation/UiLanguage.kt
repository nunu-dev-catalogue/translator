package io.github.l2hyunwoo.translator.core.presentation

import io.github.l2hyunwoo.translator.core.domain.language.Language

expect class UiLanguage {
    val language: Language
    companion object {
        fun byCode(langCode: String): UiLanguage
        val allLanguages: List<UiLanguage>
    }
}
