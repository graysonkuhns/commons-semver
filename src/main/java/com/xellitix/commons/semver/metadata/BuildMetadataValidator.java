package com.xellitix.commons.semver.metadata;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * Build {@link MetadataValidator}.
 *
 * @author Grayson Kuhns
 */
@Singleton
public class BuildMetadataValidator
    extends SimpleMetadataValidator
    implements MetadataValidator {

  /**
   * Constructor.
   *
   * @param identifierValidator The {@link BuildMetadataIdentifierValidator}.
   */
  @Inject
  public BuildMetadataValidator(final BuildMetadataIdentifierValidator identifierValidator) {
    super(identifierValidator);
  }
}
