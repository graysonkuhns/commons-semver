package com.xellitix.commons.semver;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

public class InvalidSemanticVersionExceptionMatcher extends TypeSafeMatcher<InvalidSemanticVersionException> {

  // Properties
  private final String expectedInvalidVersion;
  private String actualInvalidVersion;

  /**
   * Constructor.
   *
   * @param expectedInvalidVersion The invalid version.
   */
  private InvalidSemanticVersionExceptionMatcher(final String expectedInvalidVersion) {
    this.expectedInvalidVersion = expectedInvalidVersion;
  }

  @Override
  protected boolean matchesSafely(final InvalidSemanticVersionException ex) {
    // Store the actual value to be used in the description
    actualInvalidVersion = ex.getInvalidVersion();

    // Check if the values match
    return actualInvalidVersion.equals(expectedInvalidVersion);
  }

  @Override
  public void describeTo(final Description description) {
    description
        .appendValue(expectedInvalidVersion)
        .appendText(" was expected. ")
        .appendValue(actualInvalidVersion)
        .appendText(" was found.");
  }

  /**
   * Creates a {@link InvalidSemanticVersionExceptionMatcher}.
   *
   * @param expectedInvalidVersion The expected invalid version.
   * @return The {@link InvalidSemanticVersionExceptionMatcher}.
   */
  public static InvalidSemanticVersionExceptionMatcher hasInvalidVersion(final String expectedInvalidVersion) {
    return new InvalidSemanticVersionExceptionMatcher(expectedInvalidVersion);
  }
}
