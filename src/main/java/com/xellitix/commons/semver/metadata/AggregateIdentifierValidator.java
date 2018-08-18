package com.xellitix.commons.semver.metadata;

import java.util.Set;

/**
 * Aggregate {@link IdentifierValidator}.
 *
 * @author Grayson Kuhns
 */
public class AggregateIdentifierValidator implements IdentifierValidator {

  // Properties
  private final Set<IdentifierValidator> validators;

  /**
   * Constructor.
   *
   * @param validators The {@link IdentifierValidator}s to aggregate.
   */
  public AggregateIdentifierValidator(final Set<IdentifierValidator> validators) {
    this.validators = validators;
  }

  /**
   * Checks if an {@link Identifier} is valid.
   *
   * @param identifier The {@link Identifier}.
   * @return True if the {@link Identifier} is valid.
   */
  @Override
  public boolean isValid(final Identifier identifier) {
    // Check for violations
    for (final IdentifierValidator validator : validators) {
      if (!validator.isValid(identifier)) {
        return false;
      }
    }

    // The identifier is valid because no aggregated validators indicated otherwise
    return true;
  }
}
