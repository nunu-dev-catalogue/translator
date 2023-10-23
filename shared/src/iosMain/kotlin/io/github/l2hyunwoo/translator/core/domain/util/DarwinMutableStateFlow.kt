package io.github.l2hyunwoo.translator.core.domain.util

import kotlinx.coroutines.flow.MutableStateFlow

class DarwinMutableStateFlow<T>(initialValue: T) :
    CommonMutableStateFlow<T>(MutableStateFlow(initialValue))
