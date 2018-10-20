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
 * 用户-报名表
 * @author Administrator
 */
@Entity
@Table(name = "user_entry_form", schema = "springdemo", indexes={@Index(name="index_entry_form_id", columnList="entry_form_id"),  @Index(name="index_user", columnList="user_id")}, catalog = "")
@ApiModel(description = "用户-报名表")
public class UserEntryForm extends BaseUserEventEntity<Integer> {

	private static final long serialVersionUID = -1144737462440938677L;

	/** 报名表id */
	@ApiModelProperty(value = "报名表id")
	private EntryForm entryForm;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="entry_form_id")
	public EntryForm getEntryForm() {
		return entryForm;
	}

	public void setEntryForm(EntryForm entryForm) {
		this.entryForm = entryForm;
	}
	
}
