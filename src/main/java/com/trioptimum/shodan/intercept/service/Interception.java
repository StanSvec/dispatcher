package com.trioptimum.shodan.intercept.service;

import com.trioptimum.shodan.common.internal.ParameterizedCalling;
import com.trioptimum.shodan.intercept.internal.InterceptionContext;

public interface Interception {

	Object intercept(InterceptionContext context, ParameterizedCalling callablePoint) throws Exception;
}
