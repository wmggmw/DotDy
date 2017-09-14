package com.wmg.ddd.dotdy.entity.base;

import org.greenrobot.greendao.annotation.Property;

public abstract class AbsGoalEntry extends BaseEntry {

	/**
	 * 目标预计耗时
	 */
	@Property
	private int goal_cost_estimated;
	/**
	 * 目标已经耗时
	 */
	@Property
	private int goal_cost_already;
	/**
	 * 目标剩余时间
	 */
	@Property
	private int goal_cost_left;
	/**
	 * 目标额外耗时
	 */
	@Property
	private int goal_cost_extra;

	public int getGoal_cost_estimated() {
		return goal_cost_estimated;
	}

	public void setGoal_cost_estimated(int goal_cost_estimated) {
		this.goal_cost_estimated = goal_cost_estimated;
	}

	public int getGoal_cost_already() {
		return goal_cost_already;
	}

	public void setGoal_cost_already(int goal_cost_already) {
		this.goal_cost_already = goal_cost_already;
	}

	public int getGoal_cost_left() {
		return goal_cost_left;
	}

	public void setGoal_cost_left(int goal_cost_left) {
		this.goal_cost_left = goal_cost_left;
	}

	public int getGoal_cost_extra() {
		return goal_cost_extra;
	}

	public void setGoal_cost_extra(int goal_cost_extra) {
		this.goal_cost_extra = goal_cost_extra;
	}
}