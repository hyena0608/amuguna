package com.hyena.selffinance.domain.repository

import com.hyena.selffinance.domain.ExpenditureItemUserCustom
import org.springframework.data.jpa.repository.JpaRepository

/**
 * @Description
 * @Owner hyunseo
 * @Date 6/29/24
 */
interface ExpenditureItemUserCustomRepository : JpaRepository<ExpenditureItemUserCustom, Long> {
    fun findAllByUserId(userId: Long): List<ExpenditureItemUserCustom>
}
