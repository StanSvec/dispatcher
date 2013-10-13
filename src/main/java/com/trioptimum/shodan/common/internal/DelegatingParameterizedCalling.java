package com.trioptimum.shodan.common.internal;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Default implementation of {@link ParameterizedCalling}.
 */
public final class DelegatingParameterizedCalling implements ParameterizedCalling {

    private final Calling calling;

    private final List<Object> parameters;

    public DelegatingParameterizedCalling(Calling calling, List<?> parameters) {
        this.calling = calling;
        this.parameters = (parameters != null) ? Collections.unmodifiableList(new ArrayList<Object>(parameters)) : Collections.emptyList();
    }

    public Method getMethod() {
        return calling.getMethod();
    }

    public Object getInstance() {
        return calling.getInstance();
    }

    /**
     * @return immutable list of parameters
     */
    public List<Object> getParameters() {
        return parameters;
    }

    public Object call(Object... params) throws Exception {
        return calling.call(params);
    }

    public Object call() throws Exception {
        return calling.call(parameters.toArray());
    }
}
