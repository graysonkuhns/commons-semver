package com.xellitix.commons.semver.metadata;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

/**
 * {@link AlphaNumHyphenIdentifierValidator} test case.
 *
 * @author Grayson Kuhns
 */
public class AlphaNumHyphenIdentifierValidatorTest {

  // Constants
  private static final String ALPHABETICAL = "hello";
  private static final String NUMERIC = "1234567890";
  private static final String HYPHEN = "-";
  private static final String ALPHA_NUMERIC_W_HYPHEN = "hello-World4";
  private static final String SPECIAL_CHARACTERS = "hello&^%*WORLD";
  private static final String SPACES = "hello world";

  // Fixtures
  private Identifier id;
  private AlphaNumHyphenIdentifierValidator validator;

  @Test
  public void isValidReturnsTrue__WhenTheIdentifierValueIsAlphabetical__Test() {
    id = mockIdentifier(ALPHABETICAL);

    assertThat(validator
        .isValid(id))
        .isTrue();
  }

  @Test
  public void isValidReturnsTrue__WhenTheIdentifierValueIsNumeric__Test() {
    id = mockIdentifier(NUMERIC);

    assertThat(validator
        .isValid(id))
        .isTrue();
  }

  @Test
  public void isValidReturnsTrue__WhenTheIdentifierValueIsAHyphen__Test() {
    id = mockIdentifier(HYPHEN);

    assertThat(validator
        .isValid(id))
        .isTrue();
  }

  @Test
  public void isValidReturnsTrue__WhenTheIdentifierValueIsAlphaNumericAndContainsAHyphen__Test() {
    id = mockIdentifier(ALPHA_NUMERIC_W_HYPHEN);

    assertThat(validator
        .isValid(id))
        .isTrue();
  }

  @Test
  public void isValidReturnsFalse__WhenTheIdentifierValueContainsSpecialCharacters__Test() {
    id = mockIdentifier(SPECIAL_CHARACTERS);

    assertThat(validator
        .isValid(id))
        .isFalse();
  }

  @Test
  public void isValidReturnsFalse__WhenTheIdentifierValueContainsSpaces__Test() {
    id = mockIdentifier(SPACES);

    assertThat(validator
        .isValid(id))
        .isFalse();
  }

  @Before
  public void setUp() {
    validator = new AlphaNumHyphenIdentifierValidator();
  }

  private Identifier mockIdentifier(final String value) {
    Identifier id = mock(Identifier.class);

    doReturn(value)
        .when(id)
        .getValue();

    return id;
  }
}
