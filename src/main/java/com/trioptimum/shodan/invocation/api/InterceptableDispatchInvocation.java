package com.trioptimum.shodan.invocation.api;

import com.trioptimum.shodan.common.internal.DispatchResult;
import com.trioptimum.shodan.common.internal.ParameterizedCalling;
import com.trioptimum.shodan.common.internal.Return;
import com.trioptimum.shodan.intercept.internal.DispatchContext;
import com.trioptimum.shodan.intercept.internal.NullInterception;
import com.trioptimum.shodan.intercept.service.Interception;
import com.trioptimum.shodan.invocation.service.DispatchInvocation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class InterceptableDispatchInvocation implements DispatchInvocation {

	private final Interception interception;

    public InterceptableDispatchInvocation() {
        this(new NullInterception());
    }

    public InterceptableDispatchInvocation(Interception interception) {
		this.interception = interception;
	}
	
	public DispatchResult invokeAll(Collection<? extends ParameterizedCalling> callablePoints) {
		List<Return> returns = new ArrayList<Return>(callablePoints.size());
        DispatchContext context = new DispatchContext();
        for (ParameterizedCalling pcp : callablePoints) {
            Object retval = null;
            Exception ex = null;
			try {
				retval = interception.intercept(context, pcp);
			} catch (Exception e) {
				ex = e;
			}
			
			Return ret;
			if (ex == null) {
				ret = new Return(retval);
			} else {
				ret = new Return(ex);
			}
			returns.add(ret);
			
			if (context.isLastDispatch()) {
				break;
			}
		}
		
		return new DispatchResult(returns);
	}
}
