package com.trioptimum.shodan.common.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class MultiCallingResult {

	private final List<Return> returns;

	public MultiCallingResult(List<Return> returns) {
        this.returns = Collections.unmodifiableList(new ArrayList<Return>(returns));
    }

	public List<Return> getReturns() {
		return returns;
	}
}
