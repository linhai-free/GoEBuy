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
import com.goebuy.entity.user.Merchant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 标签表(用户标签与活动标签统一)
 * @author Administrator
 */
@Entity
@Table(name = "tag", indexes={@Index(name="index_merchant", columnList="merchant_id"), @Index(name="index_name", columnList="name"),  @Index(name="index_is_common", columnList="is_common") }, schema = "springdemo",  catalog = "")
@ApiModel(description = "标签表(用户标签与活动标签统一)")
public class Tag extends BaseEntity<Integer> {

	private static final long serialVersionUID = -498561889458454959L;

	/** 标签名称, 最多8个字 */
	@ApiModelProperty(value = "标签名称, 最多8个字")
	private String name;

	/** 创建人 */
	@ApiModelProperty(value = "创建人")
	private Merchant creator;

	/** 创建时间 */
	@ApiModelProperty(value = "创建时间")
	private String createTime;
	
	/** 是否是通用标签 , 默认为否 */
	@ApiModelProperty(value = " 是否是通用标签 , 默认为否")
	private boolean isCommon = false;
	
	@Basic
	@Column(name = "name", length=8, nullable = true)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
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
	
	@Basic
	@Column(name = "is_common", nullable = true)
	public boolean isCommon() {
		return isCommon;
	}

	public void setCommon(boolean isCommon) {
		this.isCommon = isCommon;
	}

}
