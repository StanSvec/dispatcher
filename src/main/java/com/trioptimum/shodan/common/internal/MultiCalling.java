package com.trioptimum.shodan.common.internal;

import java.util.Collection;

public interface MultiCalling {

	MultiCallingResult callAll(Collection<? extends ParameterizedCalling> calling);
}
