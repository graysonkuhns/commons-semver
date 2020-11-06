package com.xellitix.commons.semver.metadata

import java.io.Serializable
import java.math.BigInteger

/**
 * Metadata identifier.
 */
data class Identifier(val value: String, val isNumeric: Boolean) : Serializable, Comparable<Identifier> {

    constructor(value: Int) : this(value.toString(), true)
    constructor(value: Long) : this(value.toString(), true)
    constructor(value: String) : this(
        value,
        value
            .toCharArray()
            .filter { it.isDigit() }
            .size == value.length
    )

    override fun compareTo(other: Identifier): Int {
        /*
        negative int = this < other
        0 = this == other
        positive int = this > other

        identifiers consisting of only digits are compared numerically and identifiers
        with letters or hyphens are compared lexically in ASCII sort order.
        Numeric identifiers always have lower precedence than non-numeric identifiers.
        */

        // Cover case of type inequality and numeric comparison
        if (isNumeric) {
            return if (other.isNumeric) {
                // Possibly equal
                // It might be a big value
                val me = BigInteger(value)
                val otr = BigInteger(other.value)

                // Check for equality
                me.compareTo(otr)
            } else {
                // Less than
                -1
            }
        } else if (other.isNumeric) {
            // Greater than
            return 1
        }

        // At this point we know that both identifiers are non-numeric
        // Perform lexicographical comparison
        return value.compareTo(other.value)
    }

    override fun toString(): String {
        return value
    }
}
