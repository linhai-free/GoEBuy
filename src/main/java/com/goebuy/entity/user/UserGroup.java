package com.goebuy.entity.user;

import com.goebuy.entity.BaseEntity;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 用户群组表
 *
 * Created by luodejin on 2018/8/14.
 */
@Entity
@Table(name = "user_group", schema = "springdemo")
public class UserGroup extends BaseEntity<Integer> {

    private static final long serialVersionUID = 8793511690544771276L;

    private User user;              //用户
    private Group group;                  //群组
    private String initiationTime;        //用户进入群组时间

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
    @Basic
    @Column(name = "initiationTime", nullable = false)
    public String getInitiationTime() {
        return initiationTime;
    }

    public void setInitiationTime(String initiationTime) {
        this.initiationTime = initiationTime;
    }
}