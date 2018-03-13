package com.xellitix.commons.semver;

import com.google.inject.Inject;

/**
 * Default {@link SemanticVersionBuilder} implementation.
 *
 * @author Grayson Kuhns
 */
public class DefaultSemanticVersionBuilder implements SemanticVersionBuilder {

  // Properties
  private int major;
  private int minor;
  private int patch;

  // Dependencies
  private final SemanticVersionFactory versionFactory;

  /**
   * Constructor.
   *
   * @param versionFactory The {@link SemanticVersionFactory}.
   */
  @Inject
  DefaultSemanticVersionBuilder(final SemanticVersionFactory versionFactory) {
    this.versionFactory = versionFactory;

    major = 0;
    minor = 0;
    patch = 0;
  }

  /**
   * Sets the major version.
   *
   * @param major The major version.
   * @return The {@link SemanticVersionBuilder}.
   */
  @Override
  public DefaultSemanticVersionBuilder withMajorVersion(int major) {
    this.major = major;
    return this;
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
   * Sets the minor version.
   *
   * @param minor The minor version.
   * @return The {@link SemanticVersionBuilder}.
   */
  @Override
  public DefaultSemanticVersionBuilder withMinorVersion(int minor) {
    this.minor = minor;
    return this;
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
   * Sets the patch version.
   *
   * @param patch The patch version.
   * @return The {@link SemanticVersionBuilder}.
   */
  @Override
  public DefaultSemanticVersionBuilder withPatchVersion(int patch) {
    this.patch = patch;
    return this;
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
   * Builds a {@link SemanticVersion}.
   *
   * @return The {@link SemanticVersion}.
   */
  @Override
  public SemanticVersion build() {
    return versionFactory.create(major, minor, patch);
  }
}
