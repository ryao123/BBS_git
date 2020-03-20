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
	
	//��ʾ��������
	@Override
	public List<Plant> show() {
		List<Plant> list=pd.show();
		if(list==null) {
			return null;
		}else {
			return list;
		}
	}

	//ͨ��id��ѯ���޸�
	@Override
	public Plant findByid(int plateId) {
		Plant result=pd.findByid(plateId);
		if(result==null) {
			return null;
		}else {
			return result;
		}
	}
	

	//�޸�
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
		// ���ַ����е���������ȥ��������ȡ[]�е�����
		plateIds = plateIds.substring(1, plateIds.lastIndexOf("]")).replaceAll("\"", "");
				// ���ַ��ܽ��в��Ϊ����
		String[] uids = plateIds.split(",");
		int result=pd.delAll(uids);
		if(result>0) {
			return true;
		}else {
			return false;
		}
	}

	
}
