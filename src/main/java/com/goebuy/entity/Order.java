package com.goebuy.entity;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.goebuy.entity.user.Merchant;
import com.goebuy.entity.user.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 订单表
 *
 * Created by luodejin on 2018/9/6.
 */
@Entity
@Table(name = "`order`",
        indexes={@Index(name="index_user", columnList="user_id"),
                @Index(name="index_order_id", columnList="order_id"),
                @Index(name="index_order_state", columnList="order_state"),
                @Index(name="index_event_id", columnList="event_id"),
                @Index(name="index_merchant_id", columnList="merchant_id")},
        schema = "springdemo",
        catalog = "")
@ApiModel(description = "订单表")
public class Order extends BaseEntity<Integer> {

    private static final long serialVersionUID = -4722104061011986099L;

    /**
     * 订单号：固定长度20
     */
    @ApiModelProperty(value = "订单号：固定长度20")
    private String orderId;

    /**
     * 订单类型，预留字段
     */
    @ApiModelProperty(value = "订单类型，预留字段")
    private int orderType;

    /**
     * 订单来源，预留字段
     */
    @ApiModelProperty(value = "订单来源，预留字段")
    private String orderSource;

    /**
     * 支付渠道：0 现金，1 支付宝，2 微信，3 储蓄卡，4 信用卡
     */
    @ApiModelProperty(value = "支付渠道：0 现金，1 支付宝，2 微信，3 储蓄卡，4 信用卡")
    private int payChannel;

    /**
     * 订单创建时间
     */
    @ApiModelProperty(value = "订单创建时间")
    private String createTime;

    /**
     * 订单支付时间
     */
    @ApiModelProperty(value = "订单支付时间")
    private String payTime;

    /**
     * 订单关闭时间：超过此时间未支付订单失效，自动关闭
     */
    @ApiModelProperty(value = "订单关闭时间：超过此时间未支付订单失效，自动关闭")
    private String closeTime;

    /**
     * 金额
     */
    @ApiModelProperty(value = "金额")
    private Double price;

    /**
     * 支付用户id
     */
    @ApiModelProperty(value = "支付用户id")
    private User user;

    /**
     * 交易状态：0 待支付，1 交易成功，2 交易关闭
     */
    @ApiModelProperty(value = "交易状态：0 待支付，1 交易成功，2 交易关闭")
    private int orderState;

    /**
     * 商品(事件)类型：0 活动，1 报名表，2 拼团，3 众筹，4 打赏，5 会员招募
     */
    @ApiModelProperty(value = "商品(事件)类型：0 活动，1 报名表，2 拼团，3 众筹，4 打赏，5 会员招募")
    private int eventType;

    /**
     * 事件(商品)id：与type联合使用，代表活动、报名表等id
     */
    @ApiModelProperty(value = " 事件(商品)id：与type联合使用，代表活动、报名表等id")
    private int eventId;

    /**
     * 描述信息
     */
    @ApiModelProperty(value = "描述信息")
    private String description;

    /** 商户id */
    @ApiModelProperty(value = "商户id")
    private Merchant merchant;

    @Basic
    @Column(name = "order_id", unique=true, length=20, nullable = false)
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "order_type")
    public int getOrderType() {
        return orderType;
    }

    public void setOrderType(int orderType) {
        this.orderType = orderType;
    }

    @Basic
    @Column(name = "order_source")
    public String getOrderSource() {
        return orderSource;
    }

    public void setOrderSource(String orderSource) {
        this.orderSource = orderSource;
    }

    @Basic
    @Column(name = "pay_channel", nullable = true)
    public int getPayChannel() {
        return payChannel;
    }

    public void setPayChannel(int payChannel) {
        this.payChannel = payChannel;
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
    @Column(name = "pay_time")
    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    @Basic
    @Column(name = "close_time")
    public String getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }

    @Basic
    @Column(name = "price", nullable = false)
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @OneToOne(fetch = FetchType.EAGER,  cascade = {CascadeType.ALL})
    @JoinColumn(name="user_id", nullable=true )
    public User getUser() {	
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Basic
    @Column(name = "order_state", nullable = false)
    public int getOrderState() {
        return orderState;
    }

    public void setOrderState(int orderState) {
        this.orderState = orderState;
    }

    @Basic
    @Column(name = "event_type", nullable = false)
    public int getEventType() {
        return eventType;
    }

    public void setEventType(int eventType) {
        this.eventType = eventType;
    }

    @Basic
    @Column(name = "event_id", nullable = false)
    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="merchant_id")
    public Merchant getMerchant() {
        return merchant;
    }

    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }

}
