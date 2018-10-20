package com.goebuy.entity.event;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

/**
 * 打赏表
 * @author Administrator
 *
 */
@Entity
@Table(name = "tip", indexes={@Index(name="index_merchant", columnList="merchant_id"), @Index(name="index_name", columnList="name")},  schema = "springdemo",  catalog = "")
@ApiModel(description = "打赏表")
public class Tip extends BaseEventEntity<Integer> {

	private static final long serialVersionUID = -467076718741543076L;

	/**
	 * 项目信息
	 */

	/** 设置项目海报 */
	@ApiModelProperty(value = "设置项目海报")
	private boolean isShowPoster = false;

	/** 项目海报：建议尺寸640*400，请勿上传超过2m的图片 */
	@ApiModelProperty(value = "项目海报：建议尺寸640*400，请勿上传超过2m的图片")
	private String poster;

	/** 设置文章内容 */
	@ApiModelProperty(value = "设置文章内容")
	private boolean isShowContent = false;
	
	/** 文章内容 */
	@ApiModelProperty(value = "文章内容")
	private String content;

	/** 设置打赏后可见内容 */
	@ApiModelProperty(value = "设置打赏后可见内容")
	private boolean isShowHiddenContent;

	/** 打赏后可见内容  */
	@ApiModelProperty(value = "打赏后可见内容")
	private String hiddenContent;

	/**
	 * 打赏设置
	 */

	/** 打赏金额设置，6等级：1，5，10，50，100，200 */
	@ApiModelProperty(value = "打赏金额设置，6等级：1，5，10，50，100，200", example = "200")
	private String fee;
	
	/** 展示自定义打赏金额(用户可打赏1-20000元的自定义金额) */
	@ApiModelProperty(value = "展示自定义打赏金额(用户可打赏1-20000元的自定义金额)")
	private boolean isShowCustomFee;
	
	/** 展示用户打赏排行榜 */
	@ApiModelProperty(value = "展示用户打赏排行榜")
	private boolean isShowUserRank;

	/** 后台数据统计时间(打赏发布后无法再修改统计时间)：7天，1个月，3个月 */
	@ApiModelProperty(value = "后台数据统计时间(打赏发布后无法再修改统计时间)：7天，1个月，3个月", example = "30")
	private int staticsDaySpan = 30;

	@Basic
	@Column(name = "is_show_poster", nullable = true)
	public boolean isShowPoster() {
		return isShowPoster;
	}

	public void setShowPoster(boolean showPoster) {
		isShowPoster = showPoster;
	}

	@Basic
	@Column(name = "poster", nullable = true)
	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	@Basic
	@Column(name = "is_show_content", nullable = true)
	public boolean isShowContent() {
		return isShowContent;
	}

	public void setShowContent(boolean showContent) {
		isShowContent = showContent;
	}

	@Basic
	@Column(name = "content", length=10000, nullable = true)
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	@Basic
	@Column(name = "is_show_hidden_content", nullable = true)
	public boolean isShowHiddenContent() {
		return isShowHiddenContent;
	}

	public void setShowHiddenContent(boolean isAfterShow) {
		this.isShowHiddenContent = isAfterShow;
	}

	@Basic
	@Column(name = "hidden_content", columnDefinition="text COMMENT '打赏后可见内容'", nullable = true)
	public String getHiddenContent() {
		return hiddenContent;
	}

	public void setHiddenContent(String hiddenContent) {
		this.hiddenContent = hiddenContent;
	}

	@Basic
	@Column(name = "fee", nullable = true)
	public String getFee() {
		return fee;
	}

	public void setFee(String feelevel) {
		this.fee = feelevel;
	}

	@Basic
	@Column(name = "is_show_custom_fee", nullable = true)
	public boolean isShowCustomFee() {
		return isShowCustomFee;
	}

	public void setShowCustomFee(boolean showCustomFee) {
		this.isShowCustomFee = showCustomFee;
	}

	@Basic
	@Column(name = "is_show_user_rank", nullable = true)
	public boolean isShowUserRank() {
		return isShowUserRank;
	}

	public void setShowUserRank(boolean showUserRank) {
		this.isShowUserRank = showUserRank;
	}

	@Basic
	@Column(name = "statics_day_span", nullable = true)
	public int getStaticsDaySpan() {
		return staticsDaySpan;
	}

	public void setStaticsDaySpan(int staticsDaySpan) {
		this.staticsDaySpan = staticsDaySpan;
	}

}
