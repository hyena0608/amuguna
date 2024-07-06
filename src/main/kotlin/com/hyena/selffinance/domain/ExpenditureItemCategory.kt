package com.hyena.selffinance.domain

import com.hyena.selffinance.domain.common.BaseEntity
import jakarta.persistence.Entity
import jakarta.persistence.Table

/**
 * @Description
 * @Owner hyunseo
 * @Date 6/29/24
 */
@Entity
@Table(name = "expenditure_item_category")
data class ExpenditureItemCategory(
    var title: String,
) : BaseEntity()
