package com.trioptimum.shodan.dispatch.api;

import com.trioptimum.shodan.common.internal.*;
import com.trioptimum.shodan.common.service.Function;
import com.trioptimum.shodan.dispatch.internal.DispatchByServices;
import com.trioptimum.shodan.dispatch.service.Dispatch;
import com.trioptimum.shodan.common.internal.MultiCalling;
import com.trioptimum.shodan.lookup.api.Key;
import com.trioptimum.shodan.lookup.internal.LookupResult;
import com.trioptimum.shodan.postproc.service.DispatchPostProcessor;

public final class DispatchBuilder {

	private Function<Key, LookupResult> lookup;

    private Function<CallablePoint, Calling> callingFactory;

	private MultiCalling invocation;

	private Function<MultiCallingResult, Return> returnExtraction;

	private DispatchPostProcessor postProcessor;

	public DispatchBuilder setLookup(Function<Key, LookupResult> lookup) {
		this.lookup = lookup;
		return this;
	}

    public DispatchBuilder setCallingFactory(Function<CallablePoint, Calling> callingFactory) {
        this.callingFactory = callingFactory;
        return this;
    }

	public DispatchBuilder setInvocation(MultiCalling invocation) {
		this.invocation = invocation;
		return this;
	}

	public DispatchBuilder setReturnExtraction(Function<MultiCallingResult, Return> returnExtraction) {
		this.returnExtraction = returnExtraction;
		return this;
	}

	public DispatchBuilder setPostProcessor(DispatchPostProcessor postProcessor) {
		this.postProcessor = postProcessor;
		return this;
	}

	public Dispatch build() {
		return new DispatchByServices(lookup, callingFactory, invocation, returnExtraction, postProcessor);
	}
}
