package com.goebuy.entity.user;

import com.goebuy.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 用户-群组表
 * 包含: <ul>
 * <li>用户事件群组表</li>
 * <li>用户标签群组表</li>
 * <li>用户自定义群组表</li>
 * </ul>
 *
 * Created by luodejin on 2018/8/14.
 */
@Entity
@Table(name = "user_group",
        indexes={@Index(name="index_user", columnList="user_id"),
                @Index(name="index_group", columnList="group_id")},
        schema = "springdemo")
@ApiModel(description = "用户-群组表")
public class UserGroup extends BaseEntity<Integer> {

    private static final long serialVersionUID = 8793511690544771276L;

    @ApiModelProperty(value = "用户id")
    private User user;                    //用户

    @ApiModelProperty(value = "群组id")
    private Group group;                  //群组

    @ApiModelProperty(value = "用户进入群组时间")
    private String createTime;            //用户进入群组时间

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="group_id")
    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
    @Basic
    @Column(name = "create_time", nullable = false)
    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
