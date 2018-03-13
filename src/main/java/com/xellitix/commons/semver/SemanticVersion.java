package com.xellitix.commons.semver;

import java.io.Serializable;

/**
 * Semantic version model.
 *
 * @author Grayson Kuhns
 */
public interface SemanticVersion extends Serializable {

  /**
   * Gets the major version.
   *
   * @return The major version.
   */
  int getMajorVersion();

  /**
   * Gets the minor version.
   *
   * @return The minor version.
   */
  int getMinorVersion();

  /**
   * Gets the patch version.
   *
   * @return The patch version.
   */
  int getPatchVersion();
}
