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
@Table(name="reply")
@Data
public class Reply implements Serializable{

    /** id */
	@Id
	private String replyId;
    /** 帖子id */
	private String postsId;
    /** 用户id */
	private String id;
    /** 内容 */
	private String contain;
    /** 回复时间 */
	private java.util.Date replyTime;
    /** 签名 */
	private String sign;
    /** 点赞数量 */
	private Integer goodCount;
    /** 点踩 */
	private Integer worseCount;
    /** 是否打开 1:关闭 0:开启 */
	private String isOpen;
	
}
