package com.codinfinity.splity.data.models

data class SplitModel(
    val id: String,
    val expenseId: String,
    val userId: String,
    val owedAmount: Double
)
