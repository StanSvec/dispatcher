package com.trioptimum.shodan.intercept.api;

import com.trioptimum.shodan.common.internal.ParameterizedCalling;
import com.trioptimum.shodan.intercept.internal.DispatchContext;
import com.trioptimum.shodan.intercept.service.Interception;

/**
 * Created with IntelliJ IDEA.
 * User: Turtles
 * Date: 15.12.12
 * Time: 18:43
 * To change this template use File | Settings | File Templates.
 */
public class NullForMissingParams implements Interception {

    public Object intercept(DispatchContext context, ParameterizedCalling callablePoint) throws Exception {
        Object[] nulls = new Object[callablePoint.getMethod().getParameterTypes().length];
        // TODO implement
        return callablePoint.call(nulls);
    }
}
