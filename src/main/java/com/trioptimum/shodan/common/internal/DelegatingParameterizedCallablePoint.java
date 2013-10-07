package com.trioptimum.shodan.common.internal;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Default implementation of {@link com.trioptimum.shodan.common.internal.ParameterizedCallablePoint}.
 */
public final class DelegatingParameterizedCallablePoint implements ParameterizedCallablePoint {

    private final CallablePoint callablePoint;

    private final List<Object> parameters;

    public DelegatingParameterizedCallablePoint(CallablePoint callablePoint, List<?> parameters) {
        this.callablePoint = callablePoint;
        this.parameters = (parameters != null) ? Collections.unmodifiableList(new ArrayList<Object>(parameters)) : Collections.emptyList();
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

    public Object call(Object... params) throws Exception {
        return callablePoint.call(params);
    }

    public Object call() throws Exception {
        return callablePoint.call(parameters.toArray());
    }
}
