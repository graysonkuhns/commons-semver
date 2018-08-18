package com.xellitix.commons.semver.metadata;

/**
 * {@link Identifier} validator.
 *
 * @author Grayson Kuhns
 */
public interface IdentifierValidator {

  /**
   * Checks if an {@link Identifier} is valid.
   *
   * @param identifier The {@link Identifier}.
   * @return True if the {@link Identifier} is valid.
   */
  boolean isValid(Identifier identifier);
}
