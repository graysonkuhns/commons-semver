package com.xellitix.commons.semver;

import com.google.inject.Singleton;
import com.xellitix.commons.semver.metadata.Metadata;

/**
 * Default {@link SemanticVersionFactory} implementation.
 *
 * @author Grayson Kuhns
 */
@Singleton
public class DefaultSemanticVersionFactory implements SemanticVersionFactory {

  /**
   * Creates a {@link SemanticVersion}.
   *
   * @param major The major version.
   * @param minor The minor version.
   * @param patch The patch version.
   * @return The {@link SemanticVersion}.
   */
  @Override
  public SemanticVersion create(int major, int minor, int patch) {
    return create(major, minor, patch, null, null);
  }

  /**
   * Creates a {@link SemanticVersion}.
   *
   * @param major The major version.
   * @param minor The minor version.
   * @param patch The patch version.
   * @param preReleaseMetadata The pre-release {@link Metadata}.
   * @return The {@link SemanticVersion}.
   */
  @Override
  public SemanticVersion create(int major, int minor, int patch, Metadata preReleaseMetadata) {
    return create(major, minor, patch, preReleaseMetadata, null);
  }

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
  @Override
  public SemanticVersion create(int major, int minor, int patch, Metadata preReleaseMetadata, Metadata buildMetadata) {
    return new DefaultSemanticVersion(major, minor, patch, preReleaseMetadata, buildMetadata);
  }
}
