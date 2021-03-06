/**
 * Copyright (c) 2016, All Contributors (see CONTRIBUTORS file)
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.eventsourcing.queries;


import com.eventsourcing.Entity;
import com.eventsourcing.EntityHandle;
import com.eventsourcing.index.EntityIndex;
import com.googlecode.cqengine.query.Query;

public class Max<O extends Entity, A extends Comparable<A>> extends ComparingQuery<O, A>  {

    public Max(EntityIndex<O, A> index) {
        super(index);
    }

    @Override protected boolean isBetterValue(A value, A targetValue) {
        return value.compareTo(targetValue) > 0;
    }

    @Override
    public String toString() {
        return "max(" + asLiteral(attribute.getAttributeName()) + ")";
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Max)) return false;

        Max max = (Max) o;

        if (!attribute.equals(max.attribute)) return false;

        return true;
    }

}
