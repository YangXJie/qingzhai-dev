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
@Table(name="feedback")
@Data
public class Feedback implements Serializable{

	/** id */
	@Id
	private String id;
	/** 指向用户ID */
	private String userid;
	/** 反馈标题 */
	private String title;
	/** 内容 */
	private String contain;
	/** 提交的时间（年月日-时间） */
	private Date commitdate;
	/** 是否解决(1:解决 0:未解决) */
	private String isReply;

}
