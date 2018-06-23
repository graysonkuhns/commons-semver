package com.xellitix.commons.semver.metadata;

/**
 * Metadata identifier.
 *
 * @author Grayson Kuhns
 */
public interface Identifier extends Comparable<Identifier> {

  /**
   * Gets the value.
   *
   * @return The value.
   */
  String getValue();

  /**
   * Checks if the {@link Identifier} is numeric.
   *
   * @return True if the {@link Identifier} is numeric.
   */
  boolean isNumeric();
}
