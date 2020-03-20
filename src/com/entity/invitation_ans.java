package com.entity;
/**
 * 回帖表
 * @author Effort
 *
 */

import java.util.Date;

public class invitation_ans {

	private String ansId;//回复id
	private String ansMessage;//回复内容
	private String invitationId;//回复帖子id
	private String userId;//回复账户id
	private Date  ansDate;//回复时间
	public String getAnsId() {
		return ansId;
	}
	public void setAnsId(String ansId) {
		this.ansId = ansId;
	}
	public String getAnsMessage() {
		return ansMessage;
	}
	public void setAnsMessage(String ansMessage) {
		this.ansMessage = ansMessage;
	}
	public String getInvitationId() {
		return invitationId;
	}
	public void setInvitationId(String invitationId) {
		this.invitationId = invitationId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getAnsDate() {
		return ansDate;
	}
	public void setAnsDate(Date ansDate) {
		this.ansDate = ansDate;
	}
	public invitation_ans(String ansId, String ansMessage, String invitationId, String userId, Date ansDate) {
		super();
		this.ansId = ansId;
		this.ansMessage = ansMessage;
		this.invitationId = invitationId;
		this.userId = userId;
		this.ansDate = ansDate;
	}
	public invitation_ans() {
		super();
	}
	public invitation_ans(String ansId, String ansMessage, String invitationId, String userId) {
		super();
		this.ansId = ansId;
		this.ansMessage = ansMessage;
		this.invitationId = invitationId;
		this.userId = userId;
	}
	
	
	
}
