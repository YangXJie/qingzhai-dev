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

import com.qingzhai.user.dao.MajorDao;
import com.qingzhai.user.pojo.Major;

/**
 * 服务层
 * 
 * @author Administrator
 *
 */
@Service
public class MajorService {

	@Autowired
	private MajorDao majorDao;
	
	@Autowired
	private IdWorker idWorker;

	/**
	 * 查询全部列表
	 * @return
	 */
	public List<Major> findAll() {
		return majorDao.findAll();
	}

	
	/**
	 * 条件查询+分页
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<Major> findSearch(Map whereMap, int page, int size) {
		Specification<Major> specification = createSpecification(whereMap);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return majorDao.findAll(specification, pageRequest);
	}

	
	/**
	 * 条件查询
	 * @param whereMap
	 * @return
	 */
	public List<Major> findSearch(Map whereMap) {
		Specification<Major> specification = createSpecification(whereMap);
		return majorDao.findAll(specification);
	}

	/**
	 * 根据ID查询实体
	 * @param id
	 * @return
	 */
	public Major findById(String id) {
		return majorDao.findById(id).get();
	}

	/**
	 * 增加
	 * @param major
	 */
	public void add(Major major) {
		major.setId( idWorker.nextId()+"" );
		majorDao.save(major);
	}

	/**
	 * 修改
	 * @param major
	 */
	public void update(Major major) {
		majorDao.save(major);
	}

	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(String id) {
		majorDao.deleteById(id);
	}

	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<Major> createSpecification(Map searchMap) {

		return new Specification<Major>() {

			@Override
			public Predicate toPredicate(Root<Major> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
                // ID
                if (searchMap.get("id")!=null && !"".equals(searchMap.get("id"))) {
                	predicateList.add(cb.like(root.get("id").as(String.class), "%"+(String)searchMap.get("id")+"%"));
                }
                // 主修方向名称
                if (searchMap.get("name")!=null && !"".equals(searchMap.get("name"))) {
                	predicateList.add(cb.like(root.get("name").as(String.class), "%"+(String)searchMap.get("name")+"%"));
                }
				
				return cb.and( predicateList.toArray(new Predicate[predicateList.size()]));

			}
		};

	}

}
