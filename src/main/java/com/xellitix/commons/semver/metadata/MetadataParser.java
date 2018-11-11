package com.xellitix.commons.semver.metadata;

/**
 * {@link Metadata} parser.
 *
 * @author Grayson Kuhns
 */
public interface MetadataParser {

  /**
   * Parses {@link Metadata}.
   *
   * @param metadata The metadata to parse.
   * @return The {@link Metadata}.
   */
  Metadata parse(String metadata);
}
