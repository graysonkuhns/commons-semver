package com.xellitix.commons.semver;

import com.xellitix.commons.semver.metadata.Metadata;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

/**
 * {@link DefaultSemanticVersion} test case.
 *
 * @author Grayson Kuhns
 */
public class DefaultSemanticVersionTest {

  // Constants
  private static final int MAJOR = 6;
  private static final int MINOR = 1;
  private static final int PATCH = 22;

  private static final String METADATA_PRE_RELEASE = "rc1.alpha";
  private static final String METADATA_BUILD = "x86_64.5";

  private static final String VERSION_WITH_PRE_RELEASE_METADATA = "6.1.22-rc1.alpha";
  private static final String VERSION_WITH_BUILD_METADATA = "6.1.22+x86_64.5";
  private static final String VERSION_WITH_METADATA = "6.1.22-rc1.alpha+x86_64.5";
  private static final String VERSION_WITHOUT_METADATA = "6.1.22";

  // Fixtures
  private Metadata preReleaseMetadata;
  private Metadata buildMetadata;

  private DefaultSemanticVersion versionWithPreReleaseMetadata;
  private DefaultSemanticVersion versionWithBuildMetadata;
  private DefaultSemanticVersion versionWithMetadata;
  private DefaultSemanticVersion versionWithoutMetadata;

  // #toString
  @Test
  public void toString__WhenVersionHasPreReleaseMetadata__Test() {
    assertThat(versionWithPreReleaseMetadata
        .toString())
        .isNotNull()
        .isEqualTo(VERSION_WITH_PRE_RELEASE_METADATA);
  }

  @Test
  public void toString__WhenVersionHasBuildMetadata__Test() {
    assertThat(versionWithBuildMetadata
        .toString())
        .isNotNull()
        .isEqualTo(VERSION_WITH_BUILD_METADATA);
  }

  @Test
  public void toString__WhenVersionHasMetadata__Test() {
    assertThat(versionWithMetadata
        .toString())
        .isNotNull()
        .isEqualTo(VERSION_WITH_METADATA);
  }

  @Test
  public void toString__WhenVersionDoesNotHaveMetadata__Test() {
    assertThat(versionWithoutMetadata
        .toString())
        .isNotNull()
        .isEqualTo(VERSION_WITHOUT_METADATA);
  }

  // Version components
  @Test
  public void getMajorVersion__Test() {
    assertThat(versionWithoutMetadata
        .getMajorVersion())
        .isNotNull()
        .isEqualTo(MAJOR);
  }

  @Test
  public void getMinorVersion__Test() {
    assertThat(versionWithoutMetadata
        .getMinorVersion())
        .isNotNull()
        .isEqualTo(MINOR);
  }

  @Test
  public void getPatchVersion__Test() {
    assertThat(versionWithoutMetadata
        .getPatchVersion())
        .isNotNull()
        .isEqualTo(PATCH);
  }

  // Metadata
  @Test
  public void getPreReleaseMetadata__WhenVersionHasPreReleaseMetadata__Test() {
    Optional<Metadata> metadata = versionWithMetadata.getPreReleaseMetadata();

    assertThat(metadata
        .isPresent())
        .isTrue();

    assertThat(metadata
        .get()
        .equals(preReleaseMetadata))
        .isTrue();
  }

  @Test
  public void getPreReleaseMetadata__WhenVersionDoesNotHavePreReleaseMetadata__Test() {
    assertThat(versionWithoutMetadata
        .getPreReleaseMetadata()
        .isPresent())
        .isFalse();
  }

  @Test
  public void getBuildMetadata__WhenVersionHasBuildMetadata__Test() {
    Optional<Metadata> metadata = versionWithMetadata.getBuildMetadata();

    assertThat(metadata
        .isPresent())
        .isTrue();

    assertThat(metadata
        .get()
        .equals(buildMetadata))
        .isTrue();
  }

  @Test
  public void getBuildMetadata__WhenVersionDoesNotHaveBuildMetadata__Test() {
    assertThat(versionWithoutMetadata
        .getBuildMetadata()
        .isPresent())
        .isFalse();
  }

  // #isPreRelease
  @Test
  public void isPreReleaseReturnsFalse__WhenVersionDoesNotHavePreReleaseMetadata__Test() {
    assertThat(versionWithoutMetadata
        .isPreRelease())
        .isFalse();
  }

  @Test
  public void isPreReleaseReturnsTrue__WhenVersionHasPreReleaseMetadata__Test() {
    assertThat(versionWithPreReleaseMetadata
        .isPreRelease())
        .isTrue();
  }

  @Before
  public void setUp() {
    // Mock the metadata
    preReleaseMetadata = mock(Metadata.class);
    doReturn(METADATA_PRE_RELEASE)
        .when(preReleaseMetadata)
        .toString();

    buildMetadata = mock(Metadata.class);
    doReturn(METADATA_BUILD)
        .when(buildMetadata)
        .toString();

    // Create the versions
    versionWithPreReleaseMetadata = new DefaultSemanticVersion(MAJOR, MINOR, PATCH, preReleaseMetadata, null);
    versionWithBuildMetadata = new DefaultSemanticVersion(MAJOR, MINOR, PATCH, null, buildMetadata);
    versionWithMetadata = new DefaultSemanticVersion(MAJOR, MINOR, PATCH, preReleaseMetadata, buildMetadata);
    versionWithoutMetadata = new DefaultSemanticVersion(MAJOR, MINOR, PATCH, null, null);
  }
}
