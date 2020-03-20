package com.dao.user;

import java.util.Date;
import java.util.List;

import com.entity.user;

public interface UserDao {

	/**
	 * 
	 * @param userId  登录的用户名
	 * @param userPsw  登录的密码
	 * @return 用户名和密码相同的个数
	 */
	//验证登录方法
	int verification(String userId,String userPsw);
	
	//添加信息
	int memberAdd(user user);

	//显示
	 List<user> getAll();

	 //删除
	int userDelete(String userId);

	//修改显示
	user finduserId(String userId);

	//修改
	int update(user user);

	//查询
	List<user> QueryUser(String userId);

	int delAll(String[] uids); 
	
	
}
