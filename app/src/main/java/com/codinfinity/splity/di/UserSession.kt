package com.codinfinity.splity.di

import io.github.jan.supabase.auth.user.UserInfo
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserSession @Inject constructor() {
    var currentUser: UserInfo? = null
        private set

    fun setUser(user: UserInfo) {
        currentUser = user
    }

    fun clear() {
        currentUser = null
    }
}
