package com.entity;
/**
 * Ä£¿éÀà
 * @author Effort
 *
 */
public class Plant {

	private int plateId;
	private String plateTitle;
	private String plateMessage;
	private int isEnable;
	public int getPlateId() {
		return plateId;
	}
	public void setPlateId(int plateId) {
		this.plateId = plateId;
	}
	public String getPlateTitle() {
		return plateTitle;
	}
	public void setPlateTitle(String plateTitle) {
		this.plateTitle = plateTitle;
	}
	public String getPlateMessage() {
		return plateMessage;
	}
	public void setPlateMessage(String plateMessage) {
		this.plateMessage = plateMessage;
	}
	public int getIsEnable() {
		return isEnable;
	}
	public void setIsEnable(int isEnable) {
		this.isEnable = isEnable;
	}
	public Plant(String plateTitle, String plateMessage) {
		super();
		this.plateTitle = plateTitle;
		this.plateMessage = plateMessage;
	}
	public Plant(int plateId, String plateTitle, String plateMessage, int isEnable) {
		super();
		this.plateId = plateId;
		this.plateTitle = plateTitle;
		this.plateMessage = plateMessage;
		this.isEnable = isEnable;
	}
	public Plant(String plateTitle, String plateMessage, int isEnable) {
		super();
		this.plateTitle = plateTitle;
		this.plateMessage = plateMessage;
		this.isEnable = isEnable;
	}
	
	
}
