package com.xellitix.commons.semver.metadata;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.doReturn;

import org.junit.Before;
import org.junit.Test;

/**
 * {@link InvalidMetadataIdentifierException} test case.
 *
 * @author Grayson Kuhns
 */
public class InvalidMetadataIdentifierExceptionTest {

  // Constants
  private static final String INVALID_IDENTIFIER = "fooBar*";
  private static final String MESSAGE = "Invalid metadata identifier: fooBar*";

  // Fixtures
  private Identifier invalidIdentifier;
  private InvalidMetadataIdentifierException exception;

  @Test
  public void getInvalidIdentifier__Test() {
    assertThat(exception
        .getInvalidIdentifier())
        .isNotNull()
        .isEqualTo(invalidIdentifier);
  }

  @Test
  public void getMessage__Test() {
    assertThat(exception
        .getMessage())
        .isNotNull()
        .isEqualTo(MESSAGE);
  }

  @Before
  public void setUp() {
    // Mock the invalid identifier
    invalidIdentifier = mock(Identifier.class);
    doReturn(INVALID_IDENTIFIER)
        .when(invalidIdentifier)
        .getValue();

    // Create the exception
    exception = new InvalidMetadataIdentifierException(invalidIdentifier);
  }
}
