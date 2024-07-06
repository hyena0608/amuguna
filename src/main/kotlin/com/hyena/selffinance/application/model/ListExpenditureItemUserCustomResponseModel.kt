package com.hyena.selffinance.application.model

/**
 * @Description
 * @Owner hyunseo
 * @Date 6/30/24
 */
data class ListExpenditureItemUserCustomResponseModel(
    val models: List<ListExpenditureItemUserCustomModel>,
) {
    data class ListExpenditureItemUserCustomModel(
        val id: Long,
        val title: String,
        val amount: String,
        val description: String?,
        val categories: List<ListExpenditureItemCategoryModel>,
    )

    data class ListExpenditureItemCategoryModel(
        val id: Long,
        val title: String,
    )
}
