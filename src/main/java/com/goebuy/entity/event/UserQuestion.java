package com.goebuy.entity.event;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 用户-问卷表
 * @author Administrator
 */
@Entity
@Table(name = "user_question",
		indexes={@Index(name="index_merchant", columnList="merchant_id"),
				@Index(name="index_user", columnList="user_id")},
		schema = "springdemo",
		catalog = "")
@ApiModel(description = "用户-问卷表")
public class UserQuestion extends BaseUserEventEntity<Integer> {

	private static final long serialVersionUID = -4867590336448602514L;

	/** 问卷id */
	@ApiModelProperty(value = "问卷id")
	private Question question;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="question_id")
	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

}
