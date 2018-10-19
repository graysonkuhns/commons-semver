package com.xellitix.commons.semver;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyList;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.xellitix.commons.semver.metadata.BuildMetadataIdentifierValidator;
import com.xellitix.commons.semver.metadata.Identifier;
import com.xellitix.commons.semver.metadata.InvalidMetadataIdentifierException;
import com.xellitix.commons.semver.metadata.InvalidMetadataIdentifierExceptionMatcher;
import com.xellitix.commons.semver.metadata.Metadata;
import com.xellitix.commons.semver.metadata.MetadataFactory;
import com.xellitix.commons.semver.metadata.PreReleaseMetadataIdentifierValidator;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * {@link DefaultSemanticVersionBuilder} test case.
 *
 * @author Grayson Kuhns
 */
public class DefaultSemanticVersionBuilderTest {

  // Constants
  private static final int MAJOR_VERSION = 5;
  private static final int MINOR_VERSION = 6;
  private static final int PATCH_VERSION = 11;

  // Rules
  @Rule
  public ExpectedException thrown = ExpectedException.none();

  // Fixtures
  private Identifier identifierValid;
  private Identifier identifierInvalid;
  private PreReleaseMetadataIdentifierValidator prIdentifierValidator;
  private BuildMetadataIdentifierValidator buildIdentifierValidator;

  private Metadata metadata;
  private MetadataFactory metadataFactory;

  private SemanticVersion version;
  private SemanticVersionFactory versionFactory;

  private DefaultSemanticVersionBuilder versionBuilder;

  @Test
  public void majorVersionRoundTrip__Test() {
    // Set the major version
    versionBuilder.setMajorVersion(MAJOR_VERSION);

    // Get the major version
    assertThat(versionBuilder
        .getMajorVersion())
        .isEqualTo(MAJOR_VERSION);

    // Build the semantic version
    assertThat(versionBuilder
        .build())
        .isNotNull()
        .isEqualTo(version);
    verify(versionFactory).create(
        eq(MAJOR_VERSION),
        eq(0),
        eq(0),
        eq(null),
        eq(null));
  }

  @Test
  public void minorVersionRoundTrip__Test() {
    // Set the minor version
    versionBuilder.setMinorVersion(MINOR_VERSION);

    // Get the minor version
    assertThat(versionBuilder
        .getMinorVersion())
        .isEqualTo(MINOR_VERSION);

    // Build the semantic version
    assertThat(versionBuilder
        .build())
        .isNotNull()
        .isEqualTo(version);
    verify(versionFactory).create(
        eq(0),
        eq(MINOR_VERSION),
        eq(0),
        eq(null),
        eq(null));
  }

  @Test
  public void patchVersionRoundTrip__Test() {
    // Set the patch version
    versionBuilder.setPatchVersion(PATCH_VERSION);

    // Get the patch version
    assertThat(versionBuilder
        .getPatchVersion())
        .isEqualTo(PATCH_VERSION);

    // Build the semantic version
    assertThat(versionBuilder
        .build())
        .isNotNull()
        .isEqualTo(version);
    verify(versionFactory).create(
        eq(0),
        eq(0),
        eq(PATCH_VERSION),
        eq(null),
        eq(null));
  }

  @Test
  public void addPreReleaseMetadataIdentifier__Test() {
    versionBuilder.addPreReleaseMetadataIdentifier(identifierValid);

    assertThat(versionBuilder
        .build())
        .isNotNull()
        .isEqualTo(version);
    verify(versionFactory).create(
        eq(0),
        eq(0),
        eq(0),
        eq(metadata),
        eq(null));
  }

  @Test
  public void clearPreReleaseMetadataIdentifiers__Test() {
    versionBuilder.addPreReleaseMetadataIdentifier(identifierValid);
    versionBuilder.clearPreReleaseMetadata();

    assertThat(versionBuilder
        .build())
        .isNotNull()
        .isEqualTo(version);
    verify(versionFactory).create(
        eq(0),
        eq(0),
        eq(0),
        eq(null),
        eq(null));
  }

  @Test
  public void addBuildMetadataIdentifier__Test() {
    versionBuilder.addBuildMetadataIdentifier(identifierValid);

    assertThat(versionBuilder
        .build())
        .isNotNull()
        .isEqualTo(version);
    verify(versionFactory).create(
        eq(0),
        eq(0),
        eq(0),
        eq(null),
        eq(metadata));
  }

  @Test
  public void clearBuildMetadataIdentifier__Test() {
    versionBuilder.addBuildMetadataIdentifier(identifierValid);
    versionBuilder.clearBuildMetadata();

    assertThat(versionBuilder
        .build())
        .isNotNull()
        .isEqualTo(version);
    verify(versionFactory).create(
        eq(0),
        eq(0),
        eq(0),
        eq(null),
        eq(null));
  }

  @Test
  public void addInvalidPreReleaseIdentifier__CausesException__Test() {
    // Describe the exception to expect
    thrown.expect(InvalidMetadataIdentifierException.class);
    thrown.expect(InvalidMetadataIdentifierExceptionMatcher.hasInvalidIdentifier(identifierInvalid));

    // Attempt to add an invalid PR identifier
    versionBuilder.addPreReleaseMetadataIdentifier(identifierInvalid);
  }

  @Test
  public void addInvalidBuildIdentifier__CausesException__Test() {
    // Describe the exception to expect
    thrown.expect(InvalidMetadataIdentifierException.class);
    thrown.expect(InvalidMetadataIdentifierExceptionMatcher.hasInvalidIdentifier(identifierInvalid));

    // Attempt to add an invalid build identifier
    versionBuilder.addBuildMetadataIdentifier(identifierInvalid);
  }

  @Before
  public void setUp() {
    // Identifier mocking
    identifierValid = mock(Identifier.class);
    identifierInvalid = mock(Identifier.class);

    // Identifier validator mocking
    prIdentifierValidator = mock(PreReleaseMetadataIdentifierValidator.class);
    doReturn(true)
        .when(prIdentifierValidator)
        .isValid(eq(identifierValid));
    doReturn(false)
        .when(prIdentifierValidator)
        .isValid(eq(identifierInvalid));

    buildIdentifierValidator = mock(BuildMetadataIdentifierValidator.class);
    doReturn(true)
        .when(buildIdentifierValidator)
        .isValid(eq(identifierValid));
    doReturn(false)
        .when(buildIdentifierValidator)
        .isValid(eq(identifierInvalid));

    // Metadata factory mocking
    metadataFactory = mock(MetadataFactory.class);
    doReturn(metadata)
        .when(metadataFactory)
        .create(anyList());

    // Version factory mocking
    version = mock(SemanticVersion.class);
    versionFactory = mock(SemanticVersionFactory.class);
    doReturn(version)
        .when(versionFactory)
        .create(anyInt(), anyInt(), anyInt(), any(), any());

    // Create builder
    versionBuilder = new DefaultSemanticVersionBuilder(
        versionFactory,
        metadataFactory,
        prIdentifierValidator,
        buildIdentifierValidator);
  }
}
