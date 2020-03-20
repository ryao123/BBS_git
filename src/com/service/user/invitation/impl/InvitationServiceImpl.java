package com.service.user.invitation.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dao.user.InvitationAns.invitationAnsDao;
import com.dao.user.InvitationAns.impl.invitationAnsDaoImpl;
import com.dao.user.invitation.InvitationDao;
import com.dao.user.invitation.impl.InvitationDaoImpl;
import com.entity.Invitation;
import com.entity.Plant;
import com.entity.category;
import com.entity.invitation_ans;
import com.service.user.invitation.InvitationService;

public class InvitationServiceImpl implements InvitationService {

	InvitationDao id=new InvitationDaoImpl();
	invitationAnsDao ias=new invitationAnsDaoImpl();
	
	
	//显示所有数据
	@Override
	public List<Invitation> findAll() {
		
		List<Invitation> list=id.findAll();
		if(list==null) {
			return null;
		}else {
			return list;
		}
		
	}

	//通过id进行删除
	@Override
	public boolean delById(String invitationId) {
		int result=id.delById(invitationId);
		if(result>0) {
			return true;
		}
		return false;
	}

	//增加
	@Override
	public boolean add(Invitation invi) {
		int result=id.add(invi);
		if(result>0) {
			return true;
		}
		return false;
	}

	//获取修改值
	@Override
	public Invitation findById(String invitationId) {
		
		Invitation result=id.findById(invitationId);
		if(result==null) {
			return null;
		}else {
			return result;
		}
		
	}

	

	//修改
	@Override
	public boolean update(Invitation invi) {
		int result=id.update(invi);
		if(result>0) {
			return true;
		}
		return false;
	}



	@Override
	public List<Plant> show() {
		List<Plant> list=id.show();
		if(list==null) {
			return null;
		}else {
			return list;
		}
	}
	
	
	
	//分类显示
		@Override
		public List<category> showCate() {
			List<category> list=id.showCate();
			if(list==null) {
				return null;
			}else {
				return list;
			}
		}

		
		
		//回复显示
		@Override
		public Map<String, Object> findDetails(String invitationId) {
			Map<String, Object> ins=new HashMap<String, Object>();
			//获得指定id的帖子对象
			Invitation invi=id.findById(invitationId);
			//获得指定id返回值的数据
			List<invitation_ans> ans=ias.findByInvi(invitationId);
			ins.put("invi", invi);
			ins.put("ans", ans);
			return ins;
		}

		//回复增加
		@Override
		public boolean saveInviAns(invitation_ans ans) {
			int result = ias.saveInivAns(ans);
			if (result > 0) {
				return true;
			}else {
				return false;
			}
		}

	
	
}
