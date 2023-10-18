package io.github.l2hyunwoo.translator

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform