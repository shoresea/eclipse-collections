/*
 * Copyright (c) 2015 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.api;

import java.util.Collection;

import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.api.block.function.Function2;
import org.eclipse.collections.api.block.function.primitive.BooleanFunction;
import org.eclipse.collections.api.block.function.primitive.ByteFunction;
import org.eclipse.collections.api.block.function.primitive.CharFunction;
import org.eclipse.collections.api.block.function.primitive.DoubleFunction;
import org.eclipse.collections.api.block.function.primitive.FloatFunction;
import org.eclipse.collections.api.block.function.primitive.IntFunction;
import org.eclipse.collections.api.block.function.primitive.LongFunction;
import org.eclipse.collections.api.block.function.primitive.ShortFunction;
import org.eclipse.collections.api.block.predicate.Predicate;
import org.eclipse.collections.api.block.predicate.Predicate2;
import org.eclipse.collections.api.block.procedure.Procedure;
import org.eclipse.collections.api.tuple.Pair;

/**
 * A LazyIterable is RichIterable which will defer evaluation for certain methods like select, reject, collect, etc.
 * Any methods that do not return a LazyIterable when called will cause evaluation to be forced.
 *
 * @since 1.0
 */
public interface LazyIterable<T>
        extends RichIterable<T>
{
    /**
     * @inheritDoc
     */
    T getFirst();

    /**
     * Creates a deferred iterable for selecting elements from the current iterable.
     */
    LazyIterable<T> select(Predicate<? super T> predicate);

    <P> LazyIterable<T> selectWith(Predicate2<? super T, ? super P> predicate, P parameter);

    <S> LazyIterable<S> selectInstancesOf(Class<S> clazz);

    /**
     * Creates a deferred iterable for rejecting elements from the current iterable.
     */
    LazyIterable<T> reject(Predicate<? super T> predicate);

    <P> LazyIterable<T> rejectWith(Predicate2<? super T, ? super P> predicate, P parameter);

    /**
     * Creates a deferred iterable for collecting elements from the current iterable.
     */
    <V> LazyIterable<V> collect(Function<? super T, ? extends V> function);

    <P, V> LazyIterable<V> collectWith(Function2<? super T, ? super P, ? extends V> function, P parameter);

    /**
     * Creates a deferred iterable for selecting and collecting elements from the current iterable.
     */
    <V> LazyIterable<V> collectIf(Predicate<? super T> predicate, Function<? super T, ? extends V> function);

    /**
     * Creates a deferred take iterable for the current iterable using the specified count as the limit.
     */
    LazyIterable<T> take(int count);

    /**
     * Creates a deferred drop iterable for the current iterable using the specified count as the limit.
     */
    LazyIterable<T> drop(int count);

    /**
     * Creates a deferred distinct iterable to get distinct elements from the current iterable.
     *
     * @since 5.0
     */
    LazyIterable<T> distinct();

    /**
     * Creates a deferred flattening iterable for the current iterable.
     */
    <V> LazyIterable<V> flatCollect(Function<? super T, ? extends Iterable<V>> function);

    /**
     * Creates a deferred iterable that will join this iterable with the specified iterable.
     */
    LazyIterable<T> concatenate(Iterable<T> iterable);

    /**
     * Creates a deferred zip iterable.
     */
    <S> LazyIterable<Pair<T, S>> zip(Iterable<S> that);

    /**
     * Creates a deferred zipWithIndex iterable.
     */
    LazyIterable<Pair<T, Integer>> zipWithIndex();

    /**
     * Creates a deferred chunking iterable.
     */
    LazyIterable<RichIterable<T>> chunk(int size);

    /**
     * Creates a deferred tap iterable.
     */
    LazyIterable<T> tap(Procedure<? super T> procedure);

    /**
     * Iterates over this iterable adding all elements into the target collection.
     */
    <R extends Collection<T>> R into(R target);

    /**
     * Returns a lazy BooleanIterable which will transform the underlying iterable data to boolean values based on the booleanFunction.
     */
    LazyBooleanIterable collectBoolean(BooleanFunction<? super T> booleanFunction);

    /**
     * Returns a lazy ByteIterable which will transform the underlying iterable data to byte values based on the byteFunction.
     */
    LazyByteIterable collectByte(ByteFunction<? super T> byteFunction);

    /**
     * Returns a lazy CharIterable which will transform the underlying iterable data to char values based on the charFunction.
     */
    LazyCharIterable collectChar(CharFunction<? super T> charFunction);

    /**
     * Returns a lazy DoubleIterable which will transform the underlying iterable data to double values based on the doubleFunction.
     */
    LazyDoubleIterable collectDouble(DoubleFunction<? super T> doubleFunction);

    /**
     * Returns a lazy FloatIterable which will transform the underlying iterable data to float values based on the floatFunction.
     */
    LazyFloatIterable collectFloat(FloatFunction<? super T> floatFunction);

    /**
     * Returns a lazy IntIterable which will transform the underlying iterable data to int values based on the intFunction.
     */
    LazyIntIterable collectInt(IntFunction<? super T> intFunction);

    /**
     * Returns a lazy LongIterable which will transform the underlying iterable data to long values based on the longFunction.
     */
    LazyLongIterable collectLong(LongFunction<? super T> longFunction);

    /**
     * Returns a lazy ShortIterable which will transform the underlying iterable data to short values based on the shortFunction.
     */
    LazyShortIterable collectShort(ShortFunction<? super T> shortFunction);
}
