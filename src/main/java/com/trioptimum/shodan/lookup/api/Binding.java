package com.trioptimum.shodan.lookup.api;

import com.trioptimum.shodan.common.internal.CallablePoint;
import com.trioptimum.shodan.common.internal.Util;

/**
 * The binding of a key to a callable point.
 *
 * @author Stan Svec
 * @since 0.1
 *
 */
public final class Binding {

	private final Key key;
	
	private final CallablePoint callablePoint;

	public Binding(Key key, CallablePoint callablePoint) {
		this.key = key;
		this.callablePoint = callablePoint;
	}

	public Key getKey() {
		return key;
	}

	public CallablePoint getCallablePoint() {
		return callablePoint;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Binding b = (Binding) o;

        return Util.equals(key, b.key) && Util.equals(callablePoint, b.callablePoint);
    }

    @Override
    public int hashCode() {
        return Util.hash(key, callablePoint);
    }
}