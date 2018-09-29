package com.xellitix.commons.semver.metadata;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

public class InvalidMetadataIdentifierExceptionMatcher extends TypeSafeMatcher<InvalidMetadataIdentifierException> {

  // Properties
  private final Identifier expectedInvalidIdentifier;
  private Identifier actualInvalidIdentifier;

  /**
   * Constructor.
   *
   * @param expectedInvalidIdentifier The expected invalid identifier.
   */
  private InvalidMetadataIdentifierExceptionMatcher(final Identifier expectedInvalidIdentifier) {
    this.expectedInvalidIdentifier = expectedInvalidIdentifier;
  }

  @Override
  protected boolean matchesSafely(final InvalidMetadataIdentifierException ex) {
    // Store the actual value to be used in the description
    actualInvalidIdentifier = ex.getInvalidIdentifier();

    // Check if the values match
    return actualInvalidIdentifier.equals(expectedInvalidIdentifier);
  }

  @Override
  public void describeTo(final Description description) {
    description
        .appendValue(expectedInvalidIdentifier.getValue())
        .appendText(" was expected. ")
        .appendValue(actualInvalidIdentifier)
        .appendText(" was found.");
  }

  /**
   * Creates a {@link InvalidMetadataIdentifierExceptionMatcher}.
   *
   * @param expectedInvalidIdentifier The expected invalid identifier.
   * @return The {@link InvalidMetadataIdentifierExceptionMatcher}.
   */
  public static InvalidMetadataIdentifierExceptionMatcher hasInvalidIdentifier(final Identifier expectedInvalidIdentifier) {
    return new InvalidMetadataIdentifierExceptionMatcher(expectedInvalidIdentifier);
  }
}
