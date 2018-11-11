package com.xellitix.commons.semver.metadata;

/**
 * {@link Identifier} factory.
 *
 * @author Grayson Kuhns
 */
public interface IdentifierFactory {

  /**
   * Creates an {@link Identifier}.
   *
   * @param value The value.
   * @return The {@link Identifier}.
   */
  Identifier create(String value);
}
