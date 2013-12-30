package com.trioptimum.shodan.postproc.service;

import com.trioptimum.shodan.common.internal.MultiCallingResult;
import com.trioptimum.shodan.common.internal.Return;

public interface DispatchPostProcessor {

	void postProcess(MultiCallingResult multiCallingResult, Return dispatchReturn);
}
