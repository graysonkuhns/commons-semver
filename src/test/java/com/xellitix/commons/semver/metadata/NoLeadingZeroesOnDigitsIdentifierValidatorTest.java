package com.xellitix.commons.semver.metadata;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;

/**
 * {@link NoLeadingZeroesOnDigitsIdentifierValidator} test case.
 *
 * @author Grayson Kuhns
 */
public class NoLeadingZeroesOnDigitsIdentifierValidatorTest {

  // Constants
  private static final String SINGLE_ZERO = "0";
  private static final String DOUBLE_ZERO = "00";
  private static final String LEADING_ZERO = "042";
  private static final String NO_LEADING_ZERO = "42";
  private static final String ALPHA_NUMERIC = "hello42";

  // Fixtures
  private Identifier id;
  private NoLeadingZeroesOnDigitsIdentifierValidator validator;

  @Test
  public void isValidReturnsTrue__WhenTheIdentifierValueIsASingleZero__Test() {
    id = mockIdentifier(SINGLE_ZERO, true);

    assertThat(validator
        .isValid(id))
        .isTrue();
  }

  @Test
  public void isValidReturnsFalse__WhenTheIdentifierValueContainsTwoZeros__Test() {
    id = mockIdentifier(DOUBLE_ZERO, true);

    assertThat(validator
        .isValid(id))
        .isFalse();
  }

  @Test
  public void isValidReturnsFalse__WhenTheIdentifierValueIsADigitWithALeadingZero__Test() {
    id = mockIdentifier(LEADING_ZERO, true);

    assertThat(validator
        .isValid(id))
        .isFalse();
  }

  @Test
  public void isValidReturnsTrue__WhenTheIdentifierValueIsADigitWithoutALeadingZero__Test() {
    id = mockIdentifier(NO_LEADING_ZERO, true);

    assertThat(validator
        .isValid(id))
        .isTrue();
  }

  @Test
  public void isValidReturnsTrue__WhenTheIdentifierValueIsNotNumeric__Test() {
    id = mockIdentifier(ALPHA_NUMERIC, false);

    assertThat(validator
        .isValid(id))
        .isTrue();
  }

  @Before
  public void setUp() {
    validator = new NoLeadingZeroesOnDigitsIdentifierValidator();
  }

  private Identifier mockIdentifier(final String value, final boolean isNumeric) {
    Identifier id = mock(Identifier.class);

    doReturn(value)
        .when(id)
        .getValue();

    doReturn(isNumeric)
        .when(id)
        .isNumeric();

    return id;
  }
}
