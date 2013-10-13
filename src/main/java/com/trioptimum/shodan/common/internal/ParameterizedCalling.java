package com.trioptimum.shodan.common.internal;

import java.util.List;
import java.util.concurrent.Callable;

/**
 * Created by trtles on 10/6/13.
 */
public interface ParameterizedCalling extends Calling, Callable<Object> {

    List<Object> getParameters();
}
