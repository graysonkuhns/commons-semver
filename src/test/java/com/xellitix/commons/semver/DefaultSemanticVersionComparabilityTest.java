package com.xellitix.commons.semver;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import com.xellitix.commons.semver.metadata.Metadata;
import org.junit.Before;
import org.junit.Test;

/**
 * {@link DefaultSemanticVersion} comparability test case.
 *
 * @author Grayson Kuhns
 */
public class DefaultSemanticVersionComparabilityTest {

  // Fixtures
  private Metadata pr1;
  private Metadata pr2;
  private Metadata pr3;

  private Metadata build1;
  private Metadata build2;

  @Test
  public void versionIsLesser__WhenMajorVersionIsLesser__Test() {
    DefaultSemanticVersion lesser = new DefaultSemanticVersion(1, 0, 0, null, null);
    DefaultSemanticVersion greater = new DefaultSemanticVersion(2, 0, 0, null, null);

    assertThat(lesser
        .compareTo(greater))
        .isNegative();
    assertThat(greater
        .compareTo(lesser))
        .isPositive();

    assertThat(lesser
        .equals(greater))
        .isFalse();

    assertThat(lesser.hashCode())
        .isNotEqualTo(greater.hashCode());
  }

  @Test
  public void versionIsLesser__WhenMinorVersionIsLesser__Test() {
    DefaultSemanticVersion lesser = new DefaultSemanticVersion(1, 0, 0, null, null);
    DefaultSemanticVersion greater = new DefaultSemanticVersion(1, 1, 0, null, null);

    assertThat(lesser
        .compareTo(greater))
        .isNegative();
    assertThat(greater
        .compareTo(lesser))
        .isPositive();

    assertThat(lesser
        .equals(greater))
        .isFalse();

    assertThat(lesser.hashCode())
        .isNotEqualTo(greater.hashCode());
  }

  @Test
  public void versionIsLesser__WhenPatchVersionIsLesser__Test() {
    DefaultSemanticVersion lesser = new DefaultSemanticVersion(1, 0, 0, null, null);
    DefaultSemanticVersion greater = new DefaultSemanticVersion(1, 0, 1, null, null);

    assertThat(lesser
        .compareTo(greater))
        .isNegative();
    assertThat(greater
        .compareTo(lesser))
        .isPositive();

    assertThat(lesser
        .equals(greater))
        .isFalse();

    assertThat(lesser.hashCode())
        .isNotEqualTo(greater.hashCode());
  }

  // Pre-release metadata
  @Test
  public void preReleaseVersionIsLesser__Test() {
    DefaultSemanticVersion lesser = new DefaultSemanticVersion(1, 0, 0, pr1, null);
    DefaultSemanticVersion greater = new DefaultSemanticVersion(1, 0, 0, null, null);

    assertThat(lesser
        .compareTo(greater))
        .isNegative();
    assertThat(greater
        .compareTo(lesser))
        .isPositive();

    assertThat(lesser
        .equals(greater))
        .isFalse();

    assertThat(lesser.hashCode())
        .isNotEqualTo(greater.hashCode());
  }

  @Test
  public void versionIsLesser__WhenPreReleaseMetadataIsLesser__Test() {
    DefaultSemanticVersion lesser = new DefaultSemanticVersion(1, 0, 0, pr1, null);
    DefaultSemanticVersion greater = new DefaultSemanticVersion(1, 0, 0, pr2, null);

    assertThat(lesser
        .compareTo(greater))
        .isNegative();
    assertThat(greater
        .compareTo(lesser))
        .isPositive();

    assertThat(lesser
        .equals(greater))
        .isFalse();

    assertThat(lesser.hashCode())
        .isNotEqualTo(greater.hashCode());
  }

  // Build metadata
  @Test
  public void equalVersionsAreEqual__WhenBuildMetadataIsDifferent__Test() {
    DefaultSemanticVersion version1 = new DefaultSemanticVersion(1, 0, 0, pr1, build1);
    DefaultSemanticVersion version2 = new DefaultSemanticVersion(1, 0, 0, pr1, build2);

    assertThat(version1
        .compareTo(version2))
        .isZero();

    assertThat(version1
        .equals(version2))
        .isTrue();

    assertThat(version1.hashCode())
        .isEqualTo(version2.hashCode());
  }

  @Before
  public void setUp() {
    // Mock pre-release metadata
    pr1 = mock(Metadata.class);
    pr2 = mock(Metadata.class);
    pr3 = mock(Metadata.class);

    doReturn(-1)
        .when(pr1)
        .compareTo(eq(pr2));
    doReturn(-1)
        .when(pr1)
        .compareTo(eq(pr3));

    doReturn(1)
        .when(pr2)
        .compareTo(eq(pr1));
    doReturn(-1)
        .when(pr2)
        .compareTo(pr3);

    doReturn(1)
        .when(pr3)
        .compareTo(eq(pr1));
    doReturn(1)
        .when(pr3)
        .compareTo(eq(pr2));

    // Mock build metadata
    build1 = mock(Metadata.class);
    build2 = mock(Metadata.class);
  }
}
