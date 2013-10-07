package com.trioptimum.shodan.intercept.internal;

import com.trioptimum.shodan.intercept.service.Interception;

public final class InterceptedDispatchContext extends DispatchContext {

	private final Interception interception;
	
	private final DispatchContext context;
	
	public InterceptedDispatchContext(Interception interception, DispatchContext context) {
		super(context);
		this.interception = interception;
		this.context = context;
	}

	public Object call() throws Exception {
		return interception.intercept(context);
	}

    public Object call(Object... params) throws Exception {
        return null;
    }
}
