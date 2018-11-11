package com.xellitix.commons.semver.metadata;

/**
 * Simple {@link MetadataValidator} implementation.
 *
 * @author Grayson Kuhns
 */
public class SimpleMetadataValidator implements MetadataValidator {

  // Dependencies
  private final IdentifierValidator identifierValidator;

  /**
   * Constructor.
   *
   * @param identifierValidator The {@link IdentifierValidator}.
   */
  public SimpleMetadataValidator(final IdentifierValidator identifierValidator) {
    this.identifierValidator = identifierValidator;
  }

  /**
   * Checks if {@link Metadata} is valid.
   *
   * @param metadata The {@link Metadata}.
   * @return True if the {@link Metadata} is valid.
   */
  @Override
  public boolean isValid(final Metadata metadata) {
    // Check for invalid identifiers
    for (final Identifier id : metadata) {
      if (!identifierValidator.isValid(id)) {
        return false;
      }
    }

    // All identifiers are valid
    return true;
  }
}
