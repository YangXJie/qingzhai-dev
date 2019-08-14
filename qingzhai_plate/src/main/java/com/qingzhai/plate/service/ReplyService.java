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

import com.qingzhai.plate.dao.ReplyDao;
import com.qingzhai.plate.pojo.Reply;

/**
 * 服务层
 * 
 * @author Administrator
 *
 */
@Service
public class ReplyService {

	@Autowired
	private ReplyDao replyDao;
	
	@Autowired
	private IdWorker idWorker;

	/**
	 * 查询全部列表
	 * @return
	 */
	public List<Reply> findAll() {
		return replyDao.findAll();
	}

	
	/**
	 * 条件查询+分页
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<Reply> findSearch(Map whereMap, int page, int size) {
		Specification<Reply> specification = createSpecification(whereMap);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return replyDao.findAll(specification, pageRequest);
	}

	
	/**
	 * 条件查询
	 * @param whereMap
	 * @return
	 */
	public List<Reply> findSearch(Map whereMap) {
		Specification<Reply> specification = createSpecification(whereMap);
		return replyDao.findAll(specification);
	}

	/**
	 * 根据ID查询实体
	 * @param id
	 * @return
	 */
	public Reply findById(String id) {
		return replyDao.findById(id).get();
	}

	/**
	 * 增加
	 * @param reply
	 */
	public void add(Reply reply) {
		reply.setId( idWorker.nextId()+"" );
		replyDao.save(reply);
	}

	/**
	 * 修改
	 * @param reply
	 */
	public void update(Reply reply) {
		replyDao.save(reply);
	}

	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(String id) {
		replyDao.deleteById(id);
	}

	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<Reply> createSpecification(Map searchMap) {

		return new Specification<Reply>() {

			@Override
			public Predicate toPredicate(Root<Reply> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
                // 回复id
                if (searchMap.get("replyId")!=null && !"".equals(searchMap.get("replyId"))) {
                	predicateList.add(cb.like(root.get("replyId").as(String.class), "%"+(String)searchMap.get("replyId")+"%"));
                }
                // 帖子id
                if (searchMap.get("postsId")!=null && !"".equals(searchMap.get("postsId"))) {
                	predicateList.add(cb.like(root.get("postsId").as(String.class), "%"+(String)searchMap.get("postsId")+"%"));
                }
                // 用户id
                if (searchMap.get("id")!=null && !"".equals(searchMap.get("id"))) {
                	predicateList.add(cb.like(root.get("id").as(String.class), "%"+(String)searchMap.get("id")+"%"));
                }
                // 签名
                if (searchMap.get("sign")!=null && !"".equals(searchMap.get("sign"))) {
                	predicateList.add(cb.like(root.get("sign").as(String.class), "%"+(String)searchMap.get("sign")+"%"));
                }
                // 是否打开 1:关闭 0:开启
                if (searchMap.get("isOpen")!=null && !"".equals(searchMap.get("isOpen"))) {
                	predicateList.add(cb.like(root.get("isOpen").as(String.class), "%"+(String)searchMap.get("isOpen")+"%"));
                }
				
				return cb.and( predicateList.toArray(new Predicate[predicateList.size()]));

			}
		};

	}

}
