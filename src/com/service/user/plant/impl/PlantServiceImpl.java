package com.service.user.plant.impl;

import java.util.List;

import com.dao.user.plant.PlantDao;
import com.dao.user.plant.impl.PlantDaoImpl;
import com.entity.Plant;
import com.entity.category;
import com.service.user.plant.PlantService;

public class PlantServiceImpl implements PlantService {

	private PlantDao pd =new PlantDaoImpl();
	@Override
	public boolean savePlant(Plant plant) {
		int result =pd.savePlan(plant);
		if(result>0) {
			return true;
		}
		return false;
	}
	
	//显示所有数据
	@Override
	public List<Plant> show() {
		List<Plant> list=pd.show();
		if(list==null) {
			return null;
		}else {
			return list;
		}
	}

	//通过id查询来修改
	@Override
	public Plant findByid(int plateId) {
		Plant result=pd.findByid(plateId);
		if(result==null) {
			return null;
		}else {
			return result;
		}
	}
	

	//修改
	@Override
	public boolean update(Plant plant) {
		int result =pd.update(plant);
		if(result>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean delById(int plateId) {
		int result =pd.delById(plateId);
		if(result>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean delAll(String plateIds) {
		// 将字符串中的所有引号去掉，并截取[]中的数据
		plateIds = plateIds.substring(1, plateIds.lastIndexOf("]")).replaceAll("\"", "");
				// 将字符窜进行拆分为数组
		String[] uids = plateIds.split(",");
		int result=pd.delAll(uids);
		if(result>0) {
			return true;
		}else {
			return false;
		}
	}

	
}
