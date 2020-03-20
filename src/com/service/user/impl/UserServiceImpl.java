package com.service.user.impl;

import java.util.Date;
import java.util.List;

import com.dao.user.UserDao;
import com.dao.user.impl.UserDaoImpl;
import com.entity.user;
import com.service.user.UserService;

public class UserServiceImpl implements UserService {

	//����dao������
	private UserDao dao=new UserDaoImpl();
	@Override
	public boolean verification(String userId, String userPsw) {
		// TODO Auto-generated method stub
		
		int result=dao.verification(userId, userPsw);
		if(result>0) {
			return true;
		}
		return false;
	}
	
	//�����Ϣ
	@Override
	public boolean memberAdd(user user) {
		// ���ӵķ���
				int result=dao.memberAdd(user);
				if(result>0) {
					return true;
				}
				return false;
		
	}

	
	  //��ʾ����
	  
	  @Override public List<user> getAll() {
	  
	  List<user> list=dao.getAll(); 
	  if(list==null) { 
		  return null; 
		  } return list; 
		  }

	
	  
	  //ɾ������
	  @Override
		public boolean userDelete(String userId) {
			int result=dao.userDelete(userId);
			if(result>0) {
				return true;
			}
			return false;
		}

	  
	  //�޸���ʾ
	@Override
	public user finduserId(String userId) {
		user result=dao.finduserId(userId);
		if(result==null) {
			return null;
		}else {
			return result;
		}
		
	}

	//�޸�
	@Override
	public boolean update(user user) {
		// ���ӵķ���
		int result=dao.update(user);
		if(result>0) {
			return true;
		}
		return false;
	}

	@Override
	public List<user> QueryUser(String userId) {
		// ��ѯ����
		List<user> result=dao.QueryUser(userId);
		if(result==null) {
			return null;
		}else {
			return result;
		}
	}

	//����ɾ��
	@Override
	public boolean delAll(String userIds) {
		// ���ַ����е���������ȥ��������ȡ[]�е�����
				userIds = userIds.substring(1, userIds.lastIndexOf("]")).replaceAll("\"", "");
				// ���ַ��ܽ��в��Ϊ����
				String[] uids = userIds.split(",");
				int result=dao.delAll(uids);
				if(result>0) {
					return true;
				}else {
					return false;
				}
	}

	

	 

}
