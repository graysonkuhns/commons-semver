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

  /**
   * Creates an {@link Identifier}.
   *
   * @param value The value.
   * @return The {@link Identifier}.
   */
  Identifier create(Integer value);

  /**
   * Creates an {@link Identifier}.
   *
   * @param value The value.
   * @return The {@link Identifier}.
   */
  Identifier create(Long value);
}
