package com.qingzhai.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.qingzhai.user.pojo.Feedback;
/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface FeedbackDao extends JpaRepository<Feedback,String>,JpaSpecificationExecutor<Feedback>{
	
}
