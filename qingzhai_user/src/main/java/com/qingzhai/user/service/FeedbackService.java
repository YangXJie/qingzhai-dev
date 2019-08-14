package com.qingzhai.user.service;

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

import com.qingzhai.user.dao.FeedbackDao;
import com.qingzhai.user.pojo.Feedback;

/**
 * 服务层
 * 
 * @author Administrator
 *
 */
@Service
public class FeedbackService {

	@Autowired
	private FeedbackDao feedbackDao;
	
	@Autowired
	private IdWorker idWorker;

	/**
	 * 查询全部列表
	 * @return
	 */
	public List<Feedback> findAll() {
		return feedbackDao.findAll();
	}

	
	/**
	 * 条件查询+分页
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<Feedback> findSearch(Map whereMap, int page, int size) {
		Specification<Feedback> specification = createSpecification(whereMap);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return feedbackDao.findAll(specification, pageRequest);
	}

	
	/**
	 * 条件查询
	 * @param whereMap
	 * @return
	 */
	public List<Feedback> findSearch(Map whereMap) {
		Specification<Feedback> specification = createSpecification(whereMap);
		return feedbackDao.findAll(specification);
	}

	/**
	 * 根据ID查询实体
	 * @param id
	 * @return
	 */
	public Feedback findById(String id) {
		return feedbackDao.findById(id).get();
	}

	/**
	 * 增加
	 * @param feedback
	 */
	public void add(Feedback feedback) {
		feedback.setId( idWorker.nextId()+"" );
		feedbackDao.save(feedback);
	}

	/**
	 * 修改
	 * @param feedback
	 */
	public void update(Feedback feedback) {
		feedbackDao.save(feedback);
	}

	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(String id) {
		feedbackDao.deleteById(id);
	}

	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<Feedback> createSpecification(Map searchMap) {

		return new Specification<Feedback>() {

			@Override
			public Predicate toPredicate(Root<Feedback> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
                // id
                if (searchMap.get("id")!=null && !"".equals(searchMap.get("id"))) {
                	predicateList.add(cb.like(root.get("id").as(String.class), "%"+(String)searchMap.get("id")+"%"));
                }
                // 指向用户ID
                if (searchMap.get("userid")!=null && !"".equals(searchMap.get("userid"))) {
                	predicateList.add(cb.like(root.get("userid").as(String.class), "%"+(String)searchMap.get("userid")+"%"));
                }
                // 反馈标题
                if (searchMap.get("title")!=null && !"".equals(searchMap.get("title"))) {
                	predicateList.add(cb.like(root.get("title").as(String.class), "%"+(String)searchMap.get("title")+"%"));
                }
                // 是否解决
                if (searchMap.get("isReply")!=null && !"".equals(searchMap.get("isReply"))) {
                	predicateList.add(cb.like(root.get("isReply").as(String.class), "%"+(String)searchMap.get("isReply")+"%"));
                }
				
				return cb.and( predicateList.toArray(new Predicate[predicateList.size()]));

			}
		};

	}

}
