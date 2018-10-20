package com.goebuy.entity.event;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

/**
 * 报名表
 * @author Administrator
 *
 */
@Entity
@Table(name = "entry_form",indexes={@Index(name="index_merchant", columnList="merchant_id"), @Index(name="index_name", columnList="name")},  schema = "springdemo",  catalog = "")
@ApiModel(description = "报名表")
public class EntryForm extends BaseEventEntity<Integer> {

	private static final long serialVersionUID = 9010868247836235386L;

	/**
	 * 报名时间
	 */

	/** 报名开始日期 */
	@ApiModelProperty(value = "开始日期", example = "2018-03-15")
	private String enrollStartDate;

	/** 报名开始时间 */
	@ApiModelProperty(value = "开始时间", example = "00:01")
	private String enrollStartTime;

	/** 报名结束日期 */
	@ApiModelProperty(value = "结束日期", example = "2018-10-14")
	private String enrollEndDate;

	/** 报名结束时间 */
	@ApiModelProperty(value = "结束时间", example = "23:59")
	private String enrollEndTime;

	/**
	 * 售票信息(票务设置)
	 */

	/** 售票类型：0 免费，1 收费（可设置多种票）*/
	@ApiModelProperty(value = "售票类型：0 免费，1 收费（可设置多种票）", example = "0")
	private int ticketType;

	/** 报名限制 : 0 不限制， 1 每人限报一次 */
	@ApiModelProperty(value = "报名限制 : 0 不限制， 1 每人限报一次", example = "0")
	private int enrollType;

	/** 余票显示 */
	@ApiModelProperty(value = "余票显示", example = "true")
	private boolean showLeftTicket = true;
	
	/** 人数限制：-1 代表不限制，正数代表限制X人，默认-1 */
	@ApiModelProperty(value = "人数限制：-1 代表不限制，正数代表限制X人，默认-1", example = "-1")
	private int maxCnt = -1;
	
	/** 是否需要审核 */
	@ApiModelProperty(value = "是否需要审核", example = "false")
	private boolean needVerify = false;
	
	/**	仅限会员 */
	@ApiModelProperty(value = "仅限会员", example = "false")
	private boolean needVip = false;
	
	@Basic
	@Column(name = "enroll_start_date", nullable = true)
	public String getEnrollStartDate() {
		return enrollStartDate;
	}

	public void setEnrollStartDate(String enroll_start_date) {
		this.enrollStartDate = enroll_start_date;
	}

	@Basic
	@Column(name = "enroll_start_time", nullable = true)
	public String getEnrollStartTime() {
		return enrollStartTime;
	}

	public void setEnrollStartTime(String enroll_start_time) {
		this.enrollStartTime = enroll_start_time;
	}

	@Basic
	@Column(name = "enroll_end_date", nullable = true)
	public String getEnrollEndDate() {
		return enrollEndDate;
	}

	public void setEnrollEndDate(String enroll_end_date) {
		this.enrollEndDate = enroll_end_date;
	}

	@Basic
	@Column(name = "enroll_end_time", nullable = true)
	public String getEnrollEndTime() {
		return enrollEndTime;
	}

	public void setEnrollEndTime(String enroll_end_time) {
		this.enrollEndTime = enroll_end_time;
	}
	
	@Basic
	@Column(name = "ticket_type", nullable = true)
	public int getTicketType() {
		return ticketType;
	}

	public void setTicketType(int ticketType) {
		this.ticketType = ticketType;
	}

	@Basic
	@Column(name = "enroll_type", nullable = true)
	public int getEnrollType() {
		return enrollType;
	}

	public void setEnrollType(int enrollType) {
		this.enrollType = enrollType;
	}

	@Basic
	@Column(name = "show_left_ticket", nullable = true)
	public boolean isShowLeftTicket() {
		return showLeftTicket;
	}

	public void setShowLeftTicket(boolean showLeftTicket) {
		this.showLeftTicket = showLeftTicket;
	}

	@Basic
	@Column(name = "max_cnt", nullable = true)
	public int getMaxCnt() {
		return maxCnt;
	}

	public void setMaxCnt(int maxCnt) {
		this.maxCnt = maxCnt;
	}

	@Basic
	@Column(name = "need_verify", nullable = true)
	public boolean isNeedVerify() {
		return needVerify;
	}

	public void setNeedVerify(boolean needVerify) {
		this.needVerify = needVerify;
	}

	@Basic
	@Column(name = "need_vip", nullable = true)
	public boolean isNeedVip() {
		return needVip;
	}

	public void setNeedVip(boolean needVip) {
		this.needVip = needVip;
	}

}
