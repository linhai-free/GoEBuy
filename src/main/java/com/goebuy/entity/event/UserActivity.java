package com.goebuy.entity.event;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 用户-活动表
 * @author Administrator
 */
@Entity
@Table(name = "user_activity", schema = "springdemo", indexes={@Index(name="index_activity_id", columnList="activity_id"),  @Index(name="index_user_id", columnList="user_id")}, catalog = "")
@ApiModel(description = "用户-活动表")
public class UserActivity extends BaseUserEventEntity<Integer> {

	private static final long serialVersionUID = -1144737462440938677L;

	/** 活动id */
	@ApiModelProperty(value = "活动id")
	private Activity activity;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="activity_id")
	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}
	
}
