package com.trioptimum.shodan.common.internal;

/**
 * Created by trtles on 10/7/13.
 */
public interface Calling extends CallablePoint {

    Object call(Object... params) throws Exception;
}
