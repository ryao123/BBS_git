package com.dao.user.InvitationAns.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.commons.DataUtils;
import com.dao.user.InvitationAns.invitationAnsDao;
import com.entity.Invitation;
import com.entity.invitation_ans;

public class invitationAnsDaoImpl implements invitationAnsDao {

	private ResultSet rs=null;
	
	@Override
	public List<invitation_ans> findByInvi(String invitationId) {
		List<invitation_ans> list = new ArrayList<invitation_ans>();
		try {
			String sql = "select * from bbs_invitation_ans where invitationId=?";
			Object[] params = {invitationId};
			rs = DataUtils.queryAll(sql, params);
			while (rs.next()) {
				invitation_ans ans = new invitation_ans(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getDate(5));
				list.add(ans);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DataUtils.closeAll(null, null, rs);
		}
		return list;
		
	}

	
	//»Ø¸´Ôö¼Ó
	@Override
	public int saveInivAns(invitation_ans ans) {
		String sql = "INSERT INTO bbs_invitation_ans(ansId,ansMessage,invitationId,userId) VALUES(?,?,?,?)";
		Object[] params = {ans.getAnsId(),ans.getAnsMessage(),ans.getInvitationId(),ans.getUserId()};
		return DataUtils.executeUpdate(sql, params);
	}

	
	
	
	
	
	
	
}
