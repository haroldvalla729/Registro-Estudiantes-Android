package com.example.registroestudiantes

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform