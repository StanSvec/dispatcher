package com.trioptimum.shodan.dispatch.service;

import com.trioptimum.shodan.common.internal.*;
import com.trioptimum.shodan.lookup.api.Key;
import com.trioptimum.shodan.lookup.internal.LookupResult;

import java.util.*;

public abstract class DispatchOrchestration implements Dispatch {

    protected abstract LookupResult find(Key key);

    protected abstract Calling createCalling(CallablePoint callablePoint);

    protected abstract MultiCallingResult invokeAll(Collection<? extends ParameterizedCalling> bindings);
	
	protected abstract Return extractReturn(MultiCallingResult multiCallingResult);
	
	protected void postProcess(MultiCallingResult multiCallingResult, Return dispatchReturn) { /* empty */ }
	
	protected Object doReturn(Return ret) throws Exception {
		if (ret.isExceptional()) {
			throw ret.getException();
		} else {
			return ret.getValue();
		}
	}
	
	public Object dispatch(Key key, Object... params) throws Exception {
        List<CallablePoint> cps = find(key).getCallablePoints();
        List<ParameterizedCalling> pcps = new ArrayList<ParameterizedCalling>(cps.size());
        for (CallablePoint cp : cps) {
            pcps.add(new DelegatingParameterizedCalling(createCalling(cp), (params != null) ? Arrays.asList(params) : null));
        }

        return dispatchFound(pcps);
    }

    public Object dispatchFound(Collection<? extends ParameterizedCalling> callings) throws Exception {
        MultiCallingResult res = invokeAll(callings);
        Return ret = extractReturn(res);
        postProcess(res, ret);
        return doReturn(ret);
    }
}
