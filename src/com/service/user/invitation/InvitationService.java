package com.service.user.invitation;

import java.util.List;
import java.util.Map;

import com.entity.Invitation;
import com.entity.Plant;
import com.entity.category;
import com.entity.invitation_ans;

public interface InvitationService {

	//显示所有页面
	List<Invitation> findAll();

	//删除
	boolean delById(String invitationId);

	//增加
	boolean add(Invitation invi);

	//修改值获取
	Invitation findById(String invitationId);

	//修改

	boolean update(Invitation invi);

	//板块显示
	List<Plant> show();

	//分类显示
	List<category> showCate();

	

	//回复显示
	Map<String, Object> findDetails(String invitationId);

	//回复增加
	boolean saveInviAns(invitation_ans ans);
	
}
