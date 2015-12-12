/*
 * Copyright (c) 2015 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.set.sorted.immutable;

import java.util.Comparator;
import java.util.SortedSet;

import org.eclipse.collections.api.factory.set.sorted.ImmutableSortedSetFactory;
import org.eclipse.collections.api.set.sorted.ImmutableSortedSet;
import org.eclipse.collections.impl.utility.Iterate;
import net.jcip.annotations.Immutable;

@Immutable
public final class ImmutableSortedSetFactoryImpl implements ImmutableSortedSetFactory
{
    public <T> ImmutableSortedSet<T> empty()
    {
        return (ImmutableSortedSet<T>) ImmutableEmptySortedSet.INSTANCE;
    }

    public <T> ImmutableSortedSet<T> empty(Comparator<? super T> comparator)
    {
        return new ImmutableEmptySortedSet<T>(comparator);
    }

    public <T> ImmutableSortedSet<T> of()
    {
        return this.empty();
    }

    public <T> ImmutableSortedSet<T> with()
    {
        return this.empty();
    }

    public <T> ImmutableSortedSet<T> of(T... items)
    {
        return this.with(items);
    }

    public <T> ImmutableSortedSet<T> with(T... items)
    {
        if (items == null || items.length == 0)
        {
            return this.of();
        }

        return ImmutableTreeSet.newSetWith(items);
    }

    public <T> ImmutableSortedSet<T> ofAll(Iterable<? extends T> items)
    {
        return this.withAll(items);
    }

    public <T> ImmutableSortedSet<T> withAll(Iterable<? extends T> items)
    {
        if (items instanceof ImmutableSortedSet<?>)
        {
            return (ImmutableSortedSet<T>) items;
        }

        return this.of((T[]) Iterate.toArray(items));
    }

    public <T> ImmutableSortedSet<T> of(Comparator<? super T> comparator)
    {
        return this.with(comparator);
    }

    public <T> ImmutableSortedSet<T> with(Comparator<? super T> comparator)
    {
        if (comparator == null)
        {
            return this.of();
        }
        return new ImmutableEmptySortedSet<T>(comparator);
    }

    public <T> ImmutableSortedSet<T> of(Comparator<? super T> comparator, T... items)
    {
        return this.with(comparator, items);
    }

    public <T> ImmutableSortedSet<T> with(Comparator<? super T> comparator, T... items)
    {
        if (items == null || items.length == 0)
        {
            return this.of(comparator);
        }

        return ImmutableTreeSet.newSetWith(comparator, items);
    }

    public <T> ImmutableSortedSet<T> ofAll(Comparator<? super T> comparator, Iterable<? extends T> items)
    {
        return this.withAll(comparator, items);
    }

    public <T> ImmutableSortedSet<T> withAll(Comparator<? super T> comparator, Iterable<? extends T> items)
    {
        return this.of(comparator, (T[]) Iterate.toArray(items));
    }

    public <T> ImmutableSortedSet<T> ofSortedSet(SortedSet<T> set)
    {
        return this.withSortedSet(set);
    }

    public <T> ImmutableSortedSet<T> withSortedSet(SortedSet<T> set)
    {
        if (set instanceof ImmutableSortedSet)
        {
            return (ImmutableSortedSet<T>) set;
        }
        if (set.isEmpty())
        {
            return this.of(set.comparator());
        }
        return ImmutableTreeSet.newSet(set);
    }
}
