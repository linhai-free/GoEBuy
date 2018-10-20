package com.goebuy.entity.user;

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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 群组表
 *
 *  Created by luodejin on 2018/8/14.
 */
@Entity
@Table(name = "`group`",
        schema = "springdemo",
        indexes={@Index(name="group_name_Index", columnList="name"),
                @Index(name="index_group_type", columnList="type")},
        catalog = "")
@ApiModel(description = "群组表")
public class Group extends BaseEntity<Integer> {

	private static final long serialVersionUID = -8029735894274024826L;

	/**
	 * 群组名称
	 */
    @ApiModelProperty(value = "群组名称", required = true)
    private String name;                  
    
    /**
     * 群组类别：0 事件群组，1 标签群组，2 用户自定义群组
     */
    @ApiModelProperty(value = "群组类别：0 事件群组，1 标签群组，2 用户自定义群组", required = true)
    private int type;                     

    /**
     * 若为事件群组，存事件id
     * 若为标签群组，存最后一次事件(活动)id
     */
    @ApiModelProperty(value = "若为事件群组，存事件id；若为标签群组，存最后一次事件(活动)id")
    private int sourceId;

    /** 创建人 */
    @ApiModelProperty(value = "创建人")
    private Merchant creator;

    /** 创建时间 */
    @ApiModelProperty(value = "创建时间")
    private String createTime;

    /** 最近更新时间 */
    @ApiModelProperty(value = "最近更新时间")
    private String updateTime;

    /** 群组状态: 0 正常，1 解散 */
    @ApiModelProperty(value = "群组状态: 0 正常，1 解散", example = "0")
    private int state;                   

    @Basic
    @Column(name = "name", length=64, unique=true, nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "type", nullable = false)
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Basic
    @Column(name = "source_id", nullable = false)
    public int getSourceId() {
        return sourceId;
    }

    public void setSourceId(int sourceId) {
        this.sourceId = sourceId;
    }



    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST})
    @JoinColumn(name="merchant_id")
    public Merchant getCreator() {
        return creator;
    }

	public void setCreator(Merchant creator) {
        this.creator = creator;
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
    @Column(name = "update_time", nullable = false)
    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    @Basic
    @Column(name = "state", nullable = false)
    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
