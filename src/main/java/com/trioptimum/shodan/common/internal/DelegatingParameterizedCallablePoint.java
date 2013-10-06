package com.trioptimum.shodan.common.internal;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Default implementation of {@link com.trioptimum.shodan.common.internal.ParameterizedCallablePoint}. The implementation
 * isn't thread safe. The instances are supposed to be confined to a thread.
 */
public final class DelegatingParameterizedCallablePoint implements ParameterizedCallablePoint {

    private final CallablePoint callablePoint;

    private List<Object> parameters;

    public DelegatingParameterizedCallablePoint(CallablePoint callablePoint) {
        this.callablePoint = callablePoint;
    }

    public Method getMethod() {
        return callablePoint.getMethod();
    }

    public Object getInstance() {
        return callablePoint.getInstance();
    }

    /**
     * @return immutable list of parameters
     */
    public List<Object> getParameters() {
        return parameters;
    }

    public DelegatingParameterizedCallablePoint setParameters(Object... parameters) {
        this.parameters = (parameters != null) ? Collections.unmodifiableList(Arrays.asList(parameters.clone())) : Collections.EMPTY_LIST;
        return this;
    }

    public Object call(Object... params) throws Exception {
        return callablePoint.call(params);
    }

    public Object call() throws Exception {
        return callablePoint.call(parameters.toArray());
    }
}
