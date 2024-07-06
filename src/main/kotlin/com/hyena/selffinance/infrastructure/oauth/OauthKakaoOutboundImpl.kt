package com.hyena.selffinance.infrastructure.oauth

import com.hyena.selffinance.domain.User
import com.hyena.selffinance.domain.outbound.OauthOutbound
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Repository

/**
 * @Description
 * @Owner hyunseo
 * @Date 7/6/24
 */
@Repository
class OauthKakaoOutboundImpl(
    @Value("oauth.kakao.clientCode")
    private val clientCode: String,
    @Value("oauth.kakao.secretKey")
    private val secretKey: String,
    @Value("oauth.kakao.returnUrl")
    private val returnUrl: String,
    private val oauthKakaoHttpClient: OauthKakaoHttpClient
) : OauthOutbound {
    override fun join(user: User): User {
        TODO("Not yet implemented")
    }

    override fun login(user: User): User {
        TODO("Not yet implemented")
    }

    override fun logout(user: User) {
        TODO("Not yet implemented")
    }
}
