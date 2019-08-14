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

import com.qingzhai.plate.dao.PlateDao;
import com.qingzhai.plate.pojo.Plate;

/**
 * 服务层
 * 
 * @author Administrator
 *
 */
@Service
public class PlateService {

	@Autowired
	private PlateDao plateDao;
	
	@Autowired
	private IdWorker idWorker;

	/**
	 * 查询全部列表
	 * @return
	 */
	public List<Plate> findAll() {
		return plateDao.findAll();
	}

	
	/**
	 * 条件查询+分页
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<Plate> findSearch(Map whereMap, int page, int size) {
		Specification<Plate> specification = createSpecification(whereMap);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return plateDao.findAll(specification, pageRequest);
	}

	
	/**
	 * 条件查询
	 * @param whereMap
	 * @return
	 */
	public List<Plate> findSearch(Map whereMap) {
		Specification<Plate> specification = createSpecification(whereMap);
		return plateDao.findAll(specification);
	}

	/**
	 * 根据ID查询实体
	 * @param id
	 * @return
	 */
	public Plate findById(String id) {
		return plateDao.findById(id).get();
	}

	/**
	 * 增加
	 * @param plate
	 */
	public void add(Plate plate) {
		plate.setId( idWorker.nextId()+"" );
		plateDao.save(plate);
	}

	/**
	 * 修改
	 * @param plate
	 */
	public void update(Plate plate) {
		plateDao.save(plate);
	}

	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(String id) {
		plateDao.deleteById(id);
	}

	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<Plate> createSpecification(Map searchMap) {
		return new Specification<Plate>() {

			@Override
			public Predicate toPredicate(Root<Plate> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
                // id
                if (searchMap.get("id")!=null && !"".equals(searchMap.get("id"))) {
                	predicateList.add(cb.like(root.get("id").as(String.class), "%"+(String)searchMap.get("id")+"%"));
                }
                // 板块名称
                if (searchMap.get("name")!=null && !"".equals(searchMap.get("name"))) {
                	predicateList.add(cb.like(root.get("name").as(String.class), "%"+(String)searchMap.get("name")+"%"));
                }
                // 板块管理员名称
                if (searchMap.get("admin")!=null && !"".equals(searchMap.get("admin"))) {
                	predicateList.add(cb.like(root.get("admin").as(String.class), "%"+(String)searchMap.get("admin")+"%"));
                }
                // 是否关闭板块（1：关闭 0：开启）
                if (searchMap.get("isClose")!=null && !"".equals(searchMap.get("isClose"))) {
                	predicateList.add(cb.like(root.get("isClose").as(String.class), "%"+(String)searchMap.get("isClose")+"%"));
                }
				return cb.and( predicateList.toArray(new Predicate[predicateList.size()]));
			}
		};

	}

}
