package com.netflix.dyno.connectionpool;


public interface RetryPolicy {
    /**
     * Operation is starting
     */
    void begin();

    /**
     * Operation has completed successfully
     */
    void success();

    /**
     * Operation has failed
     */
    void failure(Exception e);

    /**
     * Ask the policy if a retry is allowed. This may internally sleep
     * 
     * @return
     */
    boolean allowRetry();

    /**
     * Return the number of attempts since begin was called
     * 
     * @return
     */
    int getAttemptCount();
    
    public static interface RetryPolicyFactory {
    	public RetryPolicy getRetryPolicy();
    }
}