package com.xellitix.commons.semver;

import com.xellitix.commons.semver.metadata.Identifier;
import com.xellitix.commons.semver.metadata.InvalidMetadataIdentifierException;
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

  // --------------------------------------------------------------------------------------
  // Pre-release metadata functionality
  // --------------------------------------------------------------------------------------

  /**
   * Adds a pre-release {@link Metadata} {@link Identifier}.
   *
   * @param identifier The {@link Identifier}.
   * @return The {@link SemanticVersionBuilder}.
   * @throws InvalidMetadataIdentifierException If the {@link Identifier} is invalid.
   */
  SemanticVersionBuilder addPreReleaseMetadataIdentifier(Identifier identifier) throws InvalidMetadataIdentifierException;

  /**
   * Adds a pre-release {@link Metadata} {@link Identifier}.
   *
   * @param identifier The {@link Identifier}.
   * @return The {@link SemanticVersionBuilder}.
   * @throws InvalidMetadataIdentifierException If the {@link Identifier} is invalid.
   */
  SemanticVersionBuilder addPreReleaseMetadataIdentifier(String identifier) throws InvalidMetadataIdentifierException;

  /**
   * Adds a pre-release {@link Metadata} {@link Identifier}.
   *
   * @param identifier The {@link Identifier}.
   * @return The {@link SemanticVersionBuilder}.
   * @throws InvalidMetadataIdentifierException If the {@link Identifier} is invalid.
   */
  SemanticVersionBuilder addPreReleaseMetadataIdentifier(Integer identifier) throws InvalidMetadataIdentifierException;

  /**
   * Adds a pre-release {@link Metadata} {@link Identifier}.
   *
   * @param identifier The {@link Identifier}.
   * @return The {@link SemanticVersionBuilder}.
   * @throws InvalidMetadataIdentifierException If the {@link Identifier} is invalid.
   */
  SemanticVersionBuilder addPreReleaseMetadataIdentifier(Long identifier) throws InvalidMetadataIdentifierException;

  /**
   * Clears the pre-release {@link Metadata}.
   *
   * @return The {@link SemanticVersionBuilder}.
   */
  SemanticVersionBuilder clearPreReleaseMetadata();

  // --------------------------------------------------------------------------------------
  // Build metadata functionality
  // --------------------------------------------------------------------------------------

  /**
   * Adds a build {@link Metadata} {@link Identifier}.
   *
   * @param identifier The {@link Identifier}.
   * @return The {@link SemanticVersionBuilder}.
   * @throws InvalidMetadataIdentifierException If the {@link Identifier} is invalid.
   */
  SemanticVersionBuilder addBuildMetadataIdentifier(Identifier identifier) throws InvalidMetadataIdentifierException;

  /**
   * Adds a build {@link Metadata} {@link Identifier}.
   *
   * @param identifier The {@link Identifier}.
   * @return The {@link SemanticVersionBuilder}.
   * @throws InvalidMetadataIdentifierException If the {@link Identifier} is invalid.
   */
  SemanticVersionBuilder addBuildMetadataIdentifier(String identifier) throws InvalidMetadataIdentifierException;

  /**
   * Adds a build {@link Metadata} {@link Identifier}.
   *
   * @param identifier The {@link Identifier}.
   * @return The {@link SemanticVersionBuilder}.
   * @throws InvalidMetadataIdentifierException If the {@link Identifier} is invalid.
   */
  SemanticVersionBuilder addBuildMetadataIdentifier(Integer identifier) throws InvalidMetadataIdentifierException;

  /**
   * Adds a build {@link Metadata} {@link Identifier}.
   *
   * @param identifier The {@link Identifier}.
   * @return The {@link SemanticVersionBuilder}.
   * @throws InvalidMetadataIdentifierException If the {@link Identifier} is invalid.
   */
  SemanticVersionBuilder addBuildMetadataIdentifier(Long identifier) throws InvalidMetadataIdentifierException;

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
