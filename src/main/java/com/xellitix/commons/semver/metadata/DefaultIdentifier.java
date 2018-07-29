package com.xellitix.commons.semver.metadata;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import java.math.BigInteger;

/**
 * Default {@link Identifier} implementation.
 *
 * @author Grayson Kuhns
 */
public class DefaultIdentifier implements Identifier {

  // Properties
  private final String value;
  private final boolean isNumeric;

  /**
   * Constructor.
   *
   * @param value The value.
   */
  @Inject
  DefaultIdentifier(@Assisted final String value) {
    this.value = value;

    // Determine if the value is numeric
    boolean nonDigitFound = false;

    for (char ch : value.toCharArray()) {
      if (!Character.isDigit(ch)) {
        nonDigitFound = true;
      }
    }

    this.isNumeric = !nonDigitFound;
  }

  /**
   * Gets the value.
   *
   * @return The value.
   */
  @Override
  public String getValue() {
    return value;
  }

  /**
   * Gets the string representation of this object.
   *
   * @return The string representation of this object.
   */
  @Override
  public String toString() {
    return getValue();
  }

  /**
   * Checks if the {@link Identifier} is numeric.
   *
   * @return True if the {@link Identifier} is numeric.
   */
  @Override
  public boolean isNumeric() {
    return isNumeric;
  }

  /**
   * Compares against another {@link Identifier}.
   *
   * @param other The {@link Identifier} to compare against.
   * @return A negative integer, zero, or a positive integer as this object is less than, equal to, or greater than the specified object.
   */
  @Override
  public int compareTo(final Identifier other) {
    /*
     negative int = this < other
     0 = this == other
     positive int = this > other

     identifiers consisting of only digits are compared numerically and identifiers
     with letters or hyphens are compared lexically in ASCII sort order.
     Numeric identifiers always have lower precedence than non-numeric identifiers.
     */

    // Cover case of type inequality and numeric comparison
    if (isNumeric) {
      if (other.isNumeric()) {
        // Possibly equal
        // It might be a big value
        final BigInteger me = new BigInteger(value);
        final BigInteger otr = new BigInteger(other.getValue());

        // Check for equality
        return me.compareTo(otr);
      } else {
        // Less than
        return -1;
      }
    } else if (other.isNumeric()) {
      // Greater than
      return 1;
    }

    // At this point we know that both identifiers are non-numeric
    // Perform lexicographical comparison
    return value.compareTo(other.getValue());
  }
}
