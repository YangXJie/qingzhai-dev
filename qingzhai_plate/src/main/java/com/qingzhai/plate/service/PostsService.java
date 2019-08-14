package com.qingzhai.plate.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import util.IdWorker;

import com.qingzhai.plate.dao.PostsDao;
import com.qingzhai.plate.pojo.Posts;

/**
 * 服务层
 * 
 * @author Administrator
 *
 */
@Service
public class PostsService {

	@Autowired
	private PostsDao postsDao;
	
	@Autowired
	private IdWorker idWorker;

	/**
	 * 查询全部列表
	 * @return
	 */
	public List<Posts> findAll() {
		return postsDao.findAll();
	}

	
	/**
	 * 条件查询+分页
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<Posts> findSearch(Map whereMap, int page, int size) {
		Specification<Posts> specification = createSpecification(whereMap);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return postsDao.findAll(specification, pageRequest);
	}

	
	/**
	 * 条件查询
	 * @param whereMap
	 * @return
	 */
	public List<Posts> findSearch(Map whereMap) {
		Specification<Posts> specification = createSpecification(whereMap);
		return postsDao.findAll(specification);
	}

	/**
	 * 根据ID查询实体
	 * @param id
	 * @return
	 */
	public Posts findById(String id) {
		return postsDao.findById(id).get();
	}

	/**
	 * 增加
	 * @param posts
	 */
	public void add(Posts posts) {
		posts.setId( idWorker.nextId()+"" );
		postsDao.save(posts);
	}

	/**
	 * 修改
	 * @param posts
	 */
	public void update(Posts posts) {
		postsDao.save(posts);
	}

	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(String id) {
		postsDao.deleteById(id);
	}

	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<Posts> createSpecification(Map searchMap) {

		return new Specification<Posts>() {

			@Override
			public Predicate toPredicate(Root<Posts> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
                // 帖子id
                if (searchMap.get("postsId")!=null && !"".equals(searchMap.get("postsId"))) {
                	predicateList.add(cb.like(root.get("postsId").as(String.class), "%"+(String)searchMap.get("postsId")+"%"));
                }
                // 用户id
                if (searchMap.get("id")!=null && !"".equals(searchMap.get("id"))) {
                	predicateList.add(cb.like(root.get("id").as(String.class), "%"+(String)searchMap.get("id")+"%"));
                }
                // 版块id
                if (searchMap.get("blocksId")!=null && !"".equals(searchMap.get("blocksId"))) {
                	predicateList.add(cb.like(root.get("blocksId").as(String.class), "%"+(String)searchMap.get("blocksId")+"%"));
                }
                // 标题
                if (searchMap.get("title")!=null && !"".equals(searchMap.get("title"))) {
                	predicateList.add(cb.like(root.get("title").as(String.class), "%"+(String)searchMap.get("title")+"%"));
                }
                // 是否关闭(1:关闭 0:开启)
                if (searchMap.get("isClose")!=null && !"".equals(searchMap.get("isClose"))) {
                	predicateList.add(cb.like(root.get("isClose").as(String.class), "%"+(String)searchMap.get("isClose")+"%"));
                }
                // 是否加精(1:加精 0:不加)
                if (searchMap.get("isBest")!=null && !"".equals(searchMap.get("isBest"))) {
                	predicateList.add(cb.like(root.get("isBest").as(String.class), "%"+(String)searchMap.get("isBest")+"%"));
                }
				
				return cb.and( predicateList.toArray(new Predicate[predicateList.size()]));

			}
		};

	}

}
