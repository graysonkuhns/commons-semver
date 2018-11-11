package com.xellitix.commons.semver.metadata;

import com.google.inject.Singleton;

/**
 * {@link IdentifierValidator} that validates that digits do not have leading zeroes.
 *
 * <p>
 *   Semantic versioning rule:
 *   Numeric identifiers MUST NOT include leading zeroes.
 * </p>
 *
 * @author Grayson Kuhns
 */
@Singleton
public class NoLeadingZeroesOnDigitsIdentifierValidator implements IdentifierValidator {

  /**
   * Checks if an {@link Identifier} is valid.
   *
   * @param identifier The {@link Identifier}.
   * @return True if the {@link Identifier} is valid.
   */
  @Override
  public boolean isValid(final Identifier identifier) {

    // This rule only applies to numeric identifiers
    if (!identifier.isNumeric()) {
      return true;
    }

    // Get the identifier value
    final String value = identifier.getValue();

    // If the first character is not a zero then the identifier is valid
    if (value.charAt(0) != '0') {
      return true;
    }

    // At this point we know that the first character is a zero
    // If the identifier value is longer than 1 character then we know
    // that the identifier value violates the rule.
    return value.length() <= 1;
  }
}
