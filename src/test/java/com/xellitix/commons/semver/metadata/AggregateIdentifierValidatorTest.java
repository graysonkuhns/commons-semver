package com.xellitix.commons.semver.metadata;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import com.google.common.collect.ImmutableSet;
import org.junit.Test;

/**
 * {@link AggregateIdentifierValidator} test case.
 *
 * @author Grayson Kuhns
 */
public class AggregateIdentifierValidatorTest {

  @Test
  public void isValidReturnsTrue__WhenNoAggregatedValidatorReturnsFalse__Test() {
    IdentifierValidator validator = new AggregateIdentifierValidator(ImmutableSet.of(
        createValidator(true),
        createValidator(true),
        createValidator(true)
    ));

    assertThat(validator
        .isValid(mock(Identifier.class)))
        .isTrue();
  }

  @Test
  public void isValidReturnsFalse__WhenAnAggregatedValidatorReturnsFalse__Test() {
    IdentifierValidator validator = new AggregateIdentifierValidator(ImmutableSet.of(
        createValidator(true),
        createValidator(false),
        createValidator(true)
    ));

    assertThat(validator
        .isValid(mock(Identifier.class)))
        .isFalse();
  }

  private IdentifierValidator createValidator(final boolean ret) {
    IdentifierValidator validator = mock(IdentifierValidator.class);

    doReturn(ret)
        .when(validator)
        .isValid(any());

    return validator;
  }
}
