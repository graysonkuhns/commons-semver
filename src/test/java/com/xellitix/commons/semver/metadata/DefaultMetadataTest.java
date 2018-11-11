package com.xellitix.commons.semver.metadata;

import java.util.Arrays;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.doReturn;

/**
 * {@link DefaultMetadata} test.
 *
 * @author Grayson Kuhns
 */
public class DefaultMetadataTest {

  // Constants
  private static final String METADATA = "a.b.c";

  // Fixtures
  private Identifier a;
  private Identifier b;
  private Identifier c;

  @Test
  public void greaterIdentifierListTakesPrecedenceOverLesserListOfEqualLength__Test() {
    // Create the identifier lists
    DefaultMetadata lesser = new DefaultMetadata(Arrays.asList(a, b, a));
    DefaultMetadata greater = new DefaultMetadata(Arrays.asList(a, b, c));

    // Validate that the greater identifier lists takes precedence
    assertThat(lesser
        .compareTo(greater))
        .isNegative();
    assertThat(greater
        .compareTo(lesser))
        .isPositive();
  }

  @Test
  public void largerIdentifierListTakesPrecedence__Test() {
    // Create short identifier list
    DefaultMetadata shorter = new DefaultMetadata(Arrays.asList(a, b));

    // Create long identifier list
    DefaultMetadata longer = new DefaultMetadata(Arrays.asList(a, b, c));

    // Validate that the longer identifier list takes precedence
    assertThat(shorter
        .compareTo(longer))
        .isNegative();
    assertThat(longer
        .compareTo(shorter))
        .isPositive();
  }

  @Test
  public void equalIdentifierListsAreEqual__Test() {
    // Create identifier lists
    DefaultMetadata metadata1 = new DefaultMetadata(Arrays.asList(a, b));
    DefaultMetadata metadata2 = new DefaultMetadata(Arrays.asList(a, b));

    // Validate that the identifier lists are equal
    assertThat(metadata1
        .compareTo(metadata2))
        .isZero();
    assertThat(metadata2
        .compareTo(metadata1))
        .isZero();
  }

  @Test
  public void toString__Test() {
    // Create metadata
    DefaultMetadata metadata = new DefaultMetadata(Arrays.asList(a, b, c));

    assertThat(metadata
        .toString())
        .isNotNull()
        .isEqualTo(METADATA);
  }

  @Test
  public void equalsReturnsTrue__WhenMetadataAreEqual__Test() {
    DefaultMetadata metadata1 = new DefaultMetadata(Arrays.asList(a, b));
    DefaultMetadata metadata2 = new DefaultMetadata(Arrays.asList(a, b));

    assertThat(metadata1
        .equals(metadata2))
        .isTrue();
  }

  @Test
  public void equalsReturnsFalse__WhenMetadataAreNotEqual__Test() {
    DefaultMetadata metadata1 = new DefaultMetadata(Arrays.asList(a, b));
    DefaultMetadata metadata2 = new DefaultMetadata(Arrays.asList(a, c));

    assertThat(metadata1
        .equals(metadata2))
        .isFalse();
  }

  @Test
  public void hashCodeIsEqual__WhenMetadataAreEqual__Test() {
    DefaultMetadata metadata1 = new DefaultMetadata(Arrays.asList(a, b));
    DefaultMetadata metadata2 = new DefaultMetadata(Arrays.asList(a, b));

    assertThat(metadata1.hashCode())
        .isEqualTo(metadata2.hashCode());
  }

  @Test
  public void hashCodeIsDifferent__WhenMetadataAreNotEqual__Test() {
    DefaultMetadata metadata1 = new DefaultMetadata(Arrays.asList(a, b));
    DefaultMetadata metadata2 = new DefaultMetadata(Arrays.asList(a, c));

    assertThat(metadata1.hashCode())
        .isNotEqualTo(metadata2.hashCode());
  }

  @Before
  public void setUp() {
    // Mock identifiers
    a = mock(Identifier.class);
    doReturn("a")
        .when(a)
        .getValue();

    b = mock(Identifier.class);
    doReturn("b")
        .when(b)
        .getValue();

    c = mock(Identifier.class);
    doReturn("c")
        .when(c)
        .getValue();

    // Mock identifier precedence
    // a
    doReturn(0)
        .when(a)
        .compareTo(eq(a));
    doReturn(-1)
        .when(a)
        .compareTo(eq(b));
    doReturn(-1)
        .when(a)
        .compareTo(eq(c));

    // b
    doReturn(1)
        .when(b)
        .compareTo(eq(a));
    doReturn(0)
        .when(b)
        .compareTo(eq(b));
    doReturn(-1)
        .when(b)
        .compareTo(eq(c));

    // c
    doReturn(1)
        .when(c)
        .compareTo(eq(a));
    doReturn(1)
        .when(c)
        .compareTo(eq(b));
    doReturn(0)
        .when(c)
        .compareTo(eq(c));
  }
}
