package com.xellitix.commons.semver.metadata;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * Pre-release {@link MetadataValidator}.
 *
 * @author Grayson Kuhns
 */
@Singleton
public class PreReleaseMetadataValidator
    extends SimpleMetadataValidator
    implements MetadataValidator {

  /**
   * Constructor.
   *
   * @param identifierValidator The {@link PreReleaseMetadataIdentifierValidator}.
   */
  @Inject
  public PreReleaseMetadataValidator(
      final PreReleaseMetadataIdentifierValidator identifierValidator) {

    super(identifierValidator);
  }
}
