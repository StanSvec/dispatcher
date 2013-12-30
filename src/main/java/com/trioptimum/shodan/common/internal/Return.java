package com.trioptimum.shodan.common.internal;

public final class Return {

	private final Object value;

	private final Exception exception;

    private Return(Object value, Exception exception) {
        this.value = value;
        this.exception = exception;
    }

    public static Return create(Object value) {
        return new Return(value, null);
    }

    public static Return createExceptional(Exception exception) {
        return new Return(null, exception);
    }

	public Object getValue() {
		return value;
	}

	public Exception getException() {
		return exception;
	}

	public boolean isExceptional() {
		return (exception != null);
	}
}
