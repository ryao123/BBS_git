package com.dao.user.InvitationAns;

import java.util.List;

import com.entity.Invitation;
import com.entity.invitation_ans;

public interface invitationAnsDao {

	List<invitation_ans> findByInvi(String invitationId);

	//»Ø¸´Ôö¼Ó
	int saveInivAns(invitation_ans ans);

}
