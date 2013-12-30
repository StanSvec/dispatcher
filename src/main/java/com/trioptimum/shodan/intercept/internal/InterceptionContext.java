package com.trioptimum.shodan.intercept.internal;

public final class InterceptionContext {
	
	private boolean interrupted;

    public boolean isInterrupted() {
		return interrupted;
	}

	public void interrupt() {
		this.interrupted = true;
	}
}
