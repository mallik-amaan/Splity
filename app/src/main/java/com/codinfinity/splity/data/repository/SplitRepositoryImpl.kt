package com.codinfinity.splity.data.repository

import android.util.Log
import com.codinfinity.splity.data.models.FunctionResponse
import com.codinfinity.splity.domain.repository.SplitRepository
import com.codinfinity.splity.features.split.data.SplitData
import io.github.jan.supabase.functions.Functions
import io.ktor.client.call.body
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import javax.inject.Inject

class SplitRepositoryImpl @Inject constructor(
    private val functions: Functions
) : SplitRepository {
    override suspend fun addSplit(split: SplitData): String {
        Log.d("AddSplit", "addSplit: Function called")
        val splitFunction = functions.buildEdgeFunction(
            function = "smart-responder",


        )
//
        val response = splitFunction.invoke(
            requestOverride = {
                contentType(ContentType.Application.Json)
                setBody(mapOf("name" to "Amaan"))
            }
        )
        val data = response.body<FunctionResponse>()
        Log.d("AddSplit", "addSplit: $data")
        return data.message
    }




    override suspend fun addSplitToGroup(
        split: SplitData,
        groupId: Int
    ) {
        TODO("Not yet implemented")
    }

}