package com.hyena.selffinance.application.model

/**
 * @Description
 * @Owner hyunseo
 * @Date 6/29/24
 */
data class CreateExpenditureItemRequestModel(
    val title: String,
    val categoryIds: List<Long>,
)
