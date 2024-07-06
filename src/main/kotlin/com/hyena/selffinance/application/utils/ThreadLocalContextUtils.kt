package com.hyena.selffinance.application.utils

import com.hyena.selffinance.context.ThreadLocalContext
import com.hyena.selffinance.domain.User
import com.hyena.selffinance.interfaces.controller.interceptor.JwtAuthInterceptor

/**
 * @Description
 * @Owner hyunseo
 * @Date 7/6/24
 */
object ThreadLocalContextUtils {
    fun getUserIdOrThrowException(): Long {
        val userId = ThreadLocalContext.getContext()
            .get(JwtAuthInterceptor.JWT_USER_ID) ?: throw IllegalArgumentException()

        return when (userId) {
            is Long -> userId
            else -> throw IllegalArgumentException()
        }
    }

    fun getUserOrThrowException(): User {
        val user = ThreadLocalContext.getContext()
            .get(JwtAuthInterceptor.JWT_USER_ID) ?: throw IllegalArgumentException()

        return when (user) {
            is User -> user
            else -> throw IllegalArgumentException()
        }
    }
}
