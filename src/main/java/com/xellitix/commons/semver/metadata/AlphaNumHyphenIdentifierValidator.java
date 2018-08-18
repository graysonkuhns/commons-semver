package com.xellitix.commons.semver.metadata;

import com.google.inject.Singleton;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * {@link IdentifierValidator} that validates the {@link Identifier} character set.
 *
 * <p>
 *   Semantic Versioning rule:
 *   Identifiers MUST comprise only ASCII alphanumerics and hyphen [0-9A-Za-z-].
 * </p>
 *
 * @author Grayson Kuhns
 */
@Singleton
public class AlphaNumHyphenIdentifierValidator implements IdentifierValidator {

  // Constants
  private static final String ALPHA_NUM_HYPHEN_REGEX = "^[0-9A-Za-z-]*$";

  // Properties
  private final Pattern regexPattern = Pattern.compile(ALPHA_NUM_HYPHEN_REGEX);

  /**
   * Checks if an {@link Identifier} is valid.
   *
   * @param identifier The {@link Identifier}.
   * @return True if the {@link Identifier} is valid.
   */
  @Override
  public boolean isValid(final Identifier identifier) {
    final String value = identifier.getValue();
    final Matcher matcher = regexPattern.matcher(value);

    return matcher.matches();
  }
}
