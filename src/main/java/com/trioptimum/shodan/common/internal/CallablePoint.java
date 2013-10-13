package com.trioptimum.shodan.common.internal;

import java.lang.reflect.Method;

/**
 * The callable point represents a method of specific instance which may be called. The way how is the method execution
 * actually performed after a call is implementation specific. An implementation may perform additional steps
 * within method call.
 *
 * @author Stan Svec
 * @since 0.1
 *
 */
public interface CallablePoint {

	Method getMethod();

	Object getInstance();
}