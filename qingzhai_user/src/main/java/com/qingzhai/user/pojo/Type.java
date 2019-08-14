package com.qingzhai.user.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * 标签实体类
 * @author Administrator
 *
 */
@Entity
@Table(name="user_type")
@Data
public class Type implements Serializable{
	/** 标签id */
	@Id
	private String typeId;
	/** 用户id */
	private String id;
}
