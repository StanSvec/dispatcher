package com.trioptimum.shodan.intercept.internal;

import com.trioptimum.shodan.common.internal.ParameterizedCallablePoint;
import com.trioptimum.shodan.intercept.service.Interception;

public final class NullInterception implements Interception {

    public Object intercept(DispatchContext context, ParameterizedCallablePoint callablePoint) throws Exception {
        return callablePoint.call();
    }
}
