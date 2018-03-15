package com.ucloudlink.css.action.metadata;

import java.util.List;
import java.util.Map;

import com.ucloudlink.css.action.task.Task;

public class WorkflowDef {
	private String name;
	private String description;
	private int version;
	private List<Task> tasks;
	private int schemaVersion;
	private Map<String,Object> inputParameters;
	private Map<String,Object> outputParameters;
}
