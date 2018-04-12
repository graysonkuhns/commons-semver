package com.xellitix.commons.semver;

/**
 * Invalid semantic version exception.
 *
 * @author Grayson Kuhns
 */
public class InvalidSemanticVersionException extends IllegalArgumentException {

  // Message templates
  private static final String MSG_TEMPLATE = "Invalid version: %s";

  // Properties
  private final String invalidVersion;

  /**
   * Constructor.
   *
   * @param invalidVersion The invalid version.
   */
  public InvalidSemanticVersionException(final String invalidVersion) {
    // Prepare message
    super(String.format(MSG_TEMPLATE, invalidVersion));

    // Set properties
    this.invalidVersion = invalidVersion;
  }

  /**
   * Gets the invalid version.
   *
   * @return The invalid version.
   */
  public String getInvalidVersion() {
    return invalidVersion;
  }
}
