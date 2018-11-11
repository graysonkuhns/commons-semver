package com.xellitix.commons.semver.metadata;

import java.io.Serializable;
import java.util.List;

/**
 * Metadata.
 *
 * @author Grayson Kuhns
 */
public interface Metadata extends Serializable, List<Identifier>, Comparable<Metadata> {
}
