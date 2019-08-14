package com.qingzhai.user.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * 实体类
 * @author Administrator
 *
 */
@Entity
@Table(name="user")
@Data
public class User implements Serializable{

    /** id */
	@Id
	private String id;
    /** 学号/教师编号 */
	private String schId;
    /** 用户名 */
	private String username;
    /** 密码 */
	private String password;
    /** 个性签名 */
	private String sign;
    /** 昵称，如果不输入为username */
	private String nikename;
    /** 院系ID */
	private String departmentId;
    /** 年级专业 */
	private String grade;
    /** 主修方向的名称 */
	private String major;
    /** 主修方向的Id */
	private String majorId;
    /** 出生年月 */
	private java.util.Date birthday;
    /** 头像 */
	private String avatar;
    /** 性别（1男 0女） */
	private String sex;
    /** 手机号 */
	private String mobile;
    /** 邮箱地址 */
	private String email;
    /** 宿舍号 */
	private String roomId;
    /** 注册时间 */
	private java.util.Date regDate;
    /** 更新时间 */
	private java.util.Date updateDate;
    /** 最后登入时间 */
	private java.util.Date lastDate;
    /** 粉丝数 */
	private Integer fansCount;
    /** 关注数 */
	private Integer followCount;
    /** 是否关闭（1关闭 0开启） */
	private String isClose;
    /** 角色名称 */
	private String role;
}
