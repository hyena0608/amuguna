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
class ThreadLocalInterceptor : HandlerInterceptor {
    override fun afterCompletion(
        request: HttpServletRequest,
        response: HttpServletResponse,
        handler: Any,
        ex: Exception?,
    ) {
        try {
            super.afterCompletion(request, response, handler, ex)
        } finally {
            ThreadLocalContext.getContext().removeAll()
        }
    }
}
