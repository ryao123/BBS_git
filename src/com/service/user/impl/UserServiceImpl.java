package com.service.user.impl;

import java.util.Date;
import java.util.List;

import com.dao.user.UserDao;
import com.dao.user.impl.UserDaoImpl;
import com.entity.user;
import com.service.user.UserService;

public class UserServiceImpl implements UserService {

	//操作dao中内容
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
	
	//添加信息
	@Override
	public boolean memberAdd(user user) {
		// 增加的方法
				int result=dao.memberAdd(user);
				if(result>0) {
					return true;
				}
				return false;
		
	}

	
	  //显示方法
	  
	  @Override public List<user> getAll() {
	  
	  List<user> list=dao.getAll(); 
	  if(list==null) { 
		  return null; 
		  } return list; 
		  }

	
	  
	  //删除方法
	  @Override
		public boolean userDelete(String userId) {
			int result=dao.userDelete(userId);
			if(result>0) {
				return true;
			}
			return false;
		}

	  
	  //修改显示
	@Override
	public user finduserId(String userId) {
		user result=dao.finduserId(userId);
		if(result==null) {
			return null;
		}else {
			return result;
		}
		
	}

	//修改
	@Override
	public boolean update(user user) {
		// 增加的方法
		int result=dao.update(user);
		if(result>0) {
			return true;
		}
		return false;
	}

	@Override
	public List<user> QueryUser(String userId) {
		// 查询数据
		List<user> result=dao.QueryUser(userId);
		if(result==null) {
			return null;
		}else {
			return result;
		}
	}

	//批量删除
	@Override
	public boolean delAll(String userIds) {
		// 将字符串中的所有引号去掉，并截取[]中的数据
				userIds = userIds.substring(1, userIds.lastIndexOf("]")).replaceAll("\"", "");
				// 将字符窜进行拆分为数组
				String[] uids = userIds.split(",");
				int result=dao.delAll(uids);
				if(result>0) {
					return true;
				}else {
					return false;
				}
	}

	

	 

}
