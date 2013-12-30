package com.trioptimum.shodan.intercept.api;

import com.trioptimum.shodan.common.internal.ParameterizedCalling;
import com.trioptimum.shodan.intercept.internal.InterceptionContext;
import com.trioptimum.shodan.intercept.internal.InterceptedCalling;
import com.trioptimum.shodan.intercept.service.Interception;
import com.trioptimum.shodan.intercept.service.InterceptionRule;

import java.util.*;

public final class InterceptionByRule implements Interception {

	private final List<InterceptionRule> interceptionRules;

    public InterceptionByRule(Collection<? extends InterceptionRule> rules) {
        this.interceptionRules = new ArrayList<InterceptionRule>(rules);
    }

	public Object intercept(InterceptionContext context, ParameterizedCalling callablePoint) throws Exception {
        ParameterizedCalling current = callablePoint;
		for (ListIterator<InterceptionRule> it = interceptionRules.listIterator(interceptionRules.size()); it.hasPrevious();) {
			InterceptionRule rule = it.previous();
			if (rule.getDestinationMatcher().matches(callablePoint)) {
				current = new InterceptedCalling(rule.getInterception(), context, current);
			}
		}
		
		return current.call();
	}
}
