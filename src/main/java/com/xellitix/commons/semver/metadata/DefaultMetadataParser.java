package com.xellitix.commons.semver.metadata;

import com.google.inject.Inject;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Default {@link MetadataParser} implementation.
 *
 * @author Grayson Kuhns
 */
public class DefaultMetadataParser implements MetadataParser {

  // Dependencies
  private final IdentifierFactory identifierFactory;
  private final MetadataFactory metadataFactory;

  /**
   * Constructor.
   *
   * @param identifierFactory The {@link IdentifierFactory}.
   * @param metadataFactory The {@link MetadataFactory}.
   */
  @Inject
  DefaultMetadataParser(
      final IdentifierFactory identifierFactory,
      final MetadataFactory metadataFactory) {

    this.identifierFactory = identifierFactory;
    this.metadataFactory = metadataFactory;
  }

  /**
   * Parses {@link Metadata}.
   *
   * @param metadata The metadata to parse.
   * @return The {@link Metadata}.
   */
  @Override
  public Metadata parse(final String metadata) {
    List<Identifier> identifiers = Arrays.stream(metadata
        .trim()
        .split("\\."))
        .filter(Objects::nonNull)
        .filter(id -> !id.isEmpty())
        .map(identifierFactory::create)
        .collect(Collectors.toList());

    // null represents no metadata
    if (identifiers.size() == 0) {
      return null;
    }

    return metadataFactory.create(identifiers);
  }
}
