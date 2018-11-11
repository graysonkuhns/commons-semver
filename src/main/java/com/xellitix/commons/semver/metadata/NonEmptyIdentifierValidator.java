package com.xellitix.commons.semver.metadata;

import com.google.inject.Singleton;

/**
 * {@link IdentifierValidator} that validates that the {@link Identifier} value is non-empty.
 *
 * <p>
 *   Semantic versioning rule:
 *   Identifiers MUST NOT be empty.
 * </p>
 *
 * @author Grayson Kuhns
 */
@Singleton
public class NonEmptyIdentifierValidator implements IdentifierValidator {

  /**
   * Checks if an {@link Identifier} is valid.
   *
   * @param identifier The {@link Identifier}.
   * @return True if the {@link Identifier} is valid.
   */
  @Override
  public boolean isValid(final Identifier identifier) {
    return !identifier.getValue().isEmpty();
  }
}
