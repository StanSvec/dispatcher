package com.trioptimum.shodan.intercept.internal;

import com.trioptimum.shodan.common.internal.ParameterizedCallablePoint;

import java.lang.reflect.Method;
import java.util.List;

public abstract class DispatchContext implements ParameterizedCallablePoint {
	
	protected final ParameterizedCallablePoint callablePoint;

	protected boolean lastDispatch;

	public DispatchContext(ParameterizedCallablePoint callablePoint) {
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

    public boolean isLastDispatch() {
		return lastDispatch;
	}

	public void setLastDispatch(boolean lastDispatch) {
		this.lastDispatch = lastDispatch;
	}
}
