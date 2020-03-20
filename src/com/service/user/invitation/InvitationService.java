package com.service.user.invitation;

import java.util.List;
import java.util.Map;

import com.entity.Invitation;
import com.entity.Plant;
import com.entity.category;
import com.entity.invitation_ans;

public interface InvitationService {

	//��ʾ����ҳ��
	List<Invitation> findAll();

	//ɾ��
	boolean delById(String invitationId);

	//����
	boolean add(Invitation invi);

	//�޸�ֵ��ȡ
	Invitation findById(String invitationId);

	//�޸�

	boolean update(Invitation invi);

	//�����ʾ
	List<Plant> show();

	//������ʾ
	List<category> showCate();

	

	//�ظ���ʾ
	Map<String, Object> findDetails(String invitationId);

	//�ظ�����
	boolean saveInviAns(invitation_ans ans);
	
}
