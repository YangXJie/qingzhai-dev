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
@Table(name="posts")
@Data
public class Posts implements Serializable{

	/** 帖子id */
	@Id
	private String postsId;
	/** 用户id */
	private String id;
	/** 版块id */
	private String blocksId;
	/** 标题 */
	private String title;
	/** 内容 */
	private String contain;
	/** 创建时间 */
	private java.util.Date set_time;
	/** 最新回复时间 */
	private java.util.Date new_time;
	/** 回复数量 */
	private Integer reply_num;
	/** 点赞数 */
	private Integer good_num;
	/** 踩数 */
	private Integer worse_num;
	/** 是否关闭(1:关闭 0:开启) */
	private String isClose;
	/** 是否加精(1:加精 0:不加) */
	private String isBest;

}
