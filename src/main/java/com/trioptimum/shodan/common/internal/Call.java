package com.trioptimum.shodan.common.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * The class represents information about executed call. The call can contains metadata.
 *
 * @author Stan Svec
 * @since 0.1
 *
 */
public final class Call {

	private final CallablePoint target;

	private final List<Object> parameters;

    private final CallMetadata metadata;

    public Call(CallablePoint target, Object[] parameters, CallMetadata metadata) {
        this(target, Arrays.asList(parameters), metadata);
    }

    public Call(CallablePoint target, List<?> parameters, CallMetadata metadata) {
        this.target = target;
        this.parameters = (parameters != null) ? Collections.unmodifiableList(new ArrayList<Object>(parameters)) : Collections.EMPTY_LIST;
        this.metadata = Util.firstNotNull(metadata, CallMetadata.createNullObject());
    }

	public CallablePoint getTarget() {
		return target;
	}
	
	public List<Object> getParameters() {
		return parameters;
	}

    public CallMetadata getMetadata() {
        return metadata;
    }
}
