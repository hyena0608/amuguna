package com.hyena.selffinance.domain

/**
 * @Description
 * @Owner hyunseo
 * @Date 7/6/24
 */
data class Token(
    val userId: Long,
) {
    var encodedToken: String? = null
}
