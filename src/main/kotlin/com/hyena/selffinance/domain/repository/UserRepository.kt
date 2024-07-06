package com.hyena.selffinance.domain.repository

import com.hyena.selffinance.domain.User
import org.springframework.data.jpa.repository.JpaRepository

/**
 * @Description
 * @Owner hyunseo
 * @Date 6/29/24
 */
interface UserRepository : JpaRepository<User, Long>
