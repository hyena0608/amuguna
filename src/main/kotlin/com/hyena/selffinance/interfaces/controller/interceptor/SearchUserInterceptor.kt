package com.hyena.selffinance.interfaces.controller.interceptor

import com.hyena.selffinance.context.ThreadLocalContext
import com.hyena.selffinance.domain.repository.UserRepository
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import org.springframework.web.servlet.HandlerInterceptor

/**
 * @Description
 * @Owner hyunseo
 * @Date 7/6/24
 */
@Component
class SearchUserInterceptor(
    private val userRepository: UserRepository
) : HandlerInterceptor {
    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        val userId = ThreadLocalContext.getContext().get(JwtAuthInterceptor.JWT_USER_ID) as Long
        val user = userRepository.findByIdOrNull(userId) ?: throw IllegalArgumentException("[userId:${userId}]")

        ThreadLocalContext.getContext().set(USER_KEY, user)

        return super.preHandle(request, response, handler)
    }

    override fun afterCompletion(
        request: HttpServletRequest,
        response: HttpServletResponse,
        handler: Any,
        ex: Exception?,
    ) {
        ThreadLocalContext.getContext().remove(USER_KEY)
        super.afterCompletion(request, response, handler, ex)
    }

    companion object {
        const val USER_KEY = "SEARCH_USER_INTERCEPTOR_KEY"
    }
}
