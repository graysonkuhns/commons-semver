package com.xellitix.commons.semver;

import com.xellitix.commons.semver.metadata.Metadata;
import java.util.Objects;
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
   * Checks if the {@link SemanticVersion} is a pre-release.
   *
   * @return True if the {@link SemanticVersion} is a pre-release.
   */
  @Override
  public boolean isPreRelease() {
    return preReleaseMetadata != null;
  }

  /**
   * Checks if the software associated with the {@link SemanticVersion} has a stable API.
   *
   * <p>
   * The API is considered stable if the major version is non-zero.
   * </p>
   *
   * @return True if the API is stable.
   */
  @Override
  public boolean hasStableApi() {
    return major > 0;
  }

  /**
   * Checks if this {@link SemanticVersion} is greater than another.
   *
   * @param other The other {@link SemanticVersion}.
   * @return True if this {@link SemanticVersion} is greater.
   */
  @Override
  public boolean isGreaterThan(final SemanticVersion other) {
    return compareTo(other) > 0;
  }

  /**
   * Checks if this {@link SemanticVersion} is greater than another.
   *
   * @param other The other {@link SemanticVersion}.
   * @return True if this {@link SemanticVersion} is greater.
   */
  @Override
  public boolean isLessThan(final SemanticVersion other) {
    return compareTo(other) < 0;
  }

  /**
   * Gets the string representation.
   *
   * @return The string representation.
   */
  @Override
  public String toString() {
    final StringBuilder version = new StringBuilder();

    version.append(major);
    version.append('.');

    version.append(minor);
    version.append('.');

    version.append(patch);

    if (preReleaseMetadata != null) {
      version.append('-');
      version.append(preReleaseMetadata.toString());
    }

    if (buildMetadata != null) {
      version.append('+');
      version.append(buildMetadata.toString());
    }

    return version.toString();
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof SemanticVersion)) {
      return false;
    }
    SemanticVersion other = (SemanticVersion) o;

    // Compare pre-release metadata
    Optional<Metadata> otherPrm = other.getPreReleaseMetadata();

    if (preReleaseMetadata == null && otherPrm.isPresent()) {
      return false;
    } else if (preReleaseMetadata != null && !otherPrm.isPresent()) {
      return false;
    } else if (
        preReleaseMetadata != null
        && otherPrm.isPresent()
        && !preReleaseMetadata.equals(otherPrm.get())) {

      return false;
    }

    // Compare primary version components
    return (
        major == other.getMajorVersion()
        && minor == other.getMinorVersion()
        && patch == other.getPatchVersion()
        );
  }

  @Override
  public int hashCode() {
    return Objects.hash(major, minor, patch, preReleaseMetadata);
  }

  @Override
  public int compareTo(final SemanticVersion other) {
    // Major
    if (major < other.getMajorVersion()) {
      return -1;
    }

    if (major > other.getMajorVersion()) {
      return 1;
    }

    // Minor
    if (minor < other.getMinorVersion()) {
      return -1;
    }

    if (minor > other.getMinorVersion()) {
      return 1;
    }

    // Patch
    if (patch < other.getPatchVersion()) {
      return -1;
    }

    if (patch > other.getPatchVersion()) {
      return 1;
    }

    // Pre-release metadata
    final Optional<Metadata> otherPrm = other.getPreReleaseMetadata();

    if (preReleaseMetadata != null && !otherPrm.isPresent()) {
      return -1;
    }

    if (preReleaseMetadata == null && otherPrm.isPresent()) {
      return 1;
    }

    return preReleaseMetadata.compareTo(otherPrm.get());
  }
}
