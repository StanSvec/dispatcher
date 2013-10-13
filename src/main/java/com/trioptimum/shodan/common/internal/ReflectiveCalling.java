package com.trioptimum.shodan.common.internal;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class ReflectiveCalling implements Calling {

    private final CallablePoint cp;

    public ReflectiveCalling(CallablePoint callablePoint) {
        this.cp = callablePoint;
    }

    public Method getMethod() {
        return cp.getMethod();
    }

    public Object getInstance() {
        return cp.getInstance();
    }

    public Object call(Object... params) throws Exception {
		try {
			return cp.getMethod().invoke(cp.getInstance(), params);
		} catch (InvocationTargetException e) {
            throw Util.launderThrowable(e.getCause());
		}
	}
}
