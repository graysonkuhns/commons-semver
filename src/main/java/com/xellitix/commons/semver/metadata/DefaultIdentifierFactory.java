package com.xellitix.commons.semver.metadata;

/**
 * Default {@link IdentifierFactory} implementation.
 *
 * @author Grayson Kuhns
 */
public class DefaultIdentifierFactory implements IdentifierFactory {

  // Messages
  private static final String NULL_MSG = "Expected value to be non-null";

  /**
   * Creates an {@link Identifier}.
   *
   * @param value The value.
   * @return The {@link Identifier}.
   */
  @Override
  public Identifier create(final String value) {
    if (value == null) {
      throw new IllegalArgumentException(NULL_MSG);
    }

    return new DefaultIdentifier(value);
  }

  /**
   * Creates an {@link Identifier}.
   *
   * @param value The value.
   * @return The {@link Identifier}.
   */
  @Override
  public Identifier create(final Integer value) {
    if (value == null) {
      throw new IllegalArgumentException(NULL_MSG);
    }

    return new DefaultIdentifier(value);
  }

  /**
   * Creates an {@link Identifier}.
   *
   * @param value The value.
   * @return The {@link Identifier}.
   */
  @Override
  public Identifier create(final Long value) {
    if (value == null) {
      throw new IllegalArgumentException(NULL_MSG);
    }

    return new DefaultIdentifier(value);
  }
}
