package com.hyena.selffinance.interfaces.controller.interceptor

import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.web.servlet.HandlerInterceptor
import org.springframework.web.servlet.ModelAndView

/**
 * @Description
 * @Owner hyunseo
 * @Date 7/6/24
 */
@Component
class CommonLogInterceptor : HandlerInterceptor {
    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        // TODO: 요청 콘텐츠 캐싱
        logger.info("[전처리 요청] ===> [[handler=${handler.javaClass.name}],[uri:{}],[method:{}],[headers:{}]]", request.requestURI, request.method, toHeaderLog(request))
        return super.preHandle(request, response, handler)
    }

    private fun toHeaderLog(request: HttpServletRequest): String {
        return request.headerNames
            .asSequence()
            .map {
                val value = request.getHeader(it)
                "${it}:${value}"
            }.joinToString(",")
    }

    override fun postHandle(
        request: HttpServletRequest,
        response: HttpServletResponse,
        handler: Any,
        modelAndView: ModelAndView?,
    ) {
        // TODO: 응답 콘텐츠 캐싱
        logger.info("[후처리 응답] ===> [[handler=${handler.javaClass.name}],[status:{}],[uri:{}],[method:{}],[headers:{}]]", response.status, request.requestURI, request.method, toHeaderLog(response))
        super.postHandle(request, response, handler, modelAndView)
    }

    private fun toHeaderLog(response: HttpServletResponse): String {
        return response.headerNames
            .asSequence()
            .map {
                val value = response.getHeader(it)
                "${it}:${value}"
            }.joinToString(",")
    }

    override fun afterCompletion(
        request: HttpServletRequest,
        response: HttpServletResponse,
        handler: Any,
        ex: Exception?,
    ) {
        super.afterCompletion(request, response, handler, ex)
    }

    companion object {
        private val logger = LoggerFactory.getLogger(this::class.java.name)
    }
}
