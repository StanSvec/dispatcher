package com.trioptimum.shodan.postproc.internal;

import com.trioptimum.shodan.common.internal.MultiCallingResult;
import com.trioptimum.shodan.common.internal.Return;
import com.trioptimum.shodan.postproc.service.DispatchPostProcessor;

public final class NullDispatchPostProcessor implements DispatchPostProcessor {

	public void postProcess(MultiCallingResult multiCallingResult, Return dispatchReturn) {	/* does nothing */ }
}
