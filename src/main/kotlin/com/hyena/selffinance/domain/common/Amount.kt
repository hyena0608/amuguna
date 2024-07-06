package com.hyena.selffinance.domain.common

import jakarta.persistence.Embeddable
import java.math.BigDecimal
import java.math.BigInteger
import java.math.RoundingMode.HALF_DOWN

/**
 * @Description
 * @Owner hyunseo
 * @Date 6/29/24
 */
@Embeddable
data class Amount(
    private val value: BigDecimal,
) {
    constructor(value: BigInteger) : this(BigDecimal(value))

    constructor(value: String) : this(BigDecimal(value))

    constructor(value: Int) : this(BigDecimal(value))

    constructor(value: Long) : this(BigDecimal(value))

    constructor(value: Double) : this(BigDecimal(value))

    constructor(value: CharArray) : this(BigDecimal(value))

    fun plus(other: Amount) = Amount(other.value.plus(this.value))

    fun minus(other: Amount) = Amount(other.value.minus(this.value))

    fun times(other: Amount) = Amount(other.value.times(this.value))

    fun divide(other: Amount) = Amount(other.value.divide(this.value, 5, HALF_DOWN))
}
