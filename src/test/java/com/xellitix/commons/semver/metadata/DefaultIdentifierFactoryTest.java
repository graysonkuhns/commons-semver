package com.xellitix.commons.semver.metadata;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * {@link DefaultIdentifierFactory} test case.
 *
 * @author Grayson Kuhns
 */
public class DefaultIdentifierFactoryTest {

  // Constants
  private static final String STR_VALUE = "5";
  private static final Integer INT_VALUE = 5;
  private static final Long LONG_VALUE = 5L;
  private static final String NULL_MSG = "Expected value to be non-null";

  // Rules
  @Rule
  public ExpectedException thrown = ExpectedException.none();

  // Fixtures
  private DefaultIdentifierFactory factory;

  @Test
  public void createFromString__Test() {
    Identifier identifier = factory.create(STR_VALUE);

    assertThat(identifier).isNotNull();
    assertThat(identifier
        .getValue())
        .isNotNull()
        .isEqualTo(STR_VALUE);
    assertThat(identifier
        .isNumeric())
        .isTrue();
  }

  @Test
  public void createFromInt__Test() {
    Identifier identifier = factory.create(INT_VALUE);

    assertThat(identifier).isNotNull();
    assertThat(identifier
        .getValue())
        .isNotNull()
        .isEqualTo(STR_VALUE);
    assertThat(identifier
        .isNumeric())
        .isTrue();
  }

  @Test
  public void createFromLong__Test() {
    Identifier identifier = factory.create(LONG_VALUE);

    assertThat(identifier).isNotNull();
    assertThat(identifier
        .getValue())
        .isNotNull()
        .isEqualTo(STR_VALUE);
    assertThat(identifier
        .isNumeric())
        .isTrue();
  }

  @Test
  public void createFromStringThrowsException__WhenInputIsNull__Test() {
    // Describe the exception to expect
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage(NULL_MSG);

    // Attempt to create an identifier using a null value
    factory.create((String) null);
  }

  @Test
  public void createFromIntThrowsException__WhenInputIsNull__Test() {
    // Describe the exception to expect
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage(NULL_MSG);

    // Attempt to create an identifier using a null value
    factory.create((Integer) null);
  }

  @Test
  public void createFromLongThrowsException__WhenInputIsNull__Test() {
    // Describe the exception to expect
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage(NULL_MSG);

    // Attempt to create an identifier using a null value
    factory.create((Long) null);
  }

  @Before
  public void setUp() {
    factory = new DefaultIdentifierFactory();
  }
}
