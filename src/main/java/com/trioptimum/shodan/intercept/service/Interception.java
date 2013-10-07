package com.trioptimum.shodan.intercept.service;

import com.trioptimum.shodan.common.internal.ParameterizedCallablePoint;
import com.trioptimum.shodan.intercept.internal.DispatchContext;

public interface Interception {

	Object intercept(DispatchContext context, ParameterizedCallablePoint callablePoint) throws Exception;
}
