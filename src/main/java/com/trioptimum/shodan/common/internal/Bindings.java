package com.trioptimum.shodan.common.internal;

import com.trioptimum.shodan.lookup.api.Key;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The callablePoint of a key to the list of callable points.
 *
 * @author Stan Svec
 * @since 0.1
 *
 */
public final class Bindings {

	private final Key key;
	
	private final List<CallablePoint> callablePoints;

	public Bindings(Key key, List<CallablePoint> callablePoints) {
		this.key = key;
		this.callablePoints = Collections.unmodifiableList(new ArrayList<CallablePoint>(callablePoints));
	}
	
	public Key getKey() {
		return key;
	}
	
	public List<CallablePoint> getCallablePoints() {
		return callablePoints;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bindings b = (Bindings) o;

        return Util.equals(key, b.key) && Util.equals(callablePoints, b.callablePoints);
    }

    @Override
    public int hashCode() {
        return Util.hash(key, callablePoints);
    }
}
