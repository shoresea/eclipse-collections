/*
 * Copyright (c) 2015 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.api.multimap.set;

import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.api.block.function.Function2;
import org.eclipse.collections.api.block.predicate.Predicate2;
import org.eclipse.collections.api.multimap.ImmutableMultimap;
import org.eclipse.collections.api.multimap.bag.ImmutableBagIterableMultimap;
import org.eclipse.collections.api.set.ImmutableSetIterable;
import org.eclipse.collections.api.tuple.Pair;

/**
 * @since 6.0
 */
public interface ImmutableSetIterableMultimap<K, V>
        extends SetMultimap<K, V>, ImmutableMultimap<K, V>
{
    ImmutableSetIterable<V> get(K key);

    ImmutableSetIterableMultimap<K, V> newEmpty();

    ImmutableSetIterableMultimap<K, V> newWith(K key, V value);

    ImmutableSetIterableMultimap<K, V> newWithout(Object key, Object value);

    ImmutableSetIterableMultimap<K, V> newWithAll(K key, Iterable<? extends V> values);

    ImmutableSetIterableMultimap<K, V> newWithoutAll(Object key);

    ImmutableSetIterableMultimap<V, K> flip();

    ImmutableSetIterableMultimap<K, V> selectKeysValues(Predicate2<? super K, ? super V> predicate);

    ImmutableSetIterableMultimap<K, V> rejectKeysValues(Predicate2<? super K, ? super V> predicate);

    ImmutableSetIterableMultimap<K, V> selectKeysMultiValues(Predicate2<? super K, ? super Iterable<V>> predicate);

    ImmutableSetIterableMultimap<K, V> rejectKeysMultiValues(Predicate2<? super K, ? super Iterable<V>> predicate);

    <K2, V2> ImmutableBagIterableMultimap<K2, V2> collectKeysValues(Function2<? super K, ? super V, Pair<K2, V2>> function);

    <V2> ImmutableMultimap<K, V2> collectValues(Function<? super V, ? extends V2> function);
}
