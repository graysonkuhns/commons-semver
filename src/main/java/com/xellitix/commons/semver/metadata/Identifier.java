package com.xellitix.commons.semver.metadata;

import java.io.Serializable;

/**
 * Metadata identifier.
 *
 * @author Grayson Kuhns
 */
public interface Identifier extends Serializable, Comparable<Identifier> {

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
