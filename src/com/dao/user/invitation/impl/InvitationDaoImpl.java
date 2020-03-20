package com.dao.user.invitation.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.commons.DataUtils;
import com.dao.user.invitation.InvitationDao;
import com.entity.Invitation;
import com.entity.Plant;
import com.entity.category;

public class InvitationDaoImpl implements InvitationDao {

	private Connection conn=null;
	private PreparedStatement pst=null;
	private  ResultSet rs=null;
	
	//显示所有数据
	@Override
	public List<Invitation> findAll() {
		List<Invitation> list=new ArrayList<Invitation>();
		
		try {
			String sql="SELECT i.invitationId,i.invitationMessage,i.userId,p.plateTitle,c.category,i.isPass,"
					+ "i.isEnable,i.isCream,i.invitationCreate,i.invitationModify"
					+ " FROM bbs_invitation i "
					+ "INNER JOIN bbs_plate p ON(i.`plateId`=p.`plateId`) "
					+ "INNER JOIN bbs_category c ON(i.`categoryId`=c.`categoryId`);";
			rs=DataUtils.queryAll(sql, null);
			while (rs.next()) {
				list.add(new Invitation(rs.getString("i.invitationId"),rs.getString("i.invitationMessage"),
						  rs.getString("i.userId"), rs.getString("p.plateTitle"),rs.getString("c.category") , 
						  rs.getInt("i.isPass"),rs.getInt("i.isEnable"), rs.getInt("i.isCream"),rs.getDate("i.invitationCreate"),rs.getDate("i.invitationModify")));
				  
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	//通过id进行删除
	@Override
	public int delById(String invitationId) {
		String sql="delete from bbs_invitation where invitationId=?";
	
		Object[] params= { invitationId };
		int result=DataUtils.executeUpdate(sql, params);
		return result;
	}

	//增加
	@Override
	public int add(Invitation invi) {
		
		String sql="INSERT INTO bbs_invitation(invitationId,invitationMessage,userId,plateId,"
				+ "categoryId,isPass,isEnable,isCream)"
				+ "VALUES(?,?,?,?,?,default,default,default);";
		Object[] params= {invi.getInvitationId(),invi.getInvitationMessage(),invi.getUserId(),invi.getPlateId(),
					invi.getCategoryId()};
		int num=DataUtils.executeUpdate(sql, params);
		return num;
	}

	
	//获取修改值
	@Override
	public Invitation findById(String invitationId) {
		
		  Invitation num=null; 
		  String sql="SELECT invitationMessage,plateId,categoryId FROM bbs_invitation WHERE invitationId=?"; 
		  Object[] params= {invitationId};
		  rs=DataUtils.queryAll(sql, params); 
		  try { if(rs.next()) {
			  	num=new Invitation(invitationId, rs.getString(1), rs.getInt(2), rs.getInt(3)); 
		  } }catch (SQLException e) { 
			  // TODO Auto-generated catch block
		   e.printStackTrace(); 
		   }
		 return num;
		
	
	}

	
	//修改
	@Override
	public int update(Invitation invi) {
		
		String sql="update bbs_invitation set invitationMessage=?,plateId=?,categoryId=? where invitationId=? ";
		Object[] params= {invi.getInvitationMessage(),invi.getPlateId(),invi.getCategoryId(),invi.getInvitationId()};
		
		//System.out.println(invi.getInvitationMessage());
		int result= DataUtils.executeUpdate(sql, params);
		
		return result;
	}

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



	//分类显示
	@Override
	public List<category> showCate() {
		List<category> list=new ArrayList<category>();
		String sql="SELECT *FROM bbs_category";
		Object[] params= {};
		rs=DataUtils.queryAll(sql, params);
		 
	
			try {
				while(rs.next()) {
					category category = new category(rs.getInt(1), rs.getString(2));
					list.add(category);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

		
		return list;

	}

	

	
	
	
	
	
	
	
	
	
	
}
