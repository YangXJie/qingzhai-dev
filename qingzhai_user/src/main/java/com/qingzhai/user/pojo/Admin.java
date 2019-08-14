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
@Table(name="admin")
@Data
public class Admin implements Serializable{

    /** id */
	@Id
	private String id;
    /** 管理员名称 */
	private String nikename;
    /** 用户名 */
	private String username;
    /** 密码 */
	private String password;
    /** 角色 */
	private String role;

}
