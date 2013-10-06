package com.trioptimum.shodan.common.internal;

import java.lang.ref.ReferenceQueue;
import java.lang.reflect.Method;

public class WeakReflectiveCallablePoint extends WeakCallablePoint {

	public WeakReflectiveCallablePoint(Method method, Object instance, ReferenceQueue<Object> queue) {
		super(method, instance, queue);
	}

	@Override
	protected Object callSafely(Object instance, Object... params) throws Exception {
		return new ReflectiveCallablePoint(method, instance).call(params);
	}
	
	public CallablePoint createStrong() {
		Object instance = getInstance();
		return (instance != null) ? new ReflectiveCallablePoint(method, instance) : null;
	}
}
