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

    // Metadata factory
    install(new FactoryModuleBuilder()
        .implement(Metadata.class, DefaultMetadata.class)
        .build(MetadataFactory.class));

    // Metadata parser
    bind(MetadataParser.class).to(DefaultMetadataParser.class);
  }
}
