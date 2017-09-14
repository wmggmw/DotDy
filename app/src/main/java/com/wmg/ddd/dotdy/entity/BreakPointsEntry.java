package com.wmg.ddd.dotdy.entity;

/**
 * 中断点
 * @author wu-mingguang
 *
 */
public class BreakPointsEntry {
	/**
	 * 中断点id
	 */
	private String bp_id;
	/**
	 * 中断点起始时间
	 */
	private long bp_start;
	/**
	 * 中断点结束时间
	 */
	private long bp_over;
	/**
	 * 中断原因
	 */
	private String bp_reason;
	/**
	 * 中断恢复状态
	 */
	private int bp_backstatus;
	/**
	 * 中断恢复描述
	 * @return
	 */
	private String bp_backdes;
	
	public String getBpId(){
		return bp_id;
	}
	public void setBpId(String id){
		bp_id = id;
	}
	
	public long getBpStart(){
		return bp_start;
	}
	public void setBpStart(long date){
		bp_start = date;
	}
	
	public long getBpOver(){
		return bp_over;
	}
	public void setBpOver(long date){
		bp_over = date;
	}
	
	public String getBpReason(){
		return bp_reason;
	}
	public void setBpReason(String reason){
		bp_reason = reason;
	}
	
	public int getBpStatus(){
		return bp_backstatus;
	}
	public void setBpStatus(int status){
		bp_backstatus = status;
	}
	
	public String getBpBackdes(){
		return bp_backdes;
	}
	public void setBpBackdes(String backdes){
		bp_backdes = backdes;
	}
}