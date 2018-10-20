package com.goebuy.entity.event;

import com.goebuy.entity.BaseEntity;
import com.goebuy.entity.Order;
import com.goebuy.entity.user.Merchant;
import com.goebuy.entity.user.User;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

/**
 * Created by luodejin on 2018/10/20.
 */
@MappedSuperclass
public abstract class BaseUserEventEntity<T> extends BaseEntity<T> {

    private static final long serialVersionUID = -5344049913580578945L;

    /** 用户id */
    @ApiModelProperty(value = "用户id")
    private User user;

    /** 审核状态：0 待审核，1 已成功报名，2 已关闭报名 */
    @ApiModelProperty(value = "审核状态：0 待审核，1 已成功报名，2 已关闭报名")
    private String auditState;

    /** 审核人 */
    @ApiModelProperty(value = "审核人")
    private Merchant auditor;

    /** 报名渠道 */
    @ApiModelProperty(value = "报名渠道")
    private String enrollChannel;

    /** 售票类型 */
    @ApiModelProperty(value = "活动售票类型")
    private int ticketType;

    /** 生成订单 */
    @ApiModelProperty(value = "生成订单")
    private Order order;

    /** 签到状态 */
    @ApiModelProperty(value = "签到状态")
    private String signState;

    /** 报名提交时间 */
    @ApiModelProperty(value = "报名提交时间")
    private String createTime;

    /**
     * 表单信息
     */

    /** 用户填写字段 */
    @ApiModelProperty(value = "用户填写字段")
    private String fieldSet;

    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL,})
    @JoinColumn(name="user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Basic
    @Column(name = "audit_state", nullable = true)
    public String getAuditState() {
        return auditState;
    }

    public void setAuditState(String auditState) {
        this.auditState = auditState;
    }

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="merchant_id")
    public Merchant getAuditor() {
        return auditor;
    }

    public void setAuditor(Merchant auditor) {
        this.auditor = auditor;
    }

    @Basic
    @Column(name = "enroll_channel", nullable = true)
    public String getEnrollChannel() {
        return enrollChannel;
    }

    public void setEnrollChannel(String enrollChannel) {
        this.enrollChannel = enrollChannel;
    }
    @Basic
    @Column(name = "ticket_type", nullable = true)
    public int getTicketType() {
        return ticketType;
    }

    public void setTicketType(int ticket_type) {
        this.ticketType = ticket_type;
    }

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="order_id")
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Basic
    @Column(name = "sign_state", nullable = true)
    public String getSignState() {
        return signState;
    }

    public void setSignState(String signState) {
        this.signState = signState;
    }

    @Basic
    @Column(name = "create_time", nullable = false)
    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "field_set", nullable = false)
    public String getFieldSet() {
        return fieldSet;
    }

    public void setFieldSet(String fieldSet) {
        this.fieldSet = fieldSet;
    }

}
