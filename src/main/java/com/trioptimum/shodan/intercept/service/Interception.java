package com.trioptimum.shodan.intercept.service;

import com.trioptimum.shodan.common.internal.ParameterizedCalling;
import com.trioptimum.shodan.intercept.internal.DispatchContext;

public interface Interception {

	Object intercept(DispatchContext context, ParameterizedCalling callablePoint) throws Exception;
}
