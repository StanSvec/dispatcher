package com.trioptimum.shodan.common.internal;

import java.util.Arrays;
import java.util.Collection;

/**
 * The utility class.
 *
 * @author Stan Svec
 * @since 0.1
 */
public class Util {

	private Util() {}
	
	public static boolean nullOrEmpty(Collection<?> tested) {
		return ((tested == null) || tested.isEmpty());
	}
	
	public static boolean equals(Object a, Object b) {
        return ((a == b) || (a != null && a.equals(b)));
    }
	
	public static int hash(Object... objects) {
		return Arrays.hashCode(objects);
	}

    public static <T> T firstNotNull(T t1, T t2) {
        return (t1 != null) ? t1 : t2;
    }

    public static Exception launderThrowable(Throwable throwable) {
        if (throwable instanceof Exception) {
            return  (Exception) throwable;
        } else if (throwable instanceof Error) {
            throw (Error) throwable;
        } else {
            throw new RuntimeException("Unsupported throwable subtype", throwable);
        }
    }
}
