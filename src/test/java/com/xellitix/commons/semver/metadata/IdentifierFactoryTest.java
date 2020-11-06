package com.xellitix.commons.semver.metadata;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * {@link IdentifierFactory} test case.
 *
 * @author Grayson Kuhns
 */
public class IdentifierFactoryTest {

  // Constants
  private static final String STR_VALUE = "5";
  private static final Integer INT_VALUE = 5;
  private static final Long LONG_VALUE = 5L;
  private static final String NULL_MSG = "Expected value to be non-null";

  // Rules
  @Rule
  public ExpectedException thrown = ExpectedException.none();

  // Fixtures
  private IdentifierFactory factory;

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

  @Before
  public void setUp() {
    factory = new IdentifierFactory();
  }
}
