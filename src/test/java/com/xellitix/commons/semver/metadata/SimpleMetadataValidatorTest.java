package com.xellitix.commons.semver.metadata;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import com.google.common.collect.ImmutableList;
import org.junit.Before;
import org.junit.Test;

/**
 * {@link SimpleMetadataValidator} test case.
 *
 * @author Grayson Kuhns
 */
public class SimpleMetadataValidatorTest {

  // Fixtures
  private Identifier valid1;
  private Identifier valid2;
  private Identifier invalid;

  private IdentifierValidator identifierValidator;
  private SimpleMetadataValidator metadataValidator;

  @Test
  public void isValidReturnsTrue__WhenAllIdentifiersAreValid__Test() {
    Metadata metadata = new DefaultMetadata(ImmutableList.of(
        valid1,
        valid2
    ));

    assertThat(metadataValidator
        .isValid(metadata))
        .isTrue();
  }

  @Test
  public void isValidReturnsFalse__WhenAnIdentifierIsInvalid__Test() {
    Metadata metadata = new DefaultMetadata(ImmutableList.of(
        valid1,
        invalid,
        valid2
    ));

    assertThat(metadataValidator
        .isValid(metadata))
        .isFalse();
  }

  @Before
  public void setUp() {
    // Mock the identifiers
    valid1 = mock(Identifier.class);
    valid2 = mock(Identifier.class);
    invalid = mock(Identifier.class);

    // Mock the identifier validator
    identifierValidator = mock(IdentifierValidator.class);
    doReturn(true)
        .when(identifierValidator)
        .isValid(eq(valid1));
    doReturn(true)
        .when(identifierValidator)
        .isValid(eq(valid2));
    doReturn(false)
        .when(identifierValidator)
        .isValid(eq(invalid));

    // Create the metadata validator
    metadataValidator = new SimpleMetadataValidator(identifierValidator);
  }
}
