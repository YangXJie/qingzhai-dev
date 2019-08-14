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
@Table(name="major")
@Data
public class Major implements Serializable{
	/** id */
	@Id
	private String id;
	/** 主修方向名称 */
	private String name;
}
