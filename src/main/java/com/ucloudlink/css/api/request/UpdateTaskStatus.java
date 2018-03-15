package com.ucloudlink.css.api.request;

import com.alibaba.fastjson.JSONObject;
import com.ucloudlink.css.api.TaskApiConstant;

public class UpdateTaskStatus {
	private String workflowInstanceId;
	private String taskId;
	private String status = TaskApiConstant.STATUS_IN_PROGRESS;
	/**
	 * "output": {
        "mod": 5,
        "taskToExecute": "task_1",
        "oddEven": 0,
        "dynamicTasks": [
            {
                "name": "task_1",
                "taskReferenceName": "task_1_1",
                "type": "SIMPLE"
            },
            {
                "name": "sub_workflow_4",
                "taskReferenceName": "wf_dyn",
                "type": "SUB_WORKFLOW",
                "subWorkflowParam": {
                    "name": "sub_flow_1"
                }
            }
        ],
        "inputs": {
            "task_1_1": {},
            "wf_dyn": {}
        }
    }
	 */
	private JSONObject output = new JSONObject();
}
