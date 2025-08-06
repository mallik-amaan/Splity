package com.codinfinity.splity.data.repository

import android.util.Log
import com.codinfinity.splity.data.models.UserModel
import com.codinfinity.splity.domain.repository.AddFriendRepository
import io.github.jan.supabase.postgrest.Postgrest
import javax.inject.Inject

class AddFriendRepositoryImpl @Inject constructor(
    private val postgres: Postgrest

) : AddFriendRepository{
        override suspend fun searchFriendByEmail(email: String): UserModel? {
            return  try {
                Log.d("searchFriendByEmail", "searchFriendByEmail: Searching for user: $email")
               val user =  postgres.from("users").select {
                    filter {
                        ilike("email", email)
                    }
                }.decodeList<UserModel>().firstOrNull()

                Log.d("searchFriendByEmail", "searchFriendByEmail: $user")
                return user

//                val user = UserModel(
//                    name = "Ali",
//                    email = email,
//                )
//                    postgres.from("users").insert(user)
//                return null
            }
            catch (e: Exception){
                Log.d("searchFriendByEmail", "searchFriendByEmail: $e")
                return null
            }
        }

    override suspend fun addFriend(userId: String, friendId: String): Boolean {
        TODO("Not yet implemented")
    }


}