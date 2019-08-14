package com.qingzhai.plate.pojo;

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
@Table(name="plate")
@Data
public class Plate implements Serializable{

	/** id */
	@Id
	private String id;
	/** 板块名称 */
	private String name;
	/** 创建时间 */
	private java.util.Date createDate;
	/** 板块下的帖子数量 */
	private Integer postCount;
	/** 板块公告 */
	private String bulletIn;
	/** 板块管理员名称 */
	private String admin;
	/** 是否关闭板块（1：关闭 0：开启） */
	private String isClose;

}
