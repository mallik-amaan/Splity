package com.codinfinity.splity.features.split.data

data class SplitData(
    val amount: Double,
    val description: String,
    val date: String,
    val category: String,
    val splitWith:List<String>
)
