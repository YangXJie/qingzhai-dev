package com.qingzhai.plate.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.qingzhai.plate.pojo.Plate;
/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface PlateDao extends JpaRepository<Plate,String>,JpaSpecificationExecutor<Plate>{
	
}
