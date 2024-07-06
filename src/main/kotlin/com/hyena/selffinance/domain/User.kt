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
@Table(name = "users")
class User : BaseEntity() {
    var name: String? = null
    var imageUrl: String? = null
    var email: String? = null
}
