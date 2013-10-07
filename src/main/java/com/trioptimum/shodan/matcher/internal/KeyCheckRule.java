package com.trioptimum.shodan.matcher.internal;

import com.trioptimum.shodan.lookup.api.Key;
import com.trioptimum.shodan.matcher.service.Matcher;

public interface KeyCheckRule {

	Matcher<? super Key> getKeyMatcher();
}
