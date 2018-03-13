package com.xellitix.commons.semver;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;

/**
 * {@link DefaultSemanticVersionBuilder} test case.
 *
 * @author Grayson Kuhns
 */
public class DefaultSemanticVersionBuilderTest {

  // Constants
  private static final int MAJOR_VERSION = 5;
  private static final int MINOR_VERSION = 6;
  private static final int PATCH_VERSION = 11;

  // Fixtures
  private SemanticVersion version;
  private SemanticVersionFactory versionFactory;
  private DefaultSemanticVersionBuilder versionBuilder;

  @Test
  public void majorVersionRoundTripTest() {
    // Set the major version
    versionBuilder.withMajorVersion(MAJOR_VERSION);

    // Get the major version
    assertThat(versionBuilder
        .getMajorVersion())
        .isEqualTo(MAJOR_VERSION);

    // Build the semantic version
    assertThat(versionBuilder
        .build())
        .isNotNull()
        .isEqualTo(version);
    verify(versionFactory).create(eq(MAJOR_VERSION), eq(0), eq(0));

  }

  @Test
  public void minorVersionRoundTripTest() {
    // Set the minor version
    versionBuilder.withMinorVersion(MINOR_VERSION);

    // Get the minor version
    assertThat(versionBuilder
        .getMinorVersion())
        .isEqualTo(MINOR_VERSION);

    // Build the semantic version
    assertThat(versionBuilder
        .build())
        .isNotNull()
        .isEqualTo(version);
    verify(versionFactory).create(eq(0), eq(MINOR_VERSION), eq(0));
  }

  @Test
  public void patchVersionRoundTripTest() {
    // Set the patch version
    versionBuilder.withPatchVersion(PATCH_VERSION);

    // Get the patch version
    assertThat(versionBuilder
        .getPatchVersion())
        .isEqualTo(PATCH_VERSION);

    // Build the semantic version
    assertThat(versionBuilder
        .build())
        .isNotNull()
        .isEqualTo(version);
    verify(versionFactory).create(eq(0), eq(0), eq(PATCH_VERSION));
  }

  @Before
  public void setUp() {
    // Factory mocking
    version = mock(SemanticVersion.class);
    versionFactory = mock(SemanticVersionFactory.class);
    doReturn(version)
        .when(versionFactory)
        .create(anyInt(), anyInt(), anyInt());

    // Create builder
    versionBuilder = new DefaultSemanticVersionBuilder(versionFactory);
  }
}
