package com.devzy.share.api.response;

import com.alibaba.fastjson.JSONObject;
import com.devzy.share.api.TaskApiConstant;

public class PollTaskResponse {
	private String taskType;//task_1
	private String referenceTaskName;//task_1
	private String taskDefName;//task_1
	private String status = TaskApiConstant.STATUS_IN_PROGRESS;
	private int retryCount;
	private int seq;
	private int pollCount;
	private long scheduledTime;
	private long startTime;
	private long endTime;
	private long updateTime;
	private int startDelayInSeconds;
	private boolean retried = false;
	private boolean callbackFromWorker = true;
	private long responseTimeoutSeconds;//3600
	private String workflowInstanceId;
	private String taskId;
	private long callbackAfterSeconds;//3600
	private long polledTime;
	private long queueWaitTime;
	private JSONObject inputData = new JSONObject();
}
