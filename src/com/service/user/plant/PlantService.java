package com.service.user.plant;

import java.util.List;

import com.entity.Plant;
import com.entity.category;

public interface PlantService {

	boolean savePlant(Plant plant);

	//显示所有数据
	List<Plant> show();

	Plant findByid(int plateId);

	//修改
	boolean update(Plant plant);

	//按id删除
	boolean delById(int plateId);

	//批量删除
	boolean delAll(String plateIds);

	
}
