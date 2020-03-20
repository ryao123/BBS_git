package com.dao.user.plant;

import java.util.List;

import com.entity.Plant;
import com.entity.category;

public interface PlantDao {
	int savePlan(Plant plant);

	//显示所有
	List<Plant> show();

	//通过id查询来修改
	Plant findByid(int plateId);

	//修改
	int update(Plant plant);

	//删除
	int delById(int plateId);

	//批量删除
	int delAll(String[] uids);


}
