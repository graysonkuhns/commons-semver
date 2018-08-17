package com.xellitix.commons.semver.metadata;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Base {@link Metadata} implementation.
 *
 * @author Grayson Kuhns
 */
public class DefaultMetadata implements Metadata {

  // Properties
  private final List<Identifier> identifiers;

  @Inject
  public DefaultMetadata(@Assisted final List<Identifier> identifiers) {
    // Make the identifiers read-only
    this.identifiers = Collections.unmodifiableList(identifiers);
  }

  @Override
  public int compareTo(final Metadata other) {
    // We will only compare identifiers to the max length of both identifier lists
    int endIndex = min(size(), other.size());

    // Compare available identifiers
    for (int i = 0; i < endIndex; i++) {
      // Get the identifiers to compare
      Identifier thisId = get(i);
      Identifier otherId = other.get(i);

      // Compare the identifiers
      int comparison = thisId.compareTo(otherId);

      // If the identifiers are not equal then we have determined which metadata takes precedence
      if (comparison != 0) {
        return comparison;
      }
    }

    // The available identifiers are equal, compare lists by length
    // The longer identifier list takes precedence
    long thisSize = size();
    long otherSize = other.size();

    if (thisSize > otherSize) {
      return 1;
    } else if (thisSize < otherSize) {
      return -1;
    } else {
      return 0;
    }
  }

  @Override
  public String toString() {
    return identifiers
        .stream()
        .map(Identifier::getValue)
        .collect(Collectors.joining("."));
  }

  @Override
  public int size() {
    return identifiers.size();
  }

  @Override
  public boolean isEmpty() {
    return identifiers.isEmpty();
  }

  @Override
  public boolean contains(final Object o) {
    return identifiers.contains(o);
  }

  @Override
  public Iterator<Identifier> iterator() {
    return identifiers.iterator();
  }

  @Override
  public Object[] toArray() {
    return identifiers.toArray();
  }

  @Override
  public <T> T[] toArray(T[] ts) {
    return identifiers.toArray(ts);
  }

  @Override
  public boolean add(final Identifier identifier) {
    return identifiers.add(identifier);
  }

  @Override
  public boolean remove(final Object o) {
    return identifiers.remove(o);
  }

  @Override
  public boolean containsAll(final Collection<?> collection) {
    return identifiers.containsAll(collection);
  }

  @Override
  public boolean addAll(final Collection<? extends Identifier> collection) {
    return identifiers.addAll(collection);
  }

  @Override
  public boolean addAll(int i, Collection<? extends Identifier> collection) {
    return identifiers.addAll(i, collection);
  }

  @Override
  public boolean removeAll(Collection<?> collection) {
    return identifiers.removeAll(collection);
  }

  @Override
  public boolean retainAll(Collection<?> collection) {
    return identifiers.retainAll(collection);
  }

  @Override
  public void clear() {
    identifiers.clear();
  }

  @Override
  public Identifier get(int i) {
    return identifiers.get(i);
  }

  @Override
  public Identifier set(int i, Identifier identifier) {
    return identifiers.set(i, identifier);
  }

  @Override
  public void add(int i, Identifier identifier) {
    identifiers.add(i, identifier);
  }

  @Override
  public Identifier remove(int i) {
    return identifiers.remove(i);
  }

  @Override
  public int indexOf(Object o) {
    return identifiers.indexOf(o);
  }

  @Override
  public int lastIndexOf(Object o) {
    return identifiers.lastIndexOf(o);
  }

  @Override
  public ListIterator<Identifier> listIterator() {
    return identifiers.listIterator();
  }

  @Override
  public ListIterator<Identifier> listIterator(int i) {
    return identifiers.listIterator(i);
  }

  @Override
  public List<Identifier> subList(int i, int i1) {
    return identifiers.subList(i, i1);
  }

  @Override
  public void replaceAll(UnaryOperator<Identifier> operator) {
    identifiers.replaceAll(operator);
  }

  @Override
  public void sort(Comparator<? super Identifier> c) {
    identifiers.sort(c);
  }

  @Override
  public Spliterator<Identifier> spliterator() {
    return identifiers.spliterator();
  }

  @Override
  public boolean removeIf(Predicate<? super Identifier> filter) {
    return identifiers.removeIf(filter);
  }

  @Override
  public Stream<Identifier> stream() {
    return identifiers.stream();
  }

  @Override
  public Stream<Identifier> parallelStream() {
    return identifiers.parallelStream();
  }

  @Override
  public void forEach(Consumer<? super Identifier> action) {
    identifiers.forEach(action);
  }

  private int min(final int one, final int two) {
    if (one < two) {
      return one;
    } else {
      return two;
    }
  }
}
