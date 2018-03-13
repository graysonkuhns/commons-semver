package com.xellitix.commons.semver;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;

/**
 * Default {@link SemanticVersion} implementation.
 *
 * @author Grayson Kuhns
 */
public class DefaultSemanticVersion implements SemanticVersion {

  // Properties
  private final int major;
  private final int minor;
  private final int patch;

  /**
   * Constructor.
   *
   * @param major The major version.
   * @param minor The minor version.
   * @param patch The patch version;
   */
  @Inject
  DefaultSemanticVersion(
      @Assisted("major") final int major,
      @Assisted("minor") final int minor,
      @Assisted("patch") final int patch) {

    this.major = major;
    this.minor = minor;
    this.patch = patch;
  }

  /**
   * Gets the major version.
   *
   * @return The major version.
   */
  @Override
  public int getMajorVersion() {
    return major;
  }

  /**
   * Gets the minor version.
   *
   * @return The minor version.
   */
  @Override
  public int getMinorVersion() {
    return minor;
  }

  /**
   * Gets the patch version.
   *
   * @return The patch version.
   */
  @Override
  public int getPatchVersion() {
    return patch;
  }

  /**
   * Gets the string representation.
   *
   * @return The string representation.
   */
  @Override
  public String toString() {
    return String.format("%d.%d.%d", major, minor, patch);
  }
}
