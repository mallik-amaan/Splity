package com.codinfinity.splity.data.models

import java.util.Date

data class ExpenseModel(
    val id: String,
    val description: String,
    val amount: Double,
    val paidBy: String,
    val groupId: String,
    val createdAt: Date
)
