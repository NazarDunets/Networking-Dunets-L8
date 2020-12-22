package com.example.networking_dunets_l8.models

data class CatFact(
        val text: String,
        val createdAt: String,
        val deleted: Boolean,
        val source: String,
        val status: FactStatus,
        val type: String,
        val updatedAt: String,
        val used: Boolean,
        val user: String
)

data class FactStatus(
        val feedback: String,
        val sentCount: Int,
        val verified: Boolean
)