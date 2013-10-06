package com.trioptimum.shodan.common.internal;

import java.lang.reflect.Method;

/**
 * Implements data for {@link com.trioptimum.shodan.common.internal.CallablePoint} implementations. The hashcode, equals
 * and toString methods are intended to be common for all implementation. Therefore do not add any data properties in
 * the subclasses. That way the subclasses stay immutable.
 *
 * @author Stan Svec
 * @since 0.1
 *
 */
public abstract class AbstractCallablePoint implements CallablePoint {

	public abstract Object call(Object... params) throws Exception;
	
	protected final Method method;

	protected final Object instance;
	
	protected final int hash;

	public AbstractCallablePoint(Method method, Object instance) {
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
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (obj instanceof CallablePoint) {
			CallablePoint other = (CallablePoint) obj;
			return instance == other.getInstance()
				   && Util.equals(method, other.getMethod());
		}
		
		return false;
	}

    @Override
    public String toString() {
        return getClass().getSimpleName() + " {" +
                "method=" + method +
                ", instance=" + instance +
                '}';
    }
}