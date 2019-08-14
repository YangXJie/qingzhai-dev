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
@Table(name="posts_type")
@Data
public class Type implements Serializable{

	/** 帖子id */
	@Id
	private String postsId;
	/** 标签id */
	private String typeId;
}
