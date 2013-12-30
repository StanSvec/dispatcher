package com.trioptimum.shodan.extraction.internal;

import com.trioptimum.shodan.common.internal.MultiCallingResult;
import com.trioptimum.shodan.common.internal.Return;
import com.trioptimum.shodan.extraction.service.ReturnExtraction;

public final class SimpleReturnExtraction implements ReturnExtraction {

	public Return apply(MultiCallingResult multiCallingResult) {
        Object ret = multiCallingResult.getReturns().size() == 0 ? null : multiCallingResult.getReturns().get(0).getValue();
		return Return.create(ret);
	}
}
