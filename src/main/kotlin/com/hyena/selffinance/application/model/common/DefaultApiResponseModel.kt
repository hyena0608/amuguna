package com.hyena.selffinance.application.model.common

/**
 * @Description
 * @Owner hyunseo
 * @Date 6/29/24
 */
data class DefaultApiResponseModel<T>(
    val success: Boolean? = null,
    val response: T? = null,
    val errorCode: String? = null,
    val message: String? = null,
)
