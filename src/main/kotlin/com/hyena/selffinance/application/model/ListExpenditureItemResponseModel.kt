package com.hyena.selffinance.application.model

/**
 * @Description
 * @Owner hyunseo
 * @Date 6/29/24
 */
data class ListExpenditureItemResponseModel(
    val models: List<ListExpenditureItemModel>,
) {
    data class ListExpenditureItemModel(
        val id: Long,
        val title: String,
    )
}
