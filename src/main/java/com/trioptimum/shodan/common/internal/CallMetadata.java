package com.trioptimum.shodan.common.internal;

import java.lang.annotation.Annotation;

/**
 * The additional information about executed call.
 *
 * @author Stan Svec
 * @since 0.1
 */
public class CallMetadata {

    private final Class<?> source;

    private final Annotation[] markers;

    CallMetadata(Class<?> source, Annotation[] markers) {
        this.source = source;
        this.markers = markers;
    }

    public static CallMetadata createNullObject() {
        return new CallMetadata(null, new Annotation[0]);
    }

    public Class<?> getSource() {
        return source;
    }

    public Annotation[] getMarkers() {
        return markers;
    }
}
