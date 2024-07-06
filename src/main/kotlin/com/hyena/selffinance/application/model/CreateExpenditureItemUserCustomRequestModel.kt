package com.hyena.selffinance.application.model

/**
 * @Description
 * @Owner hyunseo
 * @Date 6/30/24
 */
data class CreateExpenditureItemUserCustomRequestModel(
    val expenditureItemId: Long,
    val amount: String,
    val description: String? = null,
)
