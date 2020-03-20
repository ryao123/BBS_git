package com.dao.user;

import java.util.Date;
import java.util.List;

import com.entity.user;

public interface UserDao {

	/**
	 * 
	 * @param userId  ��¼���û���
	 * @param userPsw  ��¼������
	 * @return �û�����������ͬ�ĸ���
	 */
	//��֤��¼����
	int verification(String userId,String userPsw);
	
	//�����Ϣ
	int memberAdd(user user);

	//��ʾ
	 List<user> getAll();

	 //ɾ��
	int userDelete(String userId);

	//�޸���ʾ
	user finduserId(String userId);

	//�޸�
	int update(user user);

	//��ѯ
	List<user> QueryUser(String userId);

	int delAll(String[] uids); 
	
	
}
