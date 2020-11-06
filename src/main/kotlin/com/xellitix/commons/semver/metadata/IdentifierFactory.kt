package com.xellitix.commons.semver.metadata

import com.google.inject.Singleton

/**
 * [Identifier] factory.
 */
@Singleton
class IdentifierFactory {

    /**
     * Creates an [Identifier].
     */
    fun create(value: String): Identifier {
        return Identifier(value)
    }

    /**
     * Creates an [Identifier].
     */
    fun create(value: Int): Identifier {
        return Identifier(value)
    }

    /**
     * Creates an [Identifier].
     */
    fun create(value: Long): Identifier {
        return Identifier(value)
    }
}
