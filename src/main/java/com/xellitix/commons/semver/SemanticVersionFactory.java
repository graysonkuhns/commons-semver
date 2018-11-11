package com.xellitix.commons.semver;

import com.xellitix.commons.semver.metadata.Metadata;

/**
 * {@link SemanticVersion} factory.
 *
 * @author Grayson Kuhns
 */
public interface SemanticVersionFactory {

  /**
   * Creates a {@link SemanticVersion}.
   *
   * @param major The major version.
   * @param minor The minor version.
   * @param patch The patch version.
   * @return The {@link SemanticVersion}.
   */
  SemanticVersion create(
      int major,
      int minor,
      int patch);

  /**
   * Creates a {@link SemanticVersion}.
   *
   * @param major The major version.
   * @param minor The minor version.
   * @param patch The patch version.
   * @param preReleaseMetadata The pre-release {@link Metadata}.
   * @return The {@link SemanticVersion}.
   */
  SemanticVersion create(
      int major,
      int minor,
      int patch,
      Metadata preReleaseMetadata);

  /**
   * Creates a {@link SemanticVersion}.
   *
   * @param major The major version.
   * @param minor The minor version.
   * @param patch The patch version.
   * @param preReleaseMetadata The pre-release {@link Metadata}.
   * @param buildMetadata The build {@link Metadata}.
   * @return The {@link SemanticVersion}.
   */
  SemanticVersion create(
      int major,
      int minor,
      int patch,
      Metadata preReleaseMetadata,
      Metadata buildMetadata);
}
