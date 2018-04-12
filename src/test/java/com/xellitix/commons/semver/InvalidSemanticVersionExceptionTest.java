package com.xellitix.commons.semver;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

/**
 * {@link InvalidSemanticVersionException} test case.
 *
 * @author Grayson Kuhns
 */
public class InvalidSemanticVersionExceptionTest {

  // Constants
  private static final String INVALID_VERSION = "1.3";
  private static final String MESSAGE = "Invalid version: 1.3";

  // Fixtures
  private InvalidSemanticVersionException exception = new InvalidSemanticVersionException(INVALID_VERSION);

  @Test
  public void getInvalidVersion__Test() {
    assertThat(exception
        .getInvalidVersion())
        .isNotNull()
        .isEqualTo(INVALID_VERSION);
  }

  @Test
  public void getMessage__Test() {
    assertThat(exception
        .getMessage())
        .isNotNull()
        .isEqualTo(MESSAGE);
  }
}
