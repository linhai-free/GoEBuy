package com.goebuy.entity.event;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

/**
 * 问卷表
 * @author Administrator
 *
 */
@Entity
@Table(name = "question", indexes={@Index(name="index_merchant", columnList="merchant_id"), @Index(name="index_name", columnList="name") },  schema = "springdemo",  catalog = "")
@ApiModel(description = "问卷表")
public class Question extends BaseEventEntity<Integer> {

	private static final long serialVersionUID = -6857678746433501077L;

	/** 是否展示提交用户数和提交用户头像 */
	@ApiModelProperty(value = "是否展示提交用户数和提交用户头像", example = "false")
	private boolean isShow = false;

	@Basic
	@Column(name = "is_show", nullable = true)
	public boolean isShow() {
		return isShow;
	}

	public void setShow(boolean isShow) {
		this.isShow = isShow;
	}

}
