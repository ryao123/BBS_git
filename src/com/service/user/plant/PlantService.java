package com.service.user.plant;

import java.util.List;

import com.entity.Plant;
import com.entity.category;

public interface PlantService {

	boolean savePlant(Plant plant);

	//��ʾ��������
	List<Plant> show();

	Plant findByid(int plateId);

	//�޸�
	boolean update(Plant plant);

	//��idɾ��
	boolean delById(int plateId);

	//����ɾ��
	boolean delAll(String plateIds);

	
}
