package com.xellitix.commons.semver.metadata;

import com.google.common.collect.ImmutableSet;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * Pre-release {@link Metadata} {@link Identifier} validator.
 *
 * <p>
 *   Build metadata rules:
 *   - Identifiers MUST comprise only ASCII alphanumerics and hyphen [0-9A-Za-z-].
 *   - Identifiers MUST NOT be empty.
 *   - Numeric identifiers MUST NOT include leading zeroes.
 * </p>
 *
 * @author Grayson Kuhns
 */
@Singleton
public class PreReleaseMetadataIdentifierValidator
    extends AggregateIdentifierValidator
    implements IdentifierValidator {

  /**
   * Constructor.
   *
   * @param alphaNumHyphenIdentifierValidator The {@link AlphaNumHyphenIdentifierValidator}.
   * @param nonEmptyIdentifierValidator The {@link NonEmptyIdentifierValidator}.
   * @param noLeadingZeroesValidator The {@link NoLeadingZeroesOnDigitsIdentifierValidator}.
   */
  @Inject
  public PreReleaseMetadataIdentifierValidator(
      final AlphaNumHyphenIdentifierValidator alphaNumHyphenIdentifierValidator,
      final NonEmptyIdentifierValidator nonEmptyIdentifierValidator,
      final NoLeadingZeroesOnDigitsIdentifierValidator noLeadingZeroesValidator
  ) {
    super(ImmutableSet.of(
        alphaNumHyphenIdentifierValidator,
        nonEmptyIdentifierValidator,
        noLeadingZeroesValidator
    ));
  }
}
