package com.xellitix.commons.semver.metadata;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.Test;

/**
 * {@link MetadataModule} test case.
 *
 * @author Grayson Kuhns
 */
public class MetadataModuleTest {

  // Fixtures
  private final Injector injector = Guice.createInjector(new MetadataModule());

  @Test
  public void provision__IdentifierFactory__Test() {
    injector.getInstance(IdentifierFactory.class);
  }
}
