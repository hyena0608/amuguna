package com.hyena.selffinance.domain

import com.hyena.selffinance.domain.common.BaseEntity
import jakarta.persistence.ElementCollection
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.Table

/**
 * @Description
 * @Owner hyunseo
 * @Date 6/29/24
 */
@Entity
@Table(name = "expenditure_item")
data class ExpenditureItem(
    var title: String,

    @ElementCollection(fetch = FetchType.LAZY)
    val categoryIds: List<Long> = emptyList(),
) : BaseEntity()
