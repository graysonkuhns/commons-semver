package com.xellitix.commons.semver.metadata;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyList;
import static org.mockito.Matchers.anyListOf;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;

/**
 * {@link DefaultMetadataParser} test case.
 *
 * @author Grayson Kuhns
 */
public class DefaultMetadataParserTest {

  // Constants
  private static final String ID_A = "A";
  private static final String ID_B = "B";
  private static final String ID_2 = "2";

  // Captors
  @Captor
  public ArgumentCaptor<List> identifiersCaptor = ArgumentCaptor.forClass(List.class);

  // Fixtures
  private Identifier idA;
  private Identifier idB;
  private Identifier id2;
  private IdentifierFactory identifierFactory;

  private Metadata metadata;
  private MetadataFactory metadataFactory;

  private DefaultMetadataParser metadataParser;

  @Test
  public void parse__Test() {
    assertThat((Object) metadataParser
        .parse("..A.B.2."))
        .isNotNull();

    verify(metadataFactory).create(identifiersCaptor.capture());
    List<Identifier> identifiers = identifiersCaptor.getValue();

    assertThat(identifiers
        .size())
        .isEqualTo(3);

    assertThat(identifiers).contains(idA);
    assertThat(identifiers).contains(idB);
    assertThat(identifiers).contains(id2);
  }

  @Before
  public void setUp() {
    // Mock identifiers
    idA = mock(Identifier.class);
    idB = mock(Identifier.class);
    id2 = mock(Identifier.class);

    // Mock identifier factory
    identifierFactory = mock(IdentifierFactory.class);
    doReturn(idA)
        .when(identifierFactory)
        .create(eq(ID_A));
    doReturn(idB)
        .when(identifierFactory)
        .create(eq(ID_B));
    doReturn(id2)
        .when(identifierFactory)
        .create(eq(ID_2));

    // Metadata factory mocking
    metadata = mock(Metadata.class);
    metadataFactory = mock(MetadataFactory.class);
    doReturn(metadata)
        .when(metadataFactory)
        .create(anyListOf(Identifier.class));

    // Create the parser
    metadataParser = new DefaultMetadataParser(identifierFactory, metadataFactory);
  }
}
