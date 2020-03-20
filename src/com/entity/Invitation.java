package com.entity;
/**
 * 帖子表
 * * @author Zylyyqx
 *
 */

import java.util.Date;

public class Invitation {
	private String invitationId;//用户账户+系统日期时间(到秒)
	private String invitationMessage;//帖子信息
	private String userId;//发帖用户ID
	private int plateId;//板块标题
	 private String plateTitle;//板块标题
	private int categoryId;//帖子分类
	 private String category;//分类名
	private int isPass;//审核状态
	private int	isEnable;//帖子是否被屏蔽
	private int isCream;//是否是精华帖
	private Date invitationCreate;//帖子发布时间
	private Date invitationModify;//最近修改时间
	
	public String getInvitationId() {
		return invitationId;
	}
	public void setInvitationId(String invitationId) {
		this.invitationId = invitationId;
	}
	public String getInvitationMessage() {
		return invitationMessage;
	}
	public void setInvitationMessage(String invitationMessage) {
		this.invitationMessage = invitationMessage;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public int getPlateId() {
		return plateId;
	}
	public void setPlateId(int plateId) {
		this.plateId = plateId;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getIsPass() {
		return isPass;
	}
	public void setIsPass(int isPass) {
		this.isPass = isPass;
	}
	public int getIsEnable() {
		return isEnable;
	}
	public void setIsEnable(int isEnable) {
		this.isEnable = isEnable;
	}
	public int getIsCream() {
		return isCream;
	}
	public void setIsCream(int isCream) {
		this.isCream = isCream;
	}
	public Date getInvitationCreate() {
		return invitationCreate;
	}
	public void setInvitationCreate(Date invitationCreate) {
		this.invitationCreate = invitationCreate;
	}
	public Date getInvitationModify() {
		return invitationModify;
	}
	public void setInvitationModify(Date invitationModify) {
		this.invitationModify = invitationModify;
	}
	
	
	public String getPlateTitle() {
		return plateTitle;
	}
	public void setPlateTitle(String plateTitle) {
		this.plateTitle = plateTitle;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	
	public Invitation(String invitationId, String invitationMessage, String userId, int plateId, int categoryId,
			int isPass, int isEnable, int isCream) {
		super();
		this.invitationId = invitationId;
		this.invitationMessage = invitationMessage;
		this.userId = userId;
		this.plateId = plateId;
		this.categoryId = categoryId;
		this.isPass = isPass;
		this.isEnable = isEnable;
		this.isCream = isCream;
	}
	
	public Invitation(String invitationId, String invitationMessage, String userId, int plateId, int categoryId) {
		super();
		this.invitationId = invitationId;
		this.invitationMessage = invitationMessage;
		this.userId = userId;
		this.plateId = plateId;
		this.categoryId = categoryId;
	}
	
	
	public Invitation(String invitationId, String invitationMessage, String userId, String plateTitle,
			String category, int isPass, int isEnable, int isCream) {
		super();
		this.invitationId = invitationId;
		this.invitationMessage = invitationMessage;
		this.userId = userId;
		this.plateTitle = plateTitle;
		this.category = category;
		this.isPass = isPass;
		this.isEnable = isEnable;
		this.isCream = isCream;
	}
	
	public Invitation(String invitationId, String invitationMessage, String userId, int plateId, int categoryId,
			Date invitationModify) {
		super();
		this.invitationId = invitationId;
		this.invitationMessage = invitationMessage;
		this.userId = userId;
		this.plateId = plateId;
		this.categoryId = categoryId;
		this.invitationModify = invitationModify;
	}
	
	public Invitation(String invitationId, String invitationMessage, String userId, String plateTitle,
			String category, int isPass, int isEnable, int isCream, Date invitationCreate, Date invitationModify) {
		super();
		this.invitationId = invitationId;
		this.invitationMessage = invitationMessage;
		this.userId = userId;
		this.plateTitle = plateTitle;
		this.category = category;
		this.isPass = isPass;
		this.isEnable = isEnable;
		this.isCream = isCream;
		this.invitationCreate = invitationCreate;
		this.invitationModify = invitationModify;
	}
	
	
	
	public Invitation(String invitationId, String invitationMessage, int plateId, int categoryId) {
		super();
		this.invitationId = invitationId;
		this.invitationMessage = invitationMessage;
		this.plateId = plateId;
		this.categoryId = categoryId;
	}
	
	
	
	
	public Invitation(String invitationMessage, int plateId, int categoryId) {
		super();
		this.invitationMessage = invitationMessage;
		this.plateId = plateId;
		this.categoryId = categoryId;
	}
	public Invitation() {
		super();
	}
	
	
}
