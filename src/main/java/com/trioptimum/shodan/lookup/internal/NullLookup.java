package com.trioptimum.shodan.lookup.internal;

import com.trioptimum.shodan.common.internal.CallablePoint;
import com.trioptimum.shodan.common.service.Function;
import com.trioptimum.shodan.lookup.api.Key;

import java.util.Collections;

public final class NullLookup implements Function<Key, LookupResult> {

	public LookupResult apply(Key key) {
		return new LookupResult(key, Collections.<CallablePoint>emptyList());
	}
}
