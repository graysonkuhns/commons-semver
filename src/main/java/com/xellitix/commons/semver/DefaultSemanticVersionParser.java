package com.xellitix.commons.semver;

import com.google.inject.Inject;
import com.xellitix.commons.semver.metadata.BuildMetadataIdentifierValidator;
import com.xellitix.commons.semver.metadata.BuildMetadataValidator;
import com.xellitix.commons.semver.metadata.Metadata;
import com.xellitix.commons.semver.metadata.MetadataFactory;
import com.xellitix.commons.semver.metadata.MetadataParser;
import com.xellitix.commons.semver.metadata.PreReleaseMetadataIdentifierValidator;
import com.xellitix.commons.semver.metadata.PreReleaseMetadataValidator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Default {@link SemanticVersionParser} implementation.
 *
 * @author Grayson Kuhns
 */
public class DefaultSemanticVersionParser implements SemanticVersionParser {

  // Constants
  private static final String VERSION_REGEX = "^(\\d+)\\.(\\d+)\\.(\\d+)-?([^\\n\\+]*)?\\+?(.*)?.*$";

  // Properties
  private final Pattern versionPattern;

  // Dependencies
  private final SemanticVersionFactory versionFactory;
  private final MetadataParser metadataParser;
  private final PreReleaseMetadataValidator preReleaseMetadataValidator;
  private final BuildMetadataValidator buildMetadataValidator;

  /**
   * Constructor.
   *
   * @param versionFactory The {@link SemanticVersionFactory}
   * @param metadataParser The {@link MetadataParser}.
   * @param preReleaseMetadataValidator The {@link PreReleaseMetadataValidator}.
   * @param buildMetadataValidator The {@link BuildMetadataValidator}.
   */
  @Inject
  DefaultSemanticVersionParser(
      final SemanticVersionFactory versionFactory,
      final MetadataParser metadataParser,
      final PreReleaseMetadataValidator preReleaseMetadataValidator,
      final BuildMetadataValidator buildMetadataValidator) {

    // Load dependencies
    this.versionFactory = versionFactory;
    this.metadataParser = metadataParser;
    this.preReleaseMetadataValidator = preReleaseMetadataValidator;
    this.buildMetadataValidator = buildMetadataValidator;

    // Compile REGEX pattern
    versionPattern = Pattern.compile(VERSION_REGEX);
  }

  /**
   * Parses a {@link SemanticVersion}.
   *
   * @param version The version string.
   * @return The {@link SemanticVersion}.
   * @throws InvalidSemanticVersionException If the version string is not a valid semantic version.
   */
  @Override
  public SemanticVersion parse(final String version) throws InvalidSemanticVersionException {
    // Create REGEX matcher
    final Matcher matcher = versionPattern.matcher(version);

    // Handle invalid version strings
    if (!matcher.find()) {
      throw new InvalidSemanticVersionException(version);
    }

    // Extract version components
    final String major = matcher.group(1);
    final String minor = matcher.group(2);
    final String patch = matcher.group(3);

    // Parse version components
    final int majorVersion = Integer.parseInt(major);
    final int minorVersion = Integer.parseInt(minor);
    final int patchVersion = Integer.parseInt(patch);

    // Extract metadata components
    final String preReleaseIdentifiers = matcher.group(4);
    final String buildIdentifiers = matcher.group(5);

    // Parse metadata components
    Metadata preReleaseMetadata;
    Metadata buildMetadata;

    if (preReleaseIdentifiers == null) {
      preReleaseMetadata = null;
    } else {
      preReleaseMetadata = metadataParser.parse(preReleaseIdentifiers);

      if (!preReleaseMetadataValidator.isValid(preReleaseMetadata)) {
        throw new InvalidSemanticVersionException(version);
      }
    }

    if (buildIdentifiers == null) {
      buildMetadata = null;
    } else {
      buildMetadata = metadataParser.parse(buildIdentifiers);

      if (!buildMetadataValidator.isValid(buildMetadata)) {
        throw new InvalidSemanticVersionException(version);
      }
    }

    // Create the version model
    return versionFactory.create(
        majorVersion,
        minorVersion,
        patchVersion,
        preReleaseMetadata,
        buildMetadata);
  }
}
