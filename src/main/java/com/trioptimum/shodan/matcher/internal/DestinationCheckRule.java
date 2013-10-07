package com.trioptimum.shodan.matcher.internal;

import com.trioptimum.shodan.common.internal.CallablePoint;
import com.trioptimum.shodan.matcher.service.Matcher;

public interface DestinationCheckRule {

	Matcher<? super CallablePoint> getDestinationMatcher();
}
