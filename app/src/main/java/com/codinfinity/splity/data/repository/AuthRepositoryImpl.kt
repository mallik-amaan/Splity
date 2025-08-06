package com.codinfinity.splity.data.repository

import android.content.Context
import android.util.Log
import androidx.core.content.edit
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import com.codinfinity.splity.di.UserSession
import com.codinfinity.splity.domain.repository.AuthRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.auth.providers.Google
import io.github.jan.supabase.auth.providers.builtin.Email
import io.github.jan.supabase.auth.user.UserInfo
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.storage.Storage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import java.io.InputStream
import javax.inject.Inject


class AuthRepositoryImpl @Inject constructor(
    private val auth: Auth,
    private val storage: Storage,
    private val postgres : Postgrest,
    private val userSession: UserSession,
    @ApplicationContext private val context: Context
): AuthRepository {
    private val USER_INFO_KEY = "user_info"
    private val sharedPrefs by lazy {
        val masterKey = MasterKey.Builder(context)
            .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
            .build()

        EncryptedSharedPreferences.create(
            context,
            "secure_user_prefs",
            masterKey,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
    }



    override suspend fun signIn(email: String, password: String): UserInfo? {
        return try {
           auth.signInWith(Email) {
                this.email = email
                this.password = password
            }
            auth.currentUserOrNull()
        } catch (e: Exception) {
            null
        }
    }

    override suspend fun signUp(email: String, password: String): UserInfo? {
        return try {
            val result = auth.signUpWith(Email) {
                this.email = email
                this.password = password
            }
            result
        } catch (e: Exception) {
            null
        }
    }

    override suspend fun logout(): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun signInWithGoogle(): Boolean {
        return try {
            auth.signInWith(Google)
            true
        } catch (e: Exception) {
            false
        }
    }


    override suspend fun setUpBasicInfo(
        name: String,
        profilePicture: InputStream,
        country: String
    ): Boolean {
        try {
            val user = userSession.currentUser
            if (user == null) {
                Log.d("UserSession", "No current user session found")
                return false
            }

            Log.d("UserProfile", "Setting up basic info for user: ")
            // Uploading image to bucket
            val response = storage.from("splity-bucket")
                .upload(
                    path = "profile_pictures/12345",
                    data = profilePicture.readBytes(),
                    options = {
                        contentType = io.ktor.http.ContentType.Image.JPEG
                    }

                )

            if (response.id == null) {
                Log.d("Upload", "Error uploading Image: $response")
                return false
            }

            Log.d("Upload", "Profile picture uploaded successfully: ${response}")

            val publicUrl = storage
                .from("splity-bucket")
                .publicUrl("profile_pictures/$12345")

            Log.d("PublicUrl", "Public URL of profile picture: $publicUrl")

            // Save publicUrl to user profile table
//            val firstInsertResponse = postgres.from("users").insert(
//                mapOf(
//                    "id" to user.id,
//                    "name" to name,
//                    "image_url" to publicUrl,
//                    "email" to user.email,
//                )
//            )
//
//            Log.d("Database", "First insert response: $firstInsertResponse")

            return true
        }
        catch (e: Exception) {
            Log.d("Exception", "Error in setUpBasicInfo: ${e.message}")
            return false
        }
    }

    override suspend fun saveUserInfo(userInfo: UserInfo) {
        withContext(Dispatchers.IO) {
            val json = Json.encodeToString(userInfo)
            sharedPrefs.edit() { putString(USER_INFO_KEY, json) }
        }
    }

    override suspend fun getUserInfo(): UserInfo? = withContext(Dispatchers.IO) {
        val json = sharedPrefs.getString(USER_INFO_KEY, null) ?: return@withContext null
        return@withContext try {
            Json.decodeFromString<UserInfo>(json)
        } catch (e: Exception) {
            null
        }
    }

    override suspend fun clearUserInfo() {
        withContext(Dispatchers.IO) {
            sharedPrefs.edit() { remove(USER_INFO_KEY) }
        }
    }
}
