package com.service.user;

import java.util.Date;
import java.util.List;

import com.entity.user;

public interface UserService {

	/**
	 * 
	 * @param userId  ��¼���û���
	 * @param userPsw  ��¼������
	 * @return �û�����������ͬ�ĸ���
	 */
	boolean verification(String userId,String userPsw);
	
	//���
	boolean memberAdd(user user);

	
	  //��ʾ
	 List<user> getAll();

	//ɾ��
	boolean userDelete(String userId);

	//�޸���ʾ
	user finduserId(String userId);

	//�޸�
	boolean update(user user);

	List<user> QueryUser(String userId);

	boolean delAll(String userIds);

	 
	 
}
