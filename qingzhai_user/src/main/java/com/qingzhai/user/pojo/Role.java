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
@Table(name="role")
@Data
public class Role implements Serializable{
    /** id */
	@Id
	private String id;//id
    /** 角色名称 */
	private String name;//角色名称
}
