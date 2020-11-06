package com.xellitix.commons.semver.metadata;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

/**
 * {@link Identifier} test case.
 *
 * @author Grayson Kuhns
 */
public class IdentifierTest {

  // #compareTo
  @Test
  public void numericIsLesserThanAlphanumeric__Test() {
    Identifier numeric = new Identifier("2316518");
    Identifier alphaNum = new Identifier("6gf5d98yt");

    assertThat(numeric
        .compareTo(alphaNum))
        .isNegative();

    assertThat(alphaNum
        .compareTo(numeric))
        .isPositive();
  }

  @Test
  public void smallNumberIsLesserThanBigNumberTest__Test() {
    Identifier small = new Identifier("54");
    Identifier big = new Identifier("324356846512318643213215");

    assertThat(small
        .compareTo(big))
        .isNegative();

    assertThat(big
        .compareTo(small))
        .isPositive();
  }

  @Test
  public void equalNumbersAreEqual__Test() {
    Identifier num1 = new Identifier("42");
    Identifier num2 = new Identifier("42");

    assertThat(num1
        .compareTo(num2))
        .isZero();
  }

  @Test
  public void equalAlphanumericStringsAreEqual__Test() {
    Identifier alpha1 = new Identifier("alpha");
    Identifier alpha2 = new Identifier("alpha");

    assertThat(alpha1
        .compareTo(alpha2))
        .isZero();
  }

  @Test
  public void alphaIsLesserThanBeta__Test() {
    Identifier alpha = new Identifier("alpha");
    Identifier beta = new Identifier("beta");

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
    Identifier id = new Identifier("35168765123");

    assertThat(id
        .isNumeric())
        .isTrue();
  }

  @Test
  public void isNumericReturnsFalse__WhenValueIsAlphabetical__Test() {
    Identifier id = new Identifier("fooBar");

    assertThat(id
        .isNumeric())
        .isFalse();
  }

  @Test
  public void isNumericReturnsFalse__WhenValueIsAlphanumeric__Test() {
    Identifier id = new Identifier("36fooBar42whatIsLife");

    assertThat(id
        .isNumeric())
        .isFalse();
  }

  // #getValue
  @Test
  public void getValueReturnsTheValue__Test() {
    Identifier id = new Identifier("fooBar");

    assertThat(id
        .getValue())
        .isNotNull()
        .isEqualTo("fooBar");
  }

  // #toString
  @Test
  public void toStringReturnsTheValue__Test() {
    Identifier id = new Identifier("fooBar");

    assertThat(id
        .toString())
        .isNotNull()
        .isEqualTo("fooBar");
  }

  // #equals
  @Test
  public void equalsReturnsTrue__WhenIdentifiersAreEqual__Test() {
    Identifier alpha1 = new Identifier("alpha");
    Identifier alpha2 = new Identifier("alpha");

    assertThat(alpha1
        .equals(alpha2))
        .isTrue();
  }

  @Test
  public void equalsReturnsFalse__WhenIdentifiersAreNotEqual__Test() {
    Identifier alpha = new Identifier("alpha");
    Identifier beta = new Identifier("beta");

    assertThat(alpha
        .equals(beta))
        .isFalse();
  }

  // #hashCode
  @Test
  public void hashCodeIsTheSame__WhenIdentifiersAreEqual__Test() {
    Identifier alpha1 = new Identifier("alpha");
    Identifier alpha2 = new Identifier("alpha");

    assertThat(alpha1.hashCode())
        .isEqualTo(alpha2.hashCode());
  }

  @Test
  public void hashCodeIsDifferent__WhenIdentifiersAreNotEqual__Test() {
    Identifier alpha = new Identifier("alpha");
    Identifier beta = new Identifier("beta");

    assertThat(alpha.hashCode())
        .isNotEqualTo(beta.hashCode());
  }
}
