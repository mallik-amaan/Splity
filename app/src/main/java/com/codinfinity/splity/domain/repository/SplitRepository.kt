package com.codinfinity.splity.domain.repository

import com.codinfinity.splity.features.split.data.SplitData

interface SplitRepository{
    suspend fun addSplit(split: SplitData): String

    suspend fun addSplitToGroup(split: SplitData, groupId: Int)
}