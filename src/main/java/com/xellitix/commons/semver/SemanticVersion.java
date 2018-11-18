package com.xellitix.commons.semver;

import com.xellitix.commons.semver.metadata.Metadata;
import java.io.Serializable;
import java.util.Optional;

/**
 * Semantic version model.
 *
 * @author Grayson Kuhns
 */
public interface SemanticVersion extends Comparable<SemanticVersion>,Serializable {

  /**
   * Gets the major version.
   *
   * @return The major version.
   */
  int getMajorVersion();

  /**
   * Gets the minor version.
   *
   * @return The minor version.
   */
  int getMinorVersion();

  /**
   * Gets the patch version.
   *
   * @return The patch version.
   */
  int getPatchVersion();

  /**
   * Gets the pre-release {@link Metadata}.
   *
   * @return An {@link Optional} containing the pre-release {@link Metadata}.
   */
  Optional<Metadata> getPreReleaseMetadata();

  /**
   * Gets the build {@link Metadata}.
   *
   * @return An {@link Optional} containing the build {@link Metadata}.
   */
  Optional<Metadata> getBuildMetadata();

  /**
   * Checks if the {@link SemanticVersion} is a pre-release.
   *
   * @return True if the {@link SemanticVersion} is a pre-release.
   */
  boolean isPreRelease();

  /**
   * Checks if this {@link SemanticVersion} is greater than another.
   *
   * @param other The other {@link SemanticVersion}.
   * @return True if this {@link SemanticVersion} is greater.
   */
  boolean isGreaterThan(final SemanticVersion other);

  /**
   * Checks if this {@link SemanticVersion} is greater than another.
   *
   * @param other The other {@link SemanticVersion}.
   * @return True if this {@link SemanticVersion} is greater.
   */
  boolean isLessThan(final SemanticVersion other);
}
