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
	
	
	//��ʾ��������
	@Override
	public List<Invitation> findAll() {
		
		List<Invitation> list=id.findAll();
		if(list==null) {
			return null;
		}else {
			return list;
		}
		
	}

	//ͨ��id����ɾ��
	@Override
	public boolean delById(String invitationId) {
		int result=id.delById(invitationId);
		if(result>0) {
			return true;
		}
		return false;
	}

	//����
	@Override
	public boolean add(Invitation invi) {
		int result=id.add(invi);
		if(result>0) {
			return true;
		}
		return false;
	}

	//��ȡ�޸�ֵ
	@Override
	public Invitation findById(String invitationId) {
		
		Invitation result=id.findById(invitationId);
		if(result==null) {
			return null;
		}else {
			return result;
		}
		
	}

	

	//�޸�
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
	
	
	
	//������ʾ
		@Override
		public List<category> showCate() {
			List<category> list=id.showCate();
			if(list==null) {
				return null;
			}else {
				return list;
			}
		}

		
		
		//�ظ���ʾ
		@Override
		public Map<String, Object> findDetails(String invitationId) {
			Map<String, Object> ins=new HashMap<String, Object>();
			//���ָ��id�����Ӷ���
			Invitation invi=id.findById(invitationId);
			//���ָ��id����ֵ������
			List<invitation_ans> ans=ias.findByInvi(invitationId);
			ins.put("invi", invi);
			ins.put("ans", ans);
			return ins;
		}

		//�ظ�����
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
