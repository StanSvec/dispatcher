package com.trioptimum.shodan.intercept.api;

import com.trioptimum.shodan.common.internal.ParameterizedCallablePoint;
import com.trioptimum.shodan.intercept.internal.DispatchContext;
import com.trioptimum.shodan.intercept.internal.InterceptedCallablePoint;
import com.trioptimum.shodan.intercept.service.Interception;
import com.trioptimum.shodan.intercept.service.InterceptionRule;

import java.util.*;

public final class InterceptionByRule implements Interception {

	private final List<InterceptionRule> interceptionRules;

    public InterceptionByRule(Collection<? extends InterceptionRule> rules) {
        this.interceptionRules = new ArrayList<InterceptionRule>(rules);
    }

	public Object intercept(DispatchContext context, ParameterizedCallablePoint callablePoint) throws Exception {
        ParameterizedCallablePoint current = callablePoint;
		for (ListIterator<InterceptionRule> it = interceptionRules.listIterator(interceptionRules.size()); it.hasPrevious();) {
			InterceptionRule rule = it.previous();
			if (rule.getDestinationMatcher().matches(callablePoint)) {
				current = new InterceptedCallablePoint(rule.getInterception(), context, current);
			}
		}
		
		return current.call();
	}
}
