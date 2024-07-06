package com.hyena.selffinance.application

import com.hyena.selffinance.application.model.LoginUserResponseModel
import com.hyena.selffinance.domain.User
import com.hyena.selffinance.domain.outbound.OauthOutbound
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * @Description
 * @Owner hyunseo
 * @Date 7/6/24
 */
@Service
@Transactional(readOnly = true)
class LoginUserService(
    @Value("jwt.secretKey")
    private val secretKey: String,
    @Value("jwt.expireTimeMillis")
    private val expireTimeMillis: Long,
    private val oauthKakaoLoginOutboundImpl: OauthOutbound,
) {
    fun login(): LoginUserResponseModel {
        val user = oauthKakaoLoginOutboundImpl.login(User())
        return LoginUserResponseModel(TODO("토큰을 만들어주세요"))
    }

    private fun createToken(): String {
        TODO()
    }

    private fun renewToken(): String {
        TODO()
    }
}
