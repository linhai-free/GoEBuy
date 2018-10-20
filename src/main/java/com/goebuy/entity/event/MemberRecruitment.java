package com.goebuy.entity.event;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

/**
 * 会员招募表
 *
 * Created by luodejin on 2018/8/15.
 */
@Entity
@Table(name = "member_recruitment",indexes={@Index(name="index_merchant", columnList="merchant_id"), @Index(name="index_name", columnList="name")} ,  schema = "springdemo")
@ApiModel(description = "会员招募表")
public class MemberRecruitment extends BaseEventEntity<Integer> {

    private static final long serialVersionUID = 6833768588441240453L;

    /**
     * 基本信息
     */

    /** 招募海报：建议尺寸640＊400，请勿上传超过2m的图片 */
    @ApiModelProperty(value = "活动海报")
    private String poster;                //项目海报：640＊400

    /** 会员特权 */
    @ApiModelProperty(value = "会员特权")
    private String privilege;

    /** 会费 */
    @ApiModelProperty(value = "会费", example = "999 元/人")
    private String memberPrice;

    /** 有效会员天数 */
    @ApiModelProperty(value = "有效会员天数", example = "365天")
    private String validDay;

    @Basic
    @Column(name = "poster", nullable = false)
    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    @Basic
    @Column(name = "privilege", nullable = false)
    public String getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }

    @Basic
    @Column(name = "member_price", nullable = false)
    public String getMemberPrice() {
        return memberPrice;
    }

    public void setMemberPrice(String memberPrice) {
        this.memberPrice = memberPrice;
    }

    @Basic
    @Column(name = "valid_day", nullable = false)
    public String getValidDay() {
        return validDay;
    }

    public void setValidDay(String validDay) {
        this.validDay = validDay;
    }
}
