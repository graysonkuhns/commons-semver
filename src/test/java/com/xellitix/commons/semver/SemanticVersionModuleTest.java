package com.xellitix.commons.semver;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.Test;

/**
 * {@link SemanticVersionModule} test case.
 *
 * @author Grayson Kuhns
 */
public class SemanticVersionModuleTest {

  // Fixtures
  private final Injector injector = Guice.createInjector(new SemanticVersionModule());

  @Test
  public void provision__SemanticVersionFactory__Test() {
    injector.getInstance(SemanticVersionFactory.class);
  }

  @Test
  public void provision__SemanticVersionBuilder__Test() {
    injector.getInstance(SemanticVersionBuilder.class);
  }

  @Test
  public void provision__SemanticVersionParser__Test() {
    injector.getInstance(SemanticVersionParser.class);
  }
}
