package com.hyena.selffinance.domain

import com.hyena.selffinance.domain.common.Amount
import com.hyena.selffinance.domain.common.BaseEntity
import jakarta.persistence.*

/**
 * @Description 사용자 지출 아이템 커스텀
 * @Owner hyunseo
 * @Date 6/29/24
 */
@Entity
@Table(name = "expenditure_item_custom")
data class ExpenditureItemUserCustom(
    @OneToOne(cascade = [CascadeType.MERGE], fetch = FetchType.LAZY)
    val expenditureItem: ExpenditureItem,
    val userId: Long,
    var amount: Amount,
    var description: String?,
) : BaseEntity() {
    fun getCategoryIds(): List<Long> {
        return expenditureItem.categoryIds.toList()
    }
}
