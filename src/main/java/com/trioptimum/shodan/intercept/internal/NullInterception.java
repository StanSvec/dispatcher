package com.trioptimum.shodan.intercept.internal;

import com.trioptimum.shodan.common.internal.ParameterizedCalling;
import com.trioptimum.shodan.intercept.service.Interception;

public final class NullInterception implements Interception {

    public Object intercept(InterceptionContext context, ParameterizedCalling callablePoint) throws Exception {
        return callablePoint.call();
    }
}
