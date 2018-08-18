package com.xellitix.commons.semver.metadata;

/**
 * {@link Metadata} validator.
 *
 * @author Grayson Kuhns
 */
public interface MetadataValidator {

  /**
   * Checks if {@link Metadata} is valid.
   *
   * @param metadata The {@link Metadata}.
   * @return True if the {@link Metadata} is valid.
   */
  boolean isValid(Metadata metadata);
}
