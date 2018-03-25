package com.xellitix.commons.semver;

import com.google.inject.AbstractModule;
import com.google.inject.assistedinject.FactoryModuleBuilder;

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
    // Semantic version factory
    install(new FactoryModuleBuilder()
        .implement(SemanticVersion.class, DefaultSemanticVersion.class)
        .build(SemanticVersionFactory.class));

    // Semantic version builder
    bind(SemanticVersionBuilder.class).to(DefaultSemanticVersionBuilder.class);

    // Semantic version parser
    bind(SemanticVersionParser.class).to(DefaultSemanticVersionParser.class);
  }
}
