package com.trioptimum.shodan.common.internal;

import java.util.List;
import java.util.concurrent.Callable;

/**
 * Created by trtles on 10/6/13.
 */
public interface ParameterizedCallablePoint extends CallablePoint, Callable<Object> {

    List<Object> getParameters();

    ParameterizedCallablePoint setParameters(Object... parameters);
}
