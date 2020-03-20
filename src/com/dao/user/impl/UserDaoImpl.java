package com.dao.user.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.jdt.internal.compiler.lookup.ReductionResult;

import com.commons.DataUtils;
import com.dao.user.UserDao;
import com.entity.user;

public class UserDaoImpl implements UserDao {

	Connection conn=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	@Override
	public int verification(String userId, String userPsw) {
		// 创建要执行的SQL命令
		String sql="select count(1) from bbs_user where userId=? and userPsw=?";
		//创建参数数组
		Object[] params={userId,userPsw}; 
		//调用数据库工具类执行相应的方法
		ResultSet rs=DataUtils.queryAll(sql,params);
		//处理结果集
		try {
			if(rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DataUtils.closeAll(null, null, rs);
		}
		return 0;
	}

	
	//添加用户信息
	@Override
	public int memberAdd(user user) {
		
		//创建执行SQL
		String sql="INSERT INTO  bbs_user(userId,userPsw,userEmail,userSex,userPhoto)values(?,?,?,?,?)" ;
		Object[] params= {
				user.getUserId(),user.getUserPsw(),user.getUserEmail(),user.getUserSex(),user.getUserPhoto()
		};
		
		int result=DataUtils.executeUpdate(sql, params);
		//System.out.println(user.getUserId());
		return result;
	}


	
	  //显示方法
	  
	  @Override public List<user> getAll() {
	  
	  List<user> list=new ArrayList<user>();
	  String sql= "SELECT userId,userPsw,userEmail,userSex,userPhoto,userCreateDate FROM bbs_user "; 
	  Object[] params={}; 
	  rs=DataUtils.queryAll(sql, params);
	  try { 
	
	  while(rs.next())  { 
		  user show=new user(rs.getString(1), rs.getString(2),
				  rs.getString(3),rs.getString(4),rs.getString(5),rs.getDate(6)); 
		  list.add(show);
	  		} 
	  } catch (SQLException e) 
	  {
		  // TODO Auto-generated catch block
		  e.printStackTrace();
	  }
	  return list; 
	  }


	  //删除方法
	@Override
	public int userDelete(String userId) {
		
		String sql="delete from bbs_user where userId=?";
		//创建参数数组
		Object[] params={userId}; 
		int result=DataUtils.executeUpdate(sql, params);
		
		return result;
	}


	//修改显示
	@Override
	public user finduserId(String userId) {
		user users=null;
		String sql="SELECT userId,userPsw,userEmail,userSex ,userPhoto FROM bbs_user where userId=? ";
		Object[] params= {userId};
		rs=DataUtils.queryAll(sql, params);
		try {
			if(rs.next()) {
				users=new user(rs.getString(1), rs.getString(2),
						  rs.getString(3),rs.getString(4),rs.getString(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}


	//修改
	@Override
	public int update(user user) {
		//创建执行SQL
		
				String sql="update bbs_user set userPsw=?,userEmail=?,userSex=? where userId=?" ;
				Object[] params= {
						user.getUserPsw(),user.getUserEmail(),user.getUserSex(),user.getUserId()
				};
				
				//System.out.println("用户名"+user.getUserId());
				
				int result=DataUtils.executeUpdate(sql, params);
				
				//System.out.println(result);
				
				return result;
				
				
	}
				


	//查询数据
	@Override
	public List<user> QueryUser(String userId) {
		
		List<user> list=new ArrayList<user>();
		
		try {
			String sql = "select userId,userPsw,userEmail,userSex,userPhoto,userCreateDate from bbs_user where userId like concat('%',?,'%')";
			Object[] params = {userId};
			rs = DataUtils.queryAll(sql, params);
			while (rs.next()) {
				 user show=new user(rs.getString(1), rs.getString(2),
						  rs.getString(3),rs.getString(4),rs.getString(5),rs.getDate(6)); 
				list.add(show);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DataUtils.closeAll(null, null, rs);
		}
		return list;
	}


	
	//批量删除
	@Override
	public int delAll(String[] uids) {
		StringBuffer sql = new StringBuffer("delete from bbs_user where userId in(");
		// 根据参数数组的长度，拼接锁需要的?号个数
		for (int i = 0; i < uids.length; i++) {
			sql.append("?");
			if (i != uids.length-1) {
				sql.append(",");
			}
		}
		sql.append(")");
		// delete from bbs_user where userid in(test001,test002)
		return DataUtils.executeUpdate(sql.toString(), uids);
	}
				
				
				
				
				
	}
	 


