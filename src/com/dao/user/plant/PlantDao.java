package com.dao.user.plant;

import java.util.List;

import com.entity.Plant;
import com.entity.category;

public interface PlantDao {
	int savePlan(Plant plant);

	//��ʾ����
	List<Plant> show();

	//ͨ��id��ѯ���޸�
	Plant findByid(int plateId);

	//�޸�
	int update(Plant plant);

	//ɾ��
	int delById(int plateId);

	//����ɾ��
	int delAll(String[] uids);


}
