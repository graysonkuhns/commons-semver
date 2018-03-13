package com.xellitix.commons.semver;

import com.google.inject.assistedinject.Assisted;

/**
 * {@link SemanticVersion} factory.
 *
 * @author Grayson Kuhns
 */
public interface SemanticVersionFactory {

  /**
   * Creates a {@link SemanticVersion}.
   *
   * @param major The major version.
   * @param minor The minor version.
   * @param patch The patch version.
   * @return The {@link SemanticVersion}.
   */
  SemanticVersion create(@Assisted("major") int major,
                         @Assisted("minor") int minor,
                         @Assisted("patch") int patch);
}
