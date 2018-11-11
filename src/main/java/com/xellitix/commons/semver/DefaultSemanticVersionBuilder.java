package com.xellitix.commons.semver;

import com.google.inject.Inject;
import com.xellitix.commons.semver.metadata.BuildMetadataIdentifierValidator;
import com.xellitix.commons.semver.metadata.Identifier;
import com.xellitix.commons.semver.metadata.IdentifierFactory;
import com.xellitix.commons.semver.metadata.InvalidMetadataIdentifierException;
import com.xellitix.commons.semver.metadata.Metadata;
import com.xellitix.commons.semver.metadata.MetadataFactory;
import com.xellitix.commons.semver.metadata.PreReleaseMetadataIdentifierValidator;
import java.util.ArrayList;
import java.util.List;

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
  private final List<Identifier> preReleaseIdentifiers;
  private final List<Identifier> buildIdentifiers;

  // Dependencies
  private final SemanticVersionFactory versionFactory;
  private final MetadataFactory metadataFactory;
  private final PreReleaseMetadataIdentifierValidator preReleaseIdentifierValidator;
  private final BuildMetadataIdentifierValidator buildIdentifierValidator;
  private final IdentifierFactory identifierFactory;

  /**
   * Constructor.
   *
   * @param versionFactory The {@link SemanticVersionFactory}.
   * @param metadataFactory The {@link MetadataFactory}.
   * @param preReleaseIdentifierValidator The {@link PreReleaseMetadataIdentifierValidator}.
   * @param buildIdentifierValidator The {@link BuildMetadataIdentifierValidator}.
   * @param identifierFactory The {@link IdentifierFactory}.
   */
  @Inject
  DefaultSemanticVersionBuilder(
      final SemanticVersionFactory versionFactory,
      final MetadataFactory metadataFactory,
      final PreReleaseMetadataIdentifierValidator preReleaseIdentifierValidator,
      final BuildMetadataIdentifierValidator buildIdentifierValidator,
      final IdentifierFactory identifierFactory) {

    // Load dependencies
    this.versionFactory = versionFactory;
    this.metadataFactory = metadataFactory;
    this.preReleaseIdentifierValidator = preReleaseIdentifierValidator;
    this.buildIdentifierValidator = buildIdentifierValidator;
    this.identifierFactory = identifierFactory;

    // Initial the version
    major = 0;
    minor = 0;
    patch = 0;
    preReleaseIdentifiers = new ArrayList<>();
    buildIdentifiers = new ArrayList<>();
  }

  /**
   * Sets the major version.
   *
   * @param major The major version.
   * @return The {@link SemanticVersionBuilder}.
   */
  @Override
  public DefaultSemanticVersionBuilder setMajorVersion(int major) {
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
  public DefaultSemanticVersionBuilder setMinorVersion(int minor) {
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
  public DefaultSemanticVersionBuilder setPatchVersion(int patch) {
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
   * Adds a pre-release {@link Metadata} {@link Identifier}.
   *
   * @param identifier The {@link Identifier}.
   * @return The {@link SemanticVersionBuilder}.
   * @throws InvalidMetadataIdentifierException If the {@link Identifier} is invalid.
   */
  @Override
  public SemanticVersionBuilder addPreReleaseMetadataIdentifier(
      final Identifier identifier)
      throws InvalidMetadataIdentifierException {

    if (!preReleaseIdentifierValidator.isValid(identifier)) {
      throw new InvalidMetadataIdentifierException(identifier);
    }

    preReleaseIdentifiers.add(identifier);
    return this;
  }

  /**
   * Adds a pre-release {@link Metadata} {@link Identifier}.
   *
   * @param identifier The {@link Identifier}.
   * @return The {@link SemanticVersionBuilder}.
   * @throws InvalidMetadataIdentifierException If the {@link Identifier} is invalid.
   */
  @Override
  public SemanticVersionBuilder addPreReleaseMetadataIdentifier(
      final String identifier)
      throws InvalidMetadataIdentifierException {

    return addPreReleaseMetadataIdentifier(identifierFactory.create(identifier));
  }

  /**
   * Clears the pre-release {@link Metadata}.
   *
   * @return The {@link SemanticVersionBuilder}.
   */
  @Override
  public SemanticVersionBuilder clearPreReleaseMetadata() {
    preReleaseIdentifiers.clear();
    return this;
  }

  /**
   * Adds a build {@link Metadata} {@link Identifier}.
   *
   * @param identifier The {@link Identifier}.
   * @return The {@link SemanticVersionBuilder}.
   * @throws InvalidMetadataIdentifierException If the {@link Identifier} is invalid.
   */
  @Override
  public SemanticVersionBuilder addBuildMetadataIdentifier(
      final Identifier identifier)
      throws InvalidMetadataIdentifierException {

    if (!buildIdentifierValidator.isValid(identifier)) {
      throw new InvalidMetadataIdentifierException(identifier);
    }

    buildIdentifiers.add(identifier);
    return this;
  }

  /**
   * Adds a build {@link Metadata} {@link Identifier}.
   *
   * @param identifier The {@link Identifier}.
   * @return The {@link SemanticVersionBuilder}.
   * @throws InvalidMetadataIdentifierException If the {@link Identifier} is invalid.
   */
  @Override
  public SemanticVersionBuilder addBuildMetadataIdentifier(
      final String identifier)
      throws InvalidMetadataIdentifierException {

    return addBuildMetadataIdentifier(identifierFactory.create(identifier));
  }

  /**
   * Clears the build {@link Metadata}.
   *
   * @return The {@link SemanticVersionBuilder}.
   */
  @Override
  public SemanticVersionBuilder clearBuildMetadata() {
    buildIdentifiers.clear();
    return this;
  }

  /**
   * Builds a {@link SemanticVersion}.
   *
   * @return The {@link SemanticVersion}.
   */
  @Override
  public SemanticVersion build() {
    return versionFactory.create(
        major,
        minor,
        patch,
        preReleaseIdentifiers.isEmpty() ? null : metadataFactory.create(preReleaseIdentifiers),
        buildIdentifiers.isEmpty() ? null : metadataFactory.create(buildIdentifiers));
  }
}
