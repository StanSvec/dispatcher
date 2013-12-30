package com.trioptimum.shodan.dispatch.internal;

import com.trioptimum.shodan.common.internal.*;
import com.trioptimum.shodan.common.service.Function;
import com.trioptimum.shodan.dispatch.service.DispatchOrchestration;
import com.trioptimum.shodan.extraction.internal.SimpleReturnExtraction;
import com.trioptimum.shodan.intercept.api.InterceptableMultiCalling;
import com.trioptimum.shodan.common.internal.MultiCalling;
import com.trioptimum.shodan.lookup.api.Key;
import com.trioptimum.shodan.lookup.internal.LookupResult;
import com.trioptimum.shodan.lookup.internal.NullLookup;
import com.trioptimum.shodan.postproc.internal.NullDispatchPostProcessor;
import com.trioptimum.shodan.postproc.service.DispatchPostProcessor;

import java.util.Collection;

public final class DispatchByServices extends DispatchOrchestration {

    private final Function<Key, LookupResult> lookup;

    private final Function<CallablePoint, Calling> callingFactory;

    private final MultiCalling invocation;

    private final Function<MultiCallingResult, Return> returnExtraction;

    private final DispatchPostProcessor postProcessor;

    public DispatchByServices(Function<Key, LookupResult> lookup, Function<CallablePoint, Calling> callingFactory, MultiCalling invocation,
                              Function<MultiCallingResult, Return> returnExtraction, DispatchPostProcessor postProcessor) {
        this.lookup = 		    ((lookup != null) ? lookup : new NullLookup());
        this.callingFactory =   ((callingFactory != null) ? callingFactory : new ReflectiveCallingFactory());
        this.invocation =       ((invocation != null) ? invocation : new InterceptableMultiCalling());
        this.returnExtraction = ((returnExtraction != null) ? returnExtraction : new SimpleReturnExtraction());
        this.postProcessor =    ((postProcessor != null) ? postProcessor : new NullDispatchPostProcessor());
    }

    public LookupResult find(Key key) {
        return lookup.apply(key);
    }

    @Override
    protected Calling createCalling(CallablePoint callablePoint) {
        return callingFactory.apply(callablePoint);
    }

    @Override
    public MultiCallingResult invokeAll(Collection<? extends ParameterizedCalling> bindings) {
        return invocation.callAll(bindings);
    }

    @Override
    public Return extractReturn(MultiCallingResult multiCallingResult) {
        return returnExtraction.apply(multiCallingResult);
    }

    @Override
    public void postProcess(MultiCallingResult multiCallingResult, Return dispatchReturn) {
        postProcessor.postProcess(multiCallingResult, dispatchReturn);
    }
}
