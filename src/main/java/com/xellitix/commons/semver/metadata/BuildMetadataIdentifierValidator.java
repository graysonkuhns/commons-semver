package com.xellitix.commons.semver.metadata;

import com.google.common.collect.ImmutableSet;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * Build {@link Metadata} {@link Identifier} validator.
 *
 * <p>
 *   Build metadata rules:
 *   - Identifiers MUST comprise only ASCII alphanumerics and hyphen [0-9A-Za-z-].
 *   - Identifiers MUST NOT be empty.
 * </p>
 *
 * @author Grayson Kuhns
 */
@Singleton
public class BuildMetadataIdentifierValidator
    extends AggregateIdentifierValidator
    implements IdentifierValidator {

  /**
   * Constructor.
   *
   * @param alphaNumHyphenIdentifierValidator The {@link AlphaNumHyphenIdentifierValidator}.
   * @param nonEmptyIdentifierValidator The {@link NonEmptyIdentifierValidator}.
   */
  @Inject
  public BuildMetadataIdentifierValidator(
      final AlphaNumHyphenIdentifierValidator alphaNumHyphenIdentifierValidator,
      final NonEmptyIdentifierValidator nonEmptyIdentifierValidator) {

    super(ImmutableSet.of(
        alphaNumHyphenIdentifierValidator,
        nonEmptyIdentifierValidator
    ));
  }
}
