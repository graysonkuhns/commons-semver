package com.xellitix.commons.semver;

import static org.assertj.core.api.Assertions.assertThat;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.Before;
import org.junit.Test;

/**
 * Project acceptance test.
 *
 * @author Grayson Kuhns
 */
public class AcceptanceTest {

  // Fixtures
  private Injector injector;
  private SemanticVersionParser parser;

  @Test
  public void parseVersion__Test() {
    SemanticVersion version = parser.parse("1.0.0-rc.1+x86-64.2");

    assertThat(version
        .getMajorVersion())
        .isEqualTo(1);
    assertThat(version
        .getMinorVersion())
        .isEqualTo(0);
    assertThat(version
        .getPatchVersion())
        .isEqualTo(0);

    assertThat(version
        .getPreReleaseMetadata()
        .get()
        .toString())
        .isEqualTo("rc.1");

    assertThat(version
        .getBuildMetadata()
        .get()
        .toString())
        .isEqualTo("x86-64.2");
  }

  @Test
  public void versionEquality__Test() {
    // Parse version
    SemanticVersion a = parser.parse("1.0.0-rc.1+x86-64.2");

    // Build version
    SemanticVersion b = injector
        .getInstance(SemanticVersionBuilder.class)
        .setMajorVersion(1)
        .addPreReleaseMetadataIdentifier("rc")
        .addPreReleaseMetadataIdentifier(1)
        .addBuildMetadataIdentifier("arm32")
        .addBuildMetadataIdentifier(54L)
        .build();

    assertThat(a).isEqualTo(b);
  }

  @Test
  public void precedence__WithoutMetadata__Test() {
    SemanticVersion a = parser.parse("1.0.0");
    SemanticVersion b = parser.parse("2.0.0");
    SemanticVersion c = parser.parse("2.1.0");
    SemanticVersion d = parser.parse("2.1.1");

    assertThat(a.isLessThan(b)).isTrue();
    assertThat(b.isLessThan(c)).isTrue();
    assertThat(c.isLessThan(d)).isTrue();
  }

  @Test
  public void precedence__WithMetadata__Test() {
    SemanticVersion a = parser.parse("1.0.0-alpha");
    SemanticVersion b = parser.parse("1.0.0-alpha.1");
    SemanticVersion c = parser.parse("1.0.0-alpha.beta");
    SemanticVersion d = parser.parse("1.0.0-beta");
    SemanticVersion e = parser.parse("1.0.0-beta.2");
    SemanticVersion f = parser.parse("1.0.0-beta.11");
    SemanticVersion g = parser.parse("1.0.0-rc.1");
    SemanticVersion h = parser.parse("1.0.0");

    assertThat(a.isLessThan(b)).isTrue();
    assertThat(b.isLessThan(c)).isTrue();
    assertThat(c.isLessThan(d)).isTrue();
    assertThat(d.isLessThan(e)).isTrue();
    assertThat(e.isLessThan(f)).isTrue();
    assertThat(f.isLessThan(g)).isTrue();
    assertThat(g.isLessThan(h)).isTrue();
  }

  @Before
  public void setUp() {
    // Create the Google Guice injector
    injector = Guice.createInjector(new SemanticVersionModule());

    // Create the version parser
    parser = injector.getInstance(SemanticVersionParser.class);
  }
}
