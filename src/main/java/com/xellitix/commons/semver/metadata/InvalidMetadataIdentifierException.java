package com.xellitix.commons.semver.metadata;

/**
 * Invalid {@link Metadata} {@link Identifier} exception.
 *
 * @author Grayson Kuhns
 */
public class InvalidMetadataIdentifierException extends IllegalArgumentException {

  // Constants
  private static final String MSG_TEMPLATE = "Invalid metadata identifier: %s";

  // Properties
  private final Identifier identifier;

  /**
   * Constructor.
   *
   * @param identifier The invalid identifier.
   */
  public InvalidMetadataIdentifierException(final Identifier identifier) {
    super(String.format(MSG_TEMPLATE, identifier.getValue()));
    this.identifier = identifier;
  }

  /**
   * Gets the invalid identifier.
   *
   * @return The invalid identifier.
   */
  public Identifier getInvalidIdentifier() {
    return identifier;
  }
}
