package com.wmg.ddd.dotdy.entity.base;

public abstract class AbsTaskEntry extends BaseEntry{

	/**
	 * 任务预计耗时
	 */
	private int task_cost_estimated;
	/**
	 * 任务已经耗时
	 */
	private int task_cost_already;
	/**
	 * 任务剩余时间
	 */
	private int task_cost_left;
	/**
	 * 任务额外耗时
	 */
	private int task_cost_extra;

	public int getTask_cost_estimated() {
		return task_cost_estimated;
	}

	public void setTask_cost_estimated(int task_cost_estimated) {
		this.task_cost_estimated = task_cost_estimated;
	}

	public int getTask_cost_already() {
		return task_cost_already;
	}

	public void setTask_cost_already(int task_cost_already) {
		this.task_cost_already = task_cost_already;
	}

	public int getTask_cost_left() {
		return task_cost_left;
	}

	public void setTask_cost_left(int task_cost_left) {
		this.task_cost_left = task_cost_left;
	}

	public int getTask_cost_extra() {
		return task_cost_extra;
	}

	public void setTask_cost_extra(int task_cost_extra) {
		this.task_cost_extra = task_cost_extra;
	}
}