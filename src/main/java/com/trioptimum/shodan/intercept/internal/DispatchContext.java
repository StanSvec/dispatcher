package com.trioptimum.shodan.intercept.internal;

public final class DispatchContext {
	
	protected boolean lastDispatch;

    public boolean isLastDispatch() {
		return lastDispatch;
	}

	public void setLastDispatch(boolean lastDispatch) {
		this.lastDispatch = lastDispatch;
	}
}
