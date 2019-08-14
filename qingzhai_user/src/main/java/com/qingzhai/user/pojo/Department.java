package com.qingzhai.user.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 实体类
 * @author Administrator
 *
 */
@Entity
@Table(name="department")
@Data
public class Department implements Serializable{
	/** id */
	@Id
	private String id;
	/** 系别名称 */
	private String name;
	/** 创建时间 */
	private Date createDate;
	/** (1关闭 0开启) */
	private String isClose;
}
