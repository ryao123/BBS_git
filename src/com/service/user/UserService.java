package com.service.user;

import java.util.Date;
import java.util.List;

import com.entity.user;

public interface UserService {

	/**
	 * 
	 * @param userId  登录的用户名
	 * @param userPsw  登录的密码
	 * @return 用户名和密码相同的个数
	 */
	boolean verification(String userId,String userPsw);
	
	//添加
	boolean memberAdd(user user);

	
	  //显示
	 List<user> getAll();

	//删除
	boolean userDelete(String userId);

	//修改显示
	user finduserId(String userId);

	//修改
	boolean update(user user);

	List<user> QueryUser(String userId);

	boolean delAll(String userIds);

	 
	 
}
