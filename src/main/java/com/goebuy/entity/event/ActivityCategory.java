package com.goebuy.entity.event;

import java.util.Date;

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
import com.goebuy.utils.DateUtils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 活动分类库
 * @author Administrator
 *
 */
@Entity
@Table(name = "activity_cate",  indexes={@Index(name="merchant_index", columnList="merchant_id"), @Index(name="cate_name_index", columnList="cate_name"), @Index(name="parent_cate_id_index", columnList="parent_cate_id")} , schema = "springdemo",  catalog = "")
@ApiModel(description = "活动分类表")
public class ActivityCategory extends BaseEntity<Integer>{

	private static final long serialVersionUID = 711037462787375173L;

	/** 父类活动分类 */
	@ApiModelProperty(value = "父类活动分类")
	private ActivityCategory parentCate;
	
	/** 活动分类名称 */
	@ApiModelProperty(value = "活动分类名称")
	private String cateName;
	
	/** 创建人 */
	@ApiModelProperty(value = "创建人")
	private Merchant creator;
	
	/** 创建时间 */
	@ApiModelProperty(value = "创建时间")
	private String createTime;
	
	/** 是否是通用标签库 , 默认为否 */
	@ApiModelProperty(value = "是否是通用标签库 , 默认为否")
	private boolean isCommon = false;

	public  ActivityCategory() {
	}
	
	public  ActivityCategory(String cateName) {
		this(cateName, null);
	}
	
	public  ActivityCategory(String cateName, Merchant creator) {
		this(cateName, creator, false);
	}
	
	public  ActivityCategory(String cateName, Merchant creator, boolean isCommon) {
		this.cateName = cateName;
		this.creator = creator;
		this.isCommon= isCommon;
		this.createTime = DateUtils.dateToString(new Date(), DateUtils.LONG_PATTERN );
	}

//	@Basic
//	@Column(name = "parent_cate_id", nullable = true)
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="parent_cate_id")
	public ActivityCategory getParentCate() {
		return parentCate;
	}

	public void setParentCate(ActivityCategory parentCate) {
		this.parentCate = parentCate;
	}

	@Basic
	@Column(name = "cate_name", length=30, nullable = false, unique= true )
	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@JoinColumn(name="merchant_id")
	public Merchant getCreator() {
		return creator;
	}

	public void setCreator(Merchant createUser) {
		this.creator = createUser;
	}

	@Basic
	@Column(name = "create_time", nullable = true )
	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	@Basic
	@Column(name = "is_common", nullable = true )
	public boolean isCommon() {
		return isCommon;
	}

	public void setCommon(boolean isCommon) {
		this.isCommon = isCommon;
	}
	
}
