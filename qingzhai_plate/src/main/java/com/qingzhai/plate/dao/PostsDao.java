package com.qingzhai.plate.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.qingzhai.plate.pojo.Posts;
/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface PostsDao extends JpaRepository<Posts,String>,JpaSpecificationExecutor<Posts>{
	
}
