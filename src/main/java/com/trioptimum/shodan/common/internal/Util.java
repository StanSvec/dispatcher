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

    public static boolean callablePointEquals(CallablePoint cp, Object obj) {
        if (cp == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj instanceof CallablePoint) {
            CallablePoint other = (CallablePoint) obj;
            return cp.getInstance() == other.getInstance()
                    && Util.equals(cp.getMethod(), other.getMethod());
        }

        return false;
    }

    public static String callablePointToString(CallablePoint cp) {
        return cp.getClass().getSimpleName() + " {" +
                "method=" + cp.getMethod() +
                ", instance=" + cp.getInstance() +
                '}';
    }
}
