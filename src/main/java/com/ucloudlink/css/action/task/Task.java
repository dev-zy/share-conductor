package com.ucloudlink.css.action.task;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public class Task {
	/**
	 * 任务类型
	 */
	public final static String TASK_TYPE_SIMPLE = "SIMPLE";
	public final static String TASK_TYPE_DYNAMIC = "DYNAMIC";
	public final static String TASK_TYPE_DECISION = "DECISION";
	public final static String TASK_TYPE_FORK = "FORK";
	public final static String TASK_TYPE_FORK_JOIN_DYNAMIC = "FORK_JOIN_DYNAMIC";
	public final static String TASK_TYPE_JOIN = "JOIN";
	public final static String TASK_TYPE_SUB_WORKFLOW = "SUB_WORKFLOW";
	public final static String TASK_TYPE_EVENT = "EVENT";
	public final static String TASK_TYPE_HTTP = "HTTP";
	
	private String name;
	private String taskReferenceName;
	private String type = TASK_TYPE_SIMPLE;
	private String description;
	private boolean optional = false;
	private Map<String,Object> inputParameters;
	
	public Task() {
	}
	public Task(String type) {
		this.type = type;
	}
	
	public class DynamicTask extends Task {
		private String dynamicTaskNameParam="taskToExecute";
		public DynamicTask() {
			super(TASK_TYPE_DYNAMIC);
		}
	}
	public class DecisionTask extends Task {
		private String caseValueParam="case_value_param";
		
		private Map<String,List<Task>> decisionCases;
		public DecisionTask() {
			super(TASK_TYPE_DECISION);
		}
	}
	public class ForkTask extends Task {
		private List<Task> forkTasks;
		public ForkTask() {
			super(TASK_TYPE_FORK);
		}
	}
	public class JoinTask extends Task {
		private List<String> joinOn;
		public JoinTask() {
			super(TASK_TYPE_JOIN);
		}
	}
	public class SubWorkflowTask extends Task {
		private Map<String,Object> subWorkflowParam;
		public SubWorkflowTask() {
			super(TASK_TYPE_SUB_WORKFLOW);
			subWorkflowParam.put("name", "deployment_workflow");
			subWorkflowParam.put("version", 1);
		}
	}
	/**
	 * {
			  "dynamicTasksInputJSON": {
			    "forkedTask1": {
			      "width": 100,
			      "height": 100,
			      "params": {
			        "recipe": "jpg"
			      }
			    },
			    "forkedTask2": {
			      "width": 200,
			      "height": 200,
			      "params": {
			        "recipe": "jpg"
			      }
			    }
			  },
			  "dynamicTasksJSON": [
			    {
			      "name": "encode_task",
			      "taskReferenceName": "forkedTask1",
			      "type": "SIMPLE"
			    },
			    {
			      "name": "encode_task",
			      "taskReferenceName": "forkedTask2",
			      "type": "SIMPLE"
			    }
			  ]
			}
	 */
	public class DynamicForkTask extends Task {
		private String dynamicForkTasksParam="dynamicTasks";
		private String dynamicForkTasksInputParamName="dynamicTasksInput";
		private Map<String,Object> inputParameters;
		
		public void defaultParam(){
			inputParameters.put("dynamicTasks", "${taskA.output.dynamicTasksJSON}");
			inputParameters.put("dynamicTasksInput", "${taskA.output.dynamicTasksInputJSON}");
		}
		public DynamicForkTask() {
			super(TASK_TYPE_FORK_JOIN_DYNAMIC);
		}
	}
	public class EventTask extends Task {
		public final static String PREFIX_SQS = "sqs:";
		public final static String PREFIX_CONDUCTOR = "conductor:";
		/**
		 * sqs:example_sqs_queue_name
		 * conductor:<workflow_name>:<task_reference_name>
		 */
		private String sink;
		public EventTask() {
			super(TASK_TYPE_EVENT);
		}
	}
	public class HttpTask extends Task {
		public HttpTask() {
			super(TASK_TYPE_HTTP);
		}
		public HttpTask(HttpRequest http_request) {
			super(TASK_TYPE_HTTP);
			inputParameters.put("http_request", http_request);
		}
	}
	public class HttpRequest {
		public final static String METHOD_GET="GET";
		public final static String METHOD_POST="POST";
		public final static String METHOD_PUT="PUT";
		public final static String METHOD_DELETE="DELETE";
		public final static String CONTENT_TYPE_TEXT="text/plain";
		public final static String CONTENT_TYPE_JSON="application/json";
		
		private String method;
		private String url;
		private JSONObject body = new JSONObject();
		private JSONObject headers = new JSONObject();
		
		public HttpRequest() {
			headers.put("Accept", CONTENT_TYPE_JSON);
			headers.put("Content-Type", CONTENT_TYPE_JSON);
		}
	}
}
