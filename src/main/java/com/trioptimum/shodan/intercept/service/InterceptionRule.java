package com.trioptimum.shodan.intercept.service;

import com.trioptimum.shodan.matcher.internal.DestinationCheckRule;

public interface InterceptionRule extends DestinationCheckRule {

	Interception getInterception();
}
