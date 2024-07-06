package com.hyena.selffinance.domain.outbound

import com.hyena.selffinance.domain.User

/**
 * @Description
 * @Owner hyunseo
 * @Date 7/6/24
 */
interface OauthOutbound {
    fun join(user: User): User
    fun login(user: User): User
    fun logout(user: User)
}
