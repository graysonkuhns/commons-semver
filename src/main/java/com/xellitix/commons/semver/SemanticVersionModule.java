package com.xellitix.commons.semver;

import com.google.inject.AbstractModule;
import com.google.inject.assistedinject.FactoryModuleBuilder;
import com.xellitix.commons.semver.metadata.MetadataModule;

/**
 * {@link SemanticVersion} Google Guice module.
 *
 * @author Grayson Kuhns
 */
public class SemanticVersionModule extends AbstractModule {

  /**
   * Configures the module.
   */
  @Override
  protected void configure() {
    // Install the metadata module
    install(new MetadataModule());

    // Semantic version factory
    bind(SemanticVersionFactory.class).to(DefaultSemanticVersionFactory.class);

    // Semantic version builder
    bind(SemanticVersionBuilder.class).to(DefaultSemanticVersionBuilder.class);

    // Semantic version parser
    bind(SemanticVersionParser.class).to(DefaultSemanticVersionParser.class);
  }
}
