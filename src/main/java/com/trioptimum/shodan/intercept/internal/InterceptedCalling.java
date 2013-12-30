package com.trioptimum.shodan.intercept.internal;

import com.trioptimum.shodan.common.internal.DelegatingParameterizedCalling;
import com.trioptimum.shodan.common.internal.ParameterizedCalling;
import com.trioptimum.shodan.intercept.service.Interception;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public final class InterceptedCalling implements ParameterizedCalling {

	private final Interception interception;
	
	private final InterceptionContext context;

    private final ParameterizedCalling calling;

    public InterceptedCalling(Interception interception, InterceptionContext context, ParameterizedCalling calling) {
		this.interception = interception;
		this.context = context;
        this.calling = calling;
    }

    public Method getMethod() {
        return calling.getMethod();
    }

    public Object getInstance() {
        return calling.getInstance();
    }

    public List<Object> getParameters() {
        return calling.getParameters();
    }

	public Object call() throws Exception {
		return interception.intercept(context, calling);
	}

    public Object call(Object... params) throws Exception {
        return interception.intercept(context, new DelegatingParameterizedCalling(calling, params != null ? Arrays.asList(params) : null));
    }
}
