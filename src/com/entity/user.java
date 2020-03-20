package com.entity;

import java.util.Date;

public class user {
	private String userId;	//账户id
	private String userPsw;	//密码
	private String userEmail; //邮箱
	private String userSex; //性别
	private String userPhoto; //头像
	private double userScore; //积分
	private int userLevel; //等级
	private Date levelDown; //降级截止日期
	private Date userLock; //锁定截至日期
	private Date userCreateDate; //创建日期
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPsw() {
		return userPsw;
	}
	public void setUserPsw(String userPsw) {
		this.userPsw = userPsw;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserSex() {
		return userSex;
	}
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	public String getUserPhoto() {
		return userPhoto;
	}
	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}
	public double getUserScore() {
		return userScore;
	}
	public void setUserScore(double userScore) {
		this.userScore = userScore;
	}
	public int getUserLevel() {
		return userLevel;
	}
	public void setUserLevel(int userLevel) {
		this.userLevel = userLevel;
	}
	public Date getLevelDown() {
		return levelDown;
	}
	public void setLevelDown(Date levelDown) {
		this.levelDown = levelDown;
	}
	public Date getUserLock() {
		return userLock;
	}
	public void setUserLock(Date userLock) {
		this.userLock = userLock;
	}
	public Date getUserCreateDate() {
		return userCreateDate;
	}
	public void setUserCreateDate(Date userCreateDate) {
		this.userCreateDate = userCreateDate;
	}
	public user(String userId, String userPsw, String userEmail, String userSex) {
		super();
		this.userId = userId;
		this.userPsw = userPsw;
		this.userEmail = userEmail;
		this.userSex = userSex;
	}
	public user(String userId, String userPsw, String userEmail, String userSex, String userPhoto, double userScore,
			int userLevel, Date levelDown, Date userLock, Date userCreateDate) {
		super();
		this.userId = userId;
		this.userPsw = userPsw;
		this.userEmail = userEmail;
		this.userSex = userSex;
		this.userPhoto = userPhoto;
		this.userScore = userScore;
		this.userLevel = userLevel;
		this.levelDown = levelDown;
		this.userLock = userLock;
		this.userCreateDate = userCreateDate;
	}
	public user(String userId, String userEmail, String userSex, Date userCreateDate) {
		super();
		this.userId = userId;
		this.userEmail = userEmail;
		this.userSex = userSex;
		this.userCreateDate = userCreateDate;
	}
	public user(String userId, String userPsw, String userEmail, String userSex, String userPhoto) {
		super();
		this.userId = userId;
		this.userPsw = userPsw;
		this.userEmail = userEmail;
		this.userSex = userSex;
		this.userPhoto = userPhoto;
	}
	public user(String userId, Date levelDown, Date userLock) {
		super();
		this.userId = userId;
		this.levelDown = levelDown;
		this.userLock = userLock;
	}
	
	
	
	
	
	public user(String userId, String userPsw, String userEmail, String userSex, String userPhoto,
			Date userCreateDate) {
		super();
		this.userId = userId;
		this.userPsw = userPsw;
		this.userEmail = userEmail;
		this.userSex = userSex;
		this.userPhoto = userPhoto;
		this.userCreateDate = userCreateDate;
	}
	public user() {
		super();
	}
	
	
	
	
	
}
