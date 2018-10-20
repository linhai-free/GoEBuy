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
 * 用户-会员招募表
 *
 * Created by luodejin on 2018/8/15.
 */
@Entity
@Table(name = "user_member_recruitment",
        indexes={@Index(name="index_user", columnList="user_id"),
                @Index(name="index_member_recuritment_id", columnList="member_recuritment_id") },
        schema = "springdemo",
        catalog = "")
@ApiModel(description = "用户-会员招募表")
public class UserMemberRecruitment extends BaseUserEventEntity<Integer> {

    private static final long serialVersionUID = 2508655292139612838L;

    /** 会员招募表id */
    @ApiModelProperty(value = "会员招募id")
    private MemberRecruitment memberRecruitment;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="member_recruitment_id")
    public MemberRecruitment getMemberRecruitment() {
        return memberRecruitment;
    }

    public void setMemberRecruitment(MemberRecruitment memberRecruitment) {
        this.memberRecruitment = memberRecruitment;
    }

}
