package com.goebuy.entity.event;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.goebuy.entity.BaseEntity;
import com.goebuy.entity.user.Merchant;
import com.goebuy.entity.user.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 *  短信表
 * @author Administrator
 *
 */
@Entity
@Table(name = "message", indexes={@Index(name="index_merchant", columnList="merchant_id")}, schema = "springdemo",  catalog = "")
@ApiModel(description = "短信表")
public class Message extends BaseEntity<Integer> {


	private static final long serialVersionUID = -8345501396288538950L;
	
	/**
	 * 创建人id，唯一
	 */
	@ApiModelProperty(value = "创建人")
	private Merchant creator;
	
	/** 发送时间 */
	@ApiModelProperty(value = "发送时间")
	private String createTime;
	
	/** 目标用户 */
	@ApiModelProperty(value = "目标用户")
	private List<User> toUsers;
	
	/** 短信内容，最多390字 */
	@ApiModelProperty(value = "短信内容，最多390字")
	private String content;
	
	/** 目标人数 */
	@ApiModelProperty(value = "目标人数")
	private int toCount;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="merchant_id")
	public Merchant getCreator() {
		return creator;
	}

	public void setCreator(Merchant creator) {
		this.creator = creator;
	}

	@Basic
	@Column(name = "create_time", nullable = true)
	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="user_id")
	public List<User> getToUsers() {
		return toUsers;
	}

	public void setToUsers(List<User> toUsers) {
		this.toUsers = toUsers;
	}

	@Basic
	@Column(name = "content", nullable = false)
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	@Basic
	@Column(name = "to_count", nullable = true)
	public int getToCount() {
		return toCount;
	}

	public void setToCount(int toCount) {
		this.toCount = toCount;
	}

}
