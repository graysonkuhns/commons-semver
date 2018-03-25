package com.xellitix.commons.semver;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * {@link DefaultSemanticVersionParser} test case.
 *
 * @author Grayson Kuhns
 */
public class DefaultSemanticVersionParserTest {

  // Constants
  private static final String SEMVER_SIMPLE = "5.10.0";
  private static final String SEMVER_METADATA = "1.0.0-rc.1+build.1";
  private static final String SEMVER_INVALID = "2.3";
  private static final String SEMVER_INVALID_MSG =
      "Expected a valid Semantic Version. \"2.3\" received.";

  // Rules
  @Rule
  public ExpectedException thrown = ExpectedException.none();

  // Fixtures
  private SemanticVersion version;
  private SemanticVersionFactory versionFactory;
  private DefaultSemanticVersionParser versionParser;

  @Test
  public void versionIsParsed__WhenVersionIsSimple__Test() {
    // Parse the version
    assertThat(versionParser
        .parse(SEMVER_SIMPLE))
        .isNotNull()
        .isEqualTo(version);

    // Verify the version was parsed correctly
    verify(versionFactory).create(eq(5), eq(10), eq(0));
  }

  @Test
  public void versionIsParsed__WhenVersionContainsMetadata__Test() {
    // Parse the version
    assertThat(versionParser
        .parse(SEMVER_METADATA))
        .isNotNull()
        .isEqualTo(version);

    // Verify the version was parsed correctly
    verify(versionFactory).create(eq(1), eq(0), eq(0));
  }

  @Test
  public void exceptionIsThrown__WhenVersionIsInvalid__Test() {
    // Describe the exception to expect
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage(SEMVER_INVALID_MSG);

    // Attempt to parse the version
    versionParser.parse(SEMVER_INVALID);
  }

  @Before
  public void setUp() {
    // Version factory mocking
    version = mock(SemanticVersion.class);
    versionFactory = mock(SemanticVersionFactory.class);
    doReturn(version)
        .when(versionFactory)
        .create(anyInt(), anyInt(), anyInt());

    // Create the parser
    versionParser = new DefaultSemanticVersionParser(versionFactory);
  }
}
