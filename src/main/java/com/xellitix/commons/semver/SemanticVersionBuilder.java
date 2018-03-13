package com.xellitix.commons.semver;

/**
 * {@link SemanticVersion} builder.
 *
 * @author Grayson Kuhns
 */
public interface SemanticVersionBuilder {

  /**
   * Sets the major version.
   *
   * @param major The major version.
   * @return The {@link SemanticVersionBuilder}.
   */
  SemanticVersionBuilder withMajorVersion(int major);

  /**
   * Gets the major version.
   *
   * @return The major version.
   */
  int getMajorVersion();

  /**
   * Sets the minor version.
   *
   * @param minor The minor version.
   * @return The {@link SemanticVersionBuilder}.
   */
  SemanticVersionBuilder withMinorVersion(int minor);

  /**
   * Gets the minor version.
   *
   * @return The minor version.
   */
  int getMinorVersion();

  /**
   * Sets the patch version.
   *
   * @param patch The patch version.
   * @return The {@link SemanticVersionBuilder}.
   */
  SemanticVersionBuilder withPatchVersion(int patch);

  /**
   * Gets the patch version.
   *
   * @return The patch version.
   */
  int getPatchVersion();

  /**
   * Builds a {@link SemanticVersion}.
   *
   * @return The {@link SemanticVersion}.
   */
  SemanticVersion build();
}
