package com.xellitix.commons.semver;

/**
 * {@link SemanticVersion} parser.
 *
 * @author Grayson Kuhns
 */
public interface SemanticVersionParser {

  /**
   * Parses a {@link SemanticVersion}.
   *
   * @param version The version string.
   * @return The {@link SemanticVersion}.
   * @throws InvalidSemanticVersionException If the version string is not a valid semantic version.
   */
  SemanticVersion parse(String version) throws InvalidSemanticVersionException;
}
