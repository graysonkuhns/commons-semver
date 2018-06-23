package com.xellitix.commons.semver.metadata;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

/**
 * {@link DefaultIdentifier} test case.
 *
 * @author Grayson Kuhns
 */
public class DefaultIdentifierTest {

  // #compareTo
  @Test
  public void numericIsLesserThanAlphanumeric__Test() {
    DefaultIdentifier numeric = new DefaultIdentifier("2316518");
    DefaultIdentifier alphaNum = new DefaultIdentifier("6gf5d98yt");

    assertThat(numeric
        .compareTo(alphaNum))
        .isNegative();

    assertThat(alphaNum
        .compareTo(numeric))
        .isPositive();
  }

  @Test
  public void smallNumberIsLesserThanBigNumberTest__Test() {
    DefaultIdentifier small = new DefaultIdentifier("54");
    DefaultIdentifier big = new DefaultIdentifier("324356846512318643213215");

    assertThat(small
        .compareTo(big))
        .isNegative();

    assertThat(big
        .compareTo(small))
        .isPositive();
  }

  @Test
  public void equalNumbersAreEqual__Test() {
    DefaultIdentifier num1 = new DefaultIdentifier("42");
    DefaultIdentifier num2 = new DefaultIdentifier("42");

    assertThat(num1
        .compareTo(num2))
        .isZero();
  }

  @Test
  public void equalAlphanumericStringsAreEqual__Test() {
    DefaultIdentifier alpha1 = new DefaultIdentifier("alpha");
    DefaultIdentifier alpha2 = new DefaultIdentifier("alpha");

    assertThat(alpha1
        .compareTo(alpha2))
        .isZero();
  }

  @Test
  public void alphaIsLesserThanBeta__Test() {
    DefaultIdentifier alpha = new DefaultIdentifier("alpha");
    DefaultIdentifier beta = new DefaultIdentifier("beta");

    assertThat(alpha
        .compareTo(beta))
        .isNegative();

    assertThat(beta
        .compareTo(alpha))
        .isPositive();
  }

  // #isNumeric
  @Test
  public void isNumericReturnsTrue__WhenValueIsNumeric__Test() {
    DefaultIdentifier id = new DefaultIdentifier("35168765123");

    assertThat(id
        .isNumeric())
        .isTrue();
  }

  @Test
  public void isNumericReturnsFalse__WhenValueIsAlphabetical__Test() {
    DefaultIdentifier id = new DefaultIdentifier("fooBar");

    assertThat(id
        .isNumeric())
        .isFalse();
  }

  @Test
  public void isNumericReturnsFalse__WhenValueIsAlphanumeric__Test() {
    DefaultIdentifier id = new DefaultIdentifier("36fooBar42whatIsLife");

    assertThat(id
        .isNumeric())
        .isFalse();
  }

  // #getValue
  @Test
  public void getValueReturnsTheValue__Test() {
    DefaultIdentifier id = new DefaultIdentifier("fooBar");

    assertThat(id
        .getValue())
        .isNotNull()
        .isEqualTo("fooBar");
  }

  // #toString
  @Test
  public void toStringReturnsTheValue__Test() {
    DefaultIdentifier id = new DefaultIdentifier("fooBar");

    assertThat(id
        .toString())
        .isNotNull()
        .isEqualTo("fooBar");
  }
}
