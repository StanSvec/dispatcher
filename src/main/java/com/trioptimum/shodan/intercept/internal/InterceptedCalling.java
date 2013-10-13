package com.trioptimum.shodan.intercept.internal;

import com.trioptimum.shodan.common.internal.DelegatingParameterizedCalling;
import com.trioptimum.shodan.common.internal.ParameterizedCalling;
import com.trioptimum.shodan.intercept.service.Interception;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public final class InterceptedCalling implements ParameterizedCalling {

	private final Interception interception;
	
	private final DispatchContext context;

    private final ParameterizedCalling callablePoint;

    public InterceptedCalling(Interception interception, DispatchContext context, ParameterizedCalling callablePoint) {
		this.interception = interception;
		this.context = context;
        this.callablePoint = callablePoint;
    }

    public Method getMethod() {
        return callablePoint.getMethod();
    }

    public Object getInstance() {
        return callablePoint.getInstance();
    }

    public List<Object> getParameters() {
        return callablePoint.getParameters();
    }

	public Object call() throws Exception {
		return interception.intercept(context, callablePoint);
	}

    public Object call(Object... params) throws Exception {
        return interception.intercept(context, new DelegatingParameterizedCalling(callablePoint, params != null ? Arrays.asList(params) : null));
    }
}
