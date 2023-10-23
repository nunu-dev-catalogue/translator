package io.github.l2hyunwoo.translator.core.domain.util

import kotlinx.coroutines.flow.MutableStateFlow

expect open class CommonMutableStateFlow<T>(flow: MutableStateFlow<T>) : MutableStateFlow<T>

fun <T> MutableStateFlow<T>.asMCommonMutableStateFlow(): CommonMutableStateFlow<T> =
    CommonMutableStateFlow(this)
