package com.xellitix.commons.semver.metadata;

import com.google.inject.AbstractModule;
import com.google.inject.assistedinject.FactoryModuleBuilder;

/**
 * {@link Metadata} Google Guice module.
 *
 * @author Grayson Kuhns
 */
public class MetadataModule extends AbstractModule {

  /**
   * Configures the module.
   */
  @Override
  protected void configure() {
    // Identifier factory
    install(new FactoryModuleBuilder()
      .implement(Identifier.class, DefaultIdentifier.class)
      .build(IdentifierFactory.class));
  }
}
