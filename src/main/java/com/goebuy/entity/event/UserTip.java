package com.goebuy.entity.event;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.goebuy.entity.BaseEntity;
import com.goebuy.entity.Order;
import com.goebuy.entity.user.User;
import io.swagger.annotations.ApiModelProperty;

/**
 * 用户-打赏表
 * @author Administrator
 *
 */
@Entity
@Table(name = "user_tip", indexes={@Index(name="index_user", columnList="user_id")}, schema = "springdemo",  catalog = "")
public class UserTip extends BaseEntity<Integer> {
	private static final long serialVersionUID = 8685619633799829922L;

	/** 打赏id */
	@ApiModelProperty(value = "打赏id")
	private Tip tip;
	
	/** 打赏评论 */
	private String remark;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="tip_id", nullable=false)
	public Tip getTip() {
		return tip;
	}

	public void setTip(Tip tip) {
		this.tip = tip;
	}
	
	@Basic
	@Column(name = "remark",  nullable = true)
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
