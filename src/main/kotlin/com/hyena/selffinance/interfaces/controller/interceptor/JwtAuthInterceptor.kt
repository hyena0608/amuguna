package com.hyena.selffinance.interfaces.controller.interceptor

import com.hyena.selffinance.context.ThreadLocalContext
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.stereotype.Component
import org.springframework.web.servlet.HandlerInterceptor

/**
 * @Description
 * @Owner hyunseo
 * @Date 6/30/24
 */
@Component
class JwtAuthInterceptor: HandlerInterceptor {
    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        val bearer = request.getHeader(AUTHORIZATION).ifEmpty {
            throw IllegalArgumentException("JWT ㅇㄷ")
        }

        val token = if (bearer.startsWith(BEARER)) {
            bearer.removePrefix(BEARER).trim()
        } else {
            throw IllegalArgumentException("Bearer ㅇㄷ")
        }

        // TODO : token 파싱
        ThreadLocalContext.getContext().set(JWT_USER_ID, token.toLong())

        return super.preHandle(request, response, handler)
    }

    override fun afterCompletion(
        request: HttpServletRequest,
        response: HttpServletResponse,
        handler: Any,
        ex: Exception?,
    ) {
        try {
            super.afterCompletion(request, response, handler, ex)
        } finally {
            ThreadLocalContext.getContext().remove(JWT_USER_ID)
        }
    }

    companion object {
        private const val AUTHORIZATION = "Authorization"
        private const val BEARER = "Bearer"
        const val JWT_USER_ID = "JWT_USER_ID"
    }
}
