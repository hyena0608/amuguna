package com.hyena.selffinance.domain.repository

import com.hyena.selffinance.domain.ExpenditureItem
import org.springframework.data.jpa.repository.JpaRepository

/**
 * @Description
 * @Owner hyunseo
 * @Date 6/29/24
 */
interface ExpenditureItemRepository : JpaRepository<ExpenditureItem, Long> {
    fun existsByTitle(title: String): Boolean
}
