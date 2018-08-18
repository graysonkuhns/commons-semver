package com.xellitix.commons.semver.metadata;

import java.util.List;

/**
 * {@link Metadata} Factory.
 *
 * @author Grayson Kuhns
 */
public interface MetadataFactory {

  /**
   * Creates {@link Metadata}.
   *
   * @param identifiers The {@link Identifier}s.
   * @return The {@link Metadata}.
   */
  Metadata create(List<Identifier> identifiers);
}
