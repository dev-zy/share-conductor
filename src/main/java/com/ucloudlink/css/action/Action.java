package com.ucloudlink.css.action;

import com.alibaba.fastjson.JSONObject;

public class Action {
	public final static String ACTION_START_WORKFLOW = "start_workflow";
	public final static String ACTION_COMPLETE_TASK = "complete_task";
	public final static String ACTION_FAIL_TASK = "fail_task";
	private String action;
	public Action(String action) {
		this.action = action;
	}
	public class TaskParam {
		private String workflowId;
		private String taskRefName;
		private Param output;
		public class Param{
			private Object response;
		}
	}
	public class StartWorkflow extends Action{
		private Param start_workflow;
		public StartWorkflow() {
			super(ACTION_START_WORKFLOW);
		}
		public class Param{
			private String name;
			private int version;
			private JSONObject input;
		}
	}
	public class CompleteTask extends Action{
		private TaskParam complete_task;
		private boolean expandInlineJSON=true;
		public CompleteTask() {
			super(ACTION_COMPLETE_TASK);
		}
	}
	public class FailTask extends Action{
		private TaskParam fail_task;
		private boolean expandInlineJSON=true;
		public FailTask() {
			super(ACTION_FAIL_TASK);
		}
		public FailTask(TaskParam fail_task,boolean expandInlineJSON) {
			super(ACTION_FAIL_TASK);
			this.fail_task = fail_task;
			this.expandInlineJSON = expandInlineJSON;
		}
	}
}
