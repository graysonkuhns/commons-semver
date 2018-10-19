package com.xellitix.commons.semver;

import static org.assertj.core.api.Assertions.assertThat;

import com.google.inject.Guice;
import com.google.inject.Injector;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;

/**
 * Project acceptance test.
 *
 * @author Grayson Kuhns
 */
public class AcceptanceTest {

  // Constants
  private static final String VERSION_1 = "1.0.0-alpha";
  private static final String VERSION_2 = "1.0.0-alpha.1";
  private static final String VERSION_3 = "1.0.0-alpha.beta";
  private static final String VERSION_4 = "1.0.0-beta";
  private static final String VERSION_5 = "1.0.0-beta.2";
  private static final String VERSION_6 = "1.0.0-beta.11";
  private static final String VERSION_7 = "1.0.0-rc.1";
  private static final String VERSION_8 = "1.0.0.";

  // Fixtures
  private Injector injector;
  SemanticVersionParser parser;

  private SemanticVersion version1;
  private SemanticVersion version2;
  private SemanticVersion version3;
  private SemanticVersion version4;
  private SemanticVersion version5;
  private SemanticVersion version6;
  private SemanticVersion version7;
  private SemanticVersion version8;

  /*
  @Test
  public void versionEquality__Test() {
    SemanticVersion a = parser.parse("1.0.0-rc.1");
    SemanticVersion b = injector
        .getInstance(SemanticVersionBuilder.class)
        .setMajorVersion(1)
        .addPreReleaseMetadataIdentifier("rc")
        .addPreReleaseMetadataIdentifier("1")
        .build();

    assertThat(a).isEqualTo(b);
  }
  */

  @Test
  public void validVersionsAreParsedCorrectly__Test() {
    assertThatVersionIs100(version1);
    assertThatVersionIs100(version2);
    assertThatVersionIs100(version3);
    assertThatVersionIs100(version4);
    assertThatVersionIs100(version5);
    assertThatVersionIs100(version6);
    assertThatVersionIs100(version7);
    assertThatVersionIs100(version8);
  }

  private void assertThatVersionIs100(final SemanticVersion version) {
    assertThat(version
        .getMajorVersion())
        .isEqualTo(1);
    assertThat(version
        .getMinorVersion())
        .isEqualTo(0);
    assertThat(version
        .getPatchVersion())
        .isEqualTo(0);
  }

  @Before
  public void setUp() {
    // Create the Guice injector
    injector = Guice.createInjector(new SemanticVersionModule());

    // Create the version parser
    parser = injector.getInstance(SemanticVersionParser.class);

    // Parse the versions
    version1 = parser.parse(VERSION_1);
    version2 = parser.parse(VERSION_2);
    version3 = parser.parse(VERSION_3);
    version4 = parser.parse(VERSION_4);
    version5 = parser.parse(VERSION_5);
    version6 = parser.parse(VERSION_6);
    version7 = parser.parse(VERSION_7);
    version8 = parser.parse(VERSION_8);
  }
}
