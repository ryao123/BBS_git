package com.dao.user.plant.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.commons.DataUtils;
import com.dao.user.plant.PlantDao;
import com.entity.Plant;
import com.entity.category;
import com.entity.user;
import com.sun.org.apache.bcel.internal.generic.NEWARRAY;

public class PlantDaoImpl  extends DataUtils implements PlantDao {

	private Connection conn=null;
	private PreparedStatement pst=null;
	private ResultSet rs=null;
	
	
	@Override   
	public int savePlan(Plant plant) {

		//创建SQL命令
		String sql="insert into bbs_plate(plateTitle,plateMessage,isEnable) values(?,?,0)";
		Object[] params= {plant.getPlateTitle(),plant.getPlateMessage()};
		return DataUtils.executeUpdate(sql, params);
	}

	
	//显示所有数据
	@Override
	public List<Plant> show() {
		List<Plant> list=new ArrayList<Plant>();
		String sql="SELECT *FROM bbs_plate";
		Object[] params= {};
		rs=DataUtils.queryAll(sql, params);
		 
	
			try {
				while(rs.next()) {
					Plant plant = new Plant(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getInt(4));
					list.add(plant);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

		
		return list;
	}


	//通过id修改
	@Override
	public Plant findByid(int plateId) {
		Plant plant=null;
		String sql="select * from bbs_plate where plateId=?";
		Object[] params= {plateId};
		rs=DataUtils.queryAll(sql, params);
		
			try {
				if(rs.next()) {
					plant = new Plant(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getInt(4));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		return plant;
	}


	//修改
	@Override
	public int update(Plant plant) {
		
		String sql="update bbs_plate set plateTitle=?,plateMessage=?,isEnable=? where plateId=?";
		Object[] params= {plant.getPlateTitle(),plant.getPlateMessage(),plant.getIsEnable(),plant.getPlateId()};
		
		int result=DataUtils.executeUpdate(sql, params);
		
		//System.out.println(plant.getPlateTitle());
		
		return result;
		
	}


	//删除
	@Override
	public int delById(int plateId) {
		String sql = "delete from bbs_plate where plateId=?";
		Object[] params = {plateId};
		return DataUtils.executeUpdate(sql, params);
	}


	//批量删除
	@Override
	public int delAll(String[] uids) {
		StringBuffer sql = new StringBuffer("delete from bbs_plate where plateId in(");
		// 根据参数数组的长度，拼接锁需要的?号个数
		for (int i = 0; i < uids.length; i++) {
			sql.append("?");
			if (i != uids.length-1) {
				sql.append(",");
			}
		}
		sql.append(")");
		return DataUtils.executeUpdate(sql.toString(), uids);
	}



}
