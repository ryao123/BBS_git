package com.dao.user.invitation;

import java.util.List;

import com.entity.Invitation;
import com.entity.Plant;
import com.entity.category;

public interface InvitationDao {

	//��ʾ����
	List<Invitation> findAll();

	//ɾ��
	int delById(String invitationId);

	//����
	int add(Invitation invi);

	//�޸�ֵ��ȡ
	Invitation findById(String invitationId);

	//�޸�
	int update(Invitation invi);

	//�����ʾ
	List<Plant> show();

	//������ʾ
	List<category> showCate();



	
	
	
}
