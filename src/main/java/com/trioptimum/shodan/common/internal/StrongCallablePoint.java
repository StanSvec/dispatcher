package com.trioptimum.shodan.common.internal;

import java.lang.reflect.Method;

public final class StrongCallablePoint implements CallablePoint {

	private final Method method;

    private final Object instance;

    private final int hash;

	public StrongCallablePoint(Method method, Object instance) {
        this.method = method;
        this.instance = instance;
        this.hash = Util.hash(method, instance);
    }

    public Method getMethod() {
		return method;
	}

	public Object getInstance() {
		return instance;
	}

    @Override
    public int hashCode() {
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        return Util.callablePointEquals(this, obj);
    }

    @Override
    public String toString() {
        return Util.callablePointToString(this);
    }
}
