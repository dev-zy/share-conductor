package com.devzy.share.action.metadata;

public class TaskDef {
	/**
	 * 超时策略
	 */
	public static String TIMEOUT_POLICY_RETRY="RETRY";//Retries the task again
	public static String TIMEOUT_POLICY_TIME_OUT_WF="TIME_OUT_WF";//Workflow is marked as TIMED_OUT and terminated
	public static String TIMEOUT_POLICY_ALERT_ONLY="ALERT_ONLY";//Registers a counter (task_timeout)
	/**
	 * 重试策略
	 */
	public static String RETRY_LOGIC_FIXED="FIXED";//Reschedule the task after the retryDelaySeconds
	public static String RETRY_LOGIC_EXPONENTIAL_BACKOFF="EXPONENTIAL_BACKOFF";//Reschedule after retryDelaySeconds  * retryCount
	
	private String name;
	private int retryCount=0;
	private long timeoutSeconds;
	private String[] inputKeys={"sourceRequestId","qcElementType"};
	private String[] outputKeys={"state", "skipped", "result"};
	private String timeoutPolicy=TIMEOUT_POLICY_TIME_OUT_WF;//RETRY | TIME_OUT_WF |ALERT_ONLY 
	private String retryLogic=RETRY_LOGIC_FIXED;//EXPONENTIAL_BACKOFF | FIXED
	private long retryDelaySeconds;
	private long responseTimeoutSeconds;
}
