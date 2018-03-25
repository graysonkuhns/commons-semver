package com.xellitix.commons.semver;

import com.google.inject.Inject;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Default {@link SemanticVersionParser} implementation.
 *
 * @author Grayson Kuhns
 */
public class DefaultSemanticVersionParser implements SemanticVersionParser {

  // Messages
  private static final String INVALID_SEMVER_MSG_TEMPLATE =
      "Expected a valid Semantic Version. \"%s\" received.";

  // Constants
  private static final String VERSION_REGEX = "^(\\d+)\\.(\\d+)\\.(\\d+).*$";

  // Properties
  private final Pattern versionPattern;

  // Dependencies
  private final SemanticVersionFactory versionFactory;

  /**
   * Constructor.
   *
   * @param versionFactory The {@link SemanticVersionFactory}
   */
  @Inject
  DefaultSemanticVersionParser(final SemanticVersionFactory versionFactory) {
    // Load dependencies
    this.versionFactory = versionFactory;

    // Compile REGEX pattern
    versionPattern = Pattern.compile(VERSION_REGEX);
  }

  /**
   * Parses a {@link SemanticVersion}.
   *
   * @param version The version string.
   * @return The {@link SemanticVersion}.
   * @throws IllegalArgumentException If the version string is not a valid semantic version.
   */
  @Override
  public SemanticVersion parse(final String version) throws IllegalArgumentException {
    // Create REGEX matcher
    final Matcher matcher = versionPattern.matcher(version);

    // Handle invalid version strings
    if (!matcher.find()) {
      throw new IllegalArgumentException(String.format(INVALID_SEMVER_MSG_TEMPLATE, version));
    }

    // Extract version components
    final String major = matcher.group(1);
    final String minor = matcher.group(2);
    final String patch = matcher.group(3);

    // Parse version components
    final int majorVersion = Integer.parseInt(major);
    final int minorVersion = Integer.parseInt(minor);
    final int patchVersion = Integer.parseInt(patch);

    // Create the version model
    return versionFactory.create(majorVersion, minorVersion, patchVersion);
  }
}
