package com.xellitix.commons.semver;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

import com.xellitix.commons.semver.metadata.BuildMetadataValidator;
import com.xellitix.commons.semver.metadata.Metadata;
import com.xellitix.commons.semver.metadata.MetadataFactory;
import com.xellitix.commons.semver.metadata.MetadataParser;
import com.xellitix.commons.semver.metadata.MetadataValidator;
import com.xellitix.commons.semver.metadata.PreReleaseMetadataIdentifierValidator;
import com.xellitix.commons.semver.metadata.PreReleaseMetadataValidator;
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
  private static final String SEMVER_INVALID = "2.3";
  private static final String SEMVER_METADATA = "1.0.0-..rc.1.+build.1.";

  private static final String METADATA_PRE_RELEASE = "..rc.1.";
  private static final String METADATA_BUILD = "build.1.";

  // Rules
  @Rule
  public ExpectedException thrown = ExpectedException.none();

  // Fixtures
  private Metadata preReleaseMetadata;
  private Metadata buildMetadata;
  private MetadataParser metadataParser;

  private PreReleaseMetadataValidator preReleaseMetadataValidator;
  private BuildMetadataValidator buildMetadataValidator;

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
    verify(versionFactory).create(
        eq(5),
        eq(10),
        eq(0),
        eq(null),
        eq(null));
  }

  @Test
  public void versionIsParsed__WhenVersionContainsMetadata__Test() {
    // Parse the version
    assertThat(versionParser
        .parse(SEMVER_METADATA))
        .isNotNull()
        .isEqualTo(version);

    // Verify the version was parsed correctly
    verify(versionFactory).create(
        eq(1),
        eq(0),
        eq(0),
        eq(preReleaseMetadata),
        eq(buildMetadata));
  }

  @Test
  public void exceptionIsThrown__WhenVersionIsInvalid__Test() {
    // Describe the exception to expect
    thrown.expect(InvalidSemanticVersionException.class);
    thrown.expect(InvalidSemanticVersionExceptionMatcher.hasInvalidVersion(SEMVER_INVALID));

    // Attempt to parse the version
    versionParser.parse(SEMVER_INVALID);
  }

  @Before
  public void setUp() {
    // Metadata mocking
    preReleaseMetadata = mock(Metadata.class);
    buildMetadata = mock(Metadata.class);
    metadataParser = mock(MetadataParser.class);
    doReturn(preReleaseMetadata)
        .when(metadataParser)
        .parse(eq(METADATA_PRE_RELEASE));
    doReturn(buildMetadata)
        .when(metadataParser)
        .parse(eq(METADATA_BUILD));

    // Metadata validator mocking
    preReleaseMetadataValidator = mock(PreReleaseMetadataValidator.class);
    doReturn(true)
        .when(preReleaseMetadataValidator)
        .isValid(eq(preReleaseMetadata));
    doReturn(false)
        .when(preReleaseMetadataValidator)
        .isValid(eq(buildMetadata));

    buildMetadataValidator = mock(BuildMetadataValidator.class);
    doReturn(true)
        .when(buildMetadataValidator)
        .isValid(eq(preReleaseMetadata));
    doReturn(true)
        .when(buildMetadataValidator)
        .isValid(eq(buildMetadata));

    // Version factory mocking
    version = mock(SemanticVersion.class);
    versionFactory = mock(SemanticVersionFactory.class);
    doReturn(version)
        .when(versionFactory)
        .create(anyInt(), anyInt(), anyInt(), any(), any());

    // Create the parser
    versionParser = new DefaultSemanticVersionParser(
        versionFactory,
        metadataParser,
        preReleaseMetadataValidator,
        buildMetadataValidator);
  }
}
