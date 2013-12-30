package com.trioptimum.shodan.intercept.api;

import com.trioptimum.shodan.common.internal.MultiCallingResult;
import com.trioptimum.shodan.common.internal.ParameterizedCalling;
import com.trioptimum.shodan.common.internal.Return;
import com.trioptimum.shodan.intercept.internal.InterceptionContext;
import com.trioptimum.shodan.intercept.internal.NullInterception;
import com.trioptimum.shodan.intercept.service.Interception;
import com.trioptimum.shodan.common.internal.MultiCalling;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class InterceptableMultiCalling implements MultiCalling {

	private final Interception interception;

    public InterceptableMultiCalling() {
        this(new NullInterception());
    }

    public InterceptableMultiCalling(Interception interception) {
		this.interception = interception;
	}
	
	public MultiCallingResult callAll(Collection<? extends ParameterizedCalling> calling) {
		List<Return> returns = new ArrayList<Return>(calling.size());
        InterceptionContext context = new InterceptionContext();
        for (ParameterizedCalling pcp : calling) {
            Object retval = null;
            Exception ex = null;
			try {
				retval = interception.intercept(context, pcp);
			} catch (Exception e) {
				ex = e;
			}

			returns.add((ex == null) ? Return.create(retval) : Return.createExceptional(ex));
			if (context.isInterrupted()) {
				break;
			}
		}
		
		return new MultiCallingResult(returns);
	}
}
