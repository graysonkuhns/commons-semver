package com.xellitix.commons.semver;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * {@link DefaultSemanticVersion} test case.
 *
 * @author Grayson Kuhns
 */
public class DefaultSemanticVersionTest {

  // Constants
  private static final String VERSION = "6.1.22";
  private static final int MAJOR = 6;
  private static final int MINOR = 1;
  private static final int PATCH = 22;

  // Fixtures
  private final DefaultSemanticVersion version = new DefaultSemanticVersion(MAJOR, MINOR, PATCH);

  @Test
  public void toStringTest() {
    assertThat(version
        .toString())
        .isNotNull()
        .isEqualTo(VERSION);
  }

  @Test
  public void getMajorVersionTest() {
    assertThat(version
        .getMajorVersion())
        .isNotNull()
        .isEqualTo(MAJOR);
  }

  @Test
  public void getMinorVersionTest() {
    assertThat(version
        .getMinorVersion())
        .isNotNull()
        .isEqualTo(MINOR);
  }

  @Test
  public void getPatchVersionTest() {
    assertThat(version
        .getPatchVersion())
        .isNotNull()
        .isEqualTo(PATCH);
  }
}
