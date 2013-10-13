package com.trioptimum.shodan.common.internal;

import com.trioptimum.shodan.common.service.Function;

/**
 * Created by trtles on 10/13/13.
 */
public class ReflectiveCallingFactory implements Function<CallablePoint, Calling> {

    public Calling apply(CallablePoint cp) {
        return new ReflectiveCalling(cp);
    }
}
