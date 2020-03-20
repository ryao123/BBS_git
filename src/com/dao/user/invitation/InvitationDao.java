package com.dao.user.invitation;

import java.util.List;

import com.entity.Invitation;
import com.entity.Plant;
import com.entity.category;

public interface InvitationDao {

	//显示数据
	List<Invitation> findAll();

	//删除
	int delById(String invitationId);

	//增加
	int add(Invitation invi);

	//修改值获取
	Invitation findById(String invitationId);

	//修改
	int update(Invitation invi);

	//板块显示
	List<Plant> show();

	//分类显示
	List<category> showCate();



	
	
	
}
