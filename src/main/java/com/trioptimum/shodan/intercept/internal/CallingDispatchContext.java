package com.trioptimum.shodan.intercept.internal;

import com.trioptimum.shodan.common.internal.ParameterizedCallablePoint;

public final class CallingDispatchContext extends DispatchContext {

	public CallingDispatchContext(ParameterizedCallablePoint callablePoint) {
		super(callablePoint);
	}

	public Object call() throws Exception {
        return callablePoint.call();
    }

    public Object call(Object... params) throws Exception {
        return callablePoint.call(params);
    }
}
