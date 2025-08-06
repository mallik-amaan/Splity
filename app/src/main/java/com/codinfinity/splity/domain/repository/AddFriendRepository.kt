package com.codinfinity.splity.domain.repository

import com.codinfinity.splity.data.models.UserModel

interface AddFriendRepository {

    suspend fun searchFriendByEmail(email: String): UserModel?

    suspend fun addFriend(userId: String, friendId: String):Boolean
}