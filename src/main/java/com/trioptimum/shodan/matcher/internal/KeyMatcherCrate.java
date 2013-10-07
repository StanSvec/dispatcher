package com.trioptimum.shodan.matcher.internal;

import com.trioptimum.shodan.lookup.api.Key;
import com.trioptimum.shodan.matcher.service.Matcher;

public class KeyMatcherCrate implements KeyCheckRule {

	protected final Matcher<? super Key> keyMatcher;
	
	public KeyMatcherCrate(Matcher<? super Key> keyMatcher) {
		this.keyMatcher = keyMatcher;
	}
	
	public Matcher<? super Key> getKeyMatcher() {
		return keyMatcher;
	}
}
