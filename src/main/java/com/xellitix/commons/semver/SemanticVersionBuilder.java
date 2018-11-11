package com.xellitix.commons.semver;

import com.xellitix.commons.semver.metadata.Identifier;
import com.xellitix.commons.semver.metadata.Metadata;

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
  SemanticVersionBuilder setMajorVersion(int major);

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
  SemanticVersionBuilder setMinorVersion(int minor);

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
  SemanticVersionBuilder setPatchVersion(int patch);

  /**
   * Gets the patch version.
   *
   * @return The patch version.
   */
  int getPatchVersion();

  /**
   * Adds a pre-release {@link Metadata} {@link Identifier}.
   *
   * @param identifier The {@link Identifier}.
   * @return The {@link SemanticVersionBuilder}.
   */
  SemanticVersionBuilder addPreReleaseMetadataIdentifier(Identifier identifier);

  /**
   * Adds a pre-release {@link Metadata} {@link Identifier}.
   *
   * @param identifier The {@link Identifier}.
   * @return The {@link SemanticVersionBuilder}.
   */
  SemanticVersionBuilder addPreReleaseMetadataIdentifier(String identifier);

  /**
   * Clears the pre-release {@link Metadata}.
   *
   * @return The {@link SemanticVersionBuilder}.
   */
  SemanticVersionBuilder clearPreReleaseMetadata();

  /**
   * Adds a build {@link Metadata} {@link Identifier}.
   *
   * @param identifier The {@link Identifier}.
   * @return The {@link SemanticVersionBuilder}.
   */
  SemanticVersionBuilder addBuildMetadataIdentifier(Identifier identifier);

  /**
   * Adds a build {@link Metadata} {@link Identifier}.
   *
   * @param identifier The {@link Identifier}.
   * @return The {@link SemanticVersionBuilder}.
   */
  SemanticVersionBuilder addBuildMetadataIdentifier(String identifier);

  /**
   * Clears the build {@link Metadata}.
   *
   * @return The {@link SemanticVersionBuilder}.
   */
  SemanticVersionBuilder clearBuildMetadata();

  /**
   * Builds a {@link SemanticVersion}.
   *
   * @return The {@link SemanticVersion}.
   */
  SemanticVersion build();
}
