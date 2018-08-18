package com.xellitix.commons.semver.metadata;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;

/**
 * {@link NonEmptyIdentifierValidator} test case.
 *
 * @author Grayson Kuhns
 */
public class NonEmptyIdentifierValidatorTest {

  // Constants
  private static final String EMPTY = "";
  private static final String NON_EMPTY = "fooBar";

  // Fixtures
  private Identifier id;
  private NonEmptyIdentifierValidator validator;

  @Test
  public void isValidReturnsFalse__WhenIdentifierValueIsEmpty__Test() {
    id = mockIdentifier(EMPTY);

    assertThat(validator
        .isValid(id))
        .isFalse();
  }

  @Test
  public void isValidReturnsTrue__WhenIdentifierValueIsNonEmpty__Test() {
    id = mockIdentifier(NON_EMPTY);

    assertThat(validator
        .isValid(id))
        .isTrue();
  }

  @Before
  public void setUp() {
    validator = new NonEmptyIdentifierValidator();
  }

  private Identifier mockIdentifier(final String value) {
    Identifier id = mock(Identifier.class);

    doReturn(value)
        .when(id)
        .getValue();

    return id;
  }
}
