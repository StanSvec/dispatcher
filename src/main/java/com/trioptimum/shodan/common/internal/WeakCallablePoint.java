package com.trioptimum.shodan.common.internal;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;

public final class WeakCallablePoint extends WeakReference<Object> implements CallablePoint {

	private final Method method;

	private final int hash;

	public WeakCallablePoint(Method method, Object instance, ReferenceQueue<Object> queue) {
		super(instance, queue);
		this.method = method;
		this.hash = Util.hash(method, instance);
	}
	
	public Method getMethod() {
		return method;
	}

	public Object getInstance() {
		return super.get();
	}

    public StrongCallablePoint createStrong() {
        Object instance = getInstance();
        return (instance != null) ? new StrongCallablePoint(method, instance) : null;
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
