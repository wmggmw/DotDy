package com.wmg.ddd.dotdy.entity;

import com.wmg.ddd.dotdy.entity.base.AbsGoalEntry;
import com.wmg.ddd.dotdy.entity.base.BaseEntry;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Transient;

import java.util.ArrayList;
import java.util.List;

/**
 * 单个目标数据
 * @author wu-mingguang
 *
 */
@Entity
public class GoalEntry extends AbsGoalEntry {
	
	/**
	 * 中断点集
	 */
	@Transient
	private List<BreakPointsEntry> goal_bps;
	/**
	 * 中断点数
	 */
	@Property
	private int goal_bps_count;
	/**
	 * 中断点最大时长
	 */
	@Property
	private long goal_bp_longest;
	/**
	 * 目标分步是否有效
	 */
	@Property
	private boolean goal_steps_valid;
	/**
	 * 有效目标分步，最大为5
	 */
	@Property
	private int goal_steps_count;
	/**
	 * 目标分步
	 */
	@Transient
	private List<TaskEntry> goal_steps;

	public GoalEntry(){
		goal_bp_longest = -1;
		goal_steps_count = 0;
		goal_bps = new ArrayList<BreakPointsEntry>();
		goal_steps = new ArrayList<TaskEntry>();
		goal_steps_valid = false;
	}

	@Generated(hash = 924273232)
	public GoalEntry(int goal_bps_count, long goal_bp_longest,
									boolean goal_steps_valid, int goal_steps_count) {
					this.goal_bps_count = goal_bps_count;
					this.goal_bp_longest = goal_bp_longest;
					this.goal_steps_valid = goal_steps_valid;
					this.goal_steps_count = goal_steps_count;
	}
	
	/**
	 * 获得中断点集
	 * @return
	 */
	public List<BreakPointsEntry> getBreakPoints(){
		return goal_bps;
	}
	/**
	 * 增加中断点
	 * @param bp
	 * @return
	 */
	public boolean addBreakPoint(BreakPointsEntry bp){
		if( bp == null)
			return false;
		if(goal_bps != null){
			goal_bps.add(bp);
			setgoalBpLongest(bp);
			setgoalBpsCount(goal_bps.size());
			return true;
		}
		return false;
	}
	
	/**
	 * 获得中断点数
	 * @return
	 */
	public int getgoalBpsCount(){
		return goal_bps_count;
	}
	/**
	 * 设置中断点数
	 * @param count
	 */
	public void setgoalBpsCount(int count){
		goal_bps_count = count;
	}
	
	/**
	 * 获得任务中断最长时间（单位minute）
	 * @return
	 */
	public long getgoalBpLongest(){
		return goal_bp_longest;
	}
	/**
	 * 设置任务最长中断时间（单位minute）
	 */
	public void setgoalBpLongest(BreakPointsEntry bp){
		long dValue = bp.getBpOver()-bp.getBpOver();
		goal_bp_longest = goal_bp_longest > dValue?goal_bp_longest:dValue;
	}
	
	/**
	 * 获得任务分步是否有效
	 * @return
	 */
	public boolean getgoalStepsValid(){
		return goal_steps_valid;
	}
	/**
	 * 设置任务分步有效
	 * @param b
	 */
	public void setgoalStepsValid(boolean b){
		goal_steps_valid = b;
	}
	
	/**
	 * 获得任务分步集
	 * @return
	 */
	public List<TaskEntry> getgoalSteps(){
		return goal_steps;
	}
	/**
	 * 增加任务分步（最多增加5步）
	 * @param ts
	 * @return
	 */
	public boolean addgoalStep(TaskEntry ts){
		if( !goal_steps_valid)
			return false; 
		if( ts == null)
			return false;
		if(goal_steps_count<5 && goal_steps!=null){
			goal_steps.add(ts);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int compareTo(BaseEntry baseEntry) {
		return 0;
	}

	public int getGoal_bps_count() {
					return this.goal_bps_count;
	}

	public void setGoal_bps_count(int goal_bps_count) {
					this.goal_bps_count = goal_bps_count;
	}

	public long getGoal_bp_longest() {
					return this.goal_bp_longest;
	}

	public void setGoal_bp_longest(long goal_bp_longest) {
					this.goal_bp_longest = goal_bp_longest;
	}

	public boolean getGoal_steps_valid() {
					return this.goal_steps_valid;
	}

	public void setGoal_steps_valid(boolean goal_steps_valid) {
					this.goal_steps_valid = goal_steps_valid;
	}

	public int getGoal_steps_count() {
					return this.goal_steps_count;
	}

	public void setGoal_steps_count(int goal_steps_count) {
					this.goal_steps_count = goal_steps_count;
	}
}