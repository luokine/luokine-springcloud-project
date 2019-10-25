//package com.luokine.provider.core.entity;
//
//import com.baomidou.mybatisplus.annotation.TableField;
//import com.baomidou.mybatisplus.annotation.TableId;
//import com.baomidou.mybatisplus.annotation.TableName;
//
//import java.util.Date;
//import java.io.Serializable;
//
///**
// * <p>
// *
// * </p>
// *
// * @author tianziquan123
// * @since 2019-10-24
// */
//@TableName("user_info")
//public class UserInfo implements Serializable {
//
//    private static final long serialVersionUID = 1L;
//
//    @TableId("user_id")
//    private Integer userId;
//    @TableField("user_name")
//    private String userName;
//    private String password;
//    /**
//     * 删除标识(0-未删除，1-已删除)
//     */
//    @TableField("del_flag")
//    private Integer delFlag;
//    /**
//     * 创建时间
//     */
//    @TableField("create_time")
//    private Date createTime;
//    /**
//     * 修改时间
//     */
//    @TableField("update_time")
//    private Date updateTime;
//
//
//    public Integer getUserId() {
//        return userId;
//    }
//
//    public void setUserId(Integer userId) {
//        this.userId = userId;
//    }
//
//    public String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public Integer getDelFlag() {
//        return delFlag;
//    }
//
//    public void setDelFlag(Integer delFlag) {
//        this.delFlag = delFlag;
//    }
//
//    public Date getCreateTime() {
//        return createTime;
//    }
//
//    public void setCreateTime(Date createTime) {
//        this.createTime = createTime;
//    }
//
//    public Date getUpdateTime() {
//        return updateTime;
//    }
//
//    public void setUpdateTime(Date updateTime) {
//        this.updateTime = updateTime;
//    }
//
//    @Override
//    public String toString() {
//        return "UserInfo{" +
//        "userId=" + userId +
//        ", userName=" + userName +
//        ", password=" + password +
//        ", delFlag=" + delFlag +
//        ", createTime=" + createTime +
//        ", updateTime=" + updateTime +
//        "}";
//    }
//}
