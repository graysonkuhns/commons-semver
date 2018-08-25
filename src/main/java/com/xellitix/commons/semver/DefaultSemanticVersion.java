package com.xellitix.commons.semver;

import com.xellitix.commons.semver.metadata.Metadata;
import java.util.Optional;
import javax.annotation.Nullable;

/**
 * Default {@link SemanticVersion} implementation.
 *
 * @author Grayson Kuhns
 */
public class DefaultSemanticVersion implements SemanticVersion {

  // Properties
  private final int major;
  private final int minor;
  private final int patch;
  private final Metadata preReleaseMetadata;
  private final Metadata buildMetadata;

  /**
   * Constructor.
   *
   * @param major The major version.
   * @param minor The minor version.
   * @param patch The patch version;
   * @param preReleaseMetadata The pre-release {@link Metadata}.
   * @param buildMetadata The build {@link Metadata}.
   */
  DefaultSemanticVersion(
      final int major,
      final int minor,
      final int patch,
      @Nullable final Metadata preReleaseMetadata,
      @Nullable final Metadata buildMetadata) {

    this.major = major;
    this.minor = minor;
    this.patch = patch;
    this.preReleaseMetadata = preReleaseMetadata;
    this.buildMetadata = buildMetadata;
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
   * Gets the minor version.
   *
   * @return The minor version.
   */
  @Override
  public int getMinorVersion() {
    return minor;
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
   * Gets the pre-release {@link Metadata}.
   *
   * @return An {@link Optional} containing the pre-release {@link Metadata}.
   */
  @Override
  public Optional<Metadata> getPreReleaseMetadata() {
    return Optional.ofNullable(preReleaseMetadata);
  }

  /**
   * Gets the build {@link Metadata}.
   *
   * @return An {@link Optional} containing the build {@link Metadata}.
   */
  @Override
  public Optional<Metadata> getBuildMetadata() {
    return Optional.ofNullable(buildMetadata);
  }

  /**
   * Gets the string representation.
   *
   * @return The string representation.
   */
  @Override
  public String toString() {
    return String.format("%d.%d.%d", major, minor, patch);
  }
}
