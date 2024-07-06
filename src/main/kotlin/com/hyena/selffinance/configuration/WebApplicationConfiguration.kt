package com.hyena.selffinance.configuration

import com.hyena.selffinance.interfaces.controller.interceptor.CommonLogInterceptor
import com.hyena.selffinance.interfaces.controller.interceptor.JwtAuthInterceptor
import com.hyena.selffinance.interfaces.controller.interceptor.SearchUserInterceptor
import com.hyena.selffinance.interfaces.controller.interceptor.ThreadLocalInterceptor
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

/**
 * @Description
 * @Owner hyunseo
 * @Date 6/30/24
 */
@Configuration
class WebApplicationConfiguration(
    private val commonLogInterceptor: CommonLogInterceptor,
    private val threadLocalInterceptor: ThreadLocalInterceptor,
    private val jwtAuthInterceptor: JwtAuthInterceptor,
    private val searchUserInterceptor: SearchUserInterceptor
) : WebMvcConfigurer {
    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(commonLogInterceptor)
            .addPathPatterns("/api/v1/**")
        registry.addInterceptor(threadLocalInterceptor)
            .addPathPatterns("/api/v1/**")
        registry.addInterceptor(jwtAuthInterceptor)
            .addPathPatterns("/api/v1/**")
        registry.addInterceptor(searchUserInterceptor)
            .addPathPatterns("/api/v1/**")
            .excludePathPatterns("/api/v1/user/**")
    }
}
