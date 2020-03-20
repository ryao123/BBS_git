package com.commons;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * �������ݿ�Ĺ�����
 * �������Ӻ��ͷ���Դ
 * @author Effort
 *
 */
public class DataUtils {

	//����������ݿ�������ַ���
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	//�����������ݿ��URL��ַ
	private static final String URL = "jdbc:mysql://localhost:3306/bbsmanager?UseUnicode=true&characterEncoding=UTF-8";
	//�������ݿ���
	private static final String USERNAME = "root";
	//�������ݿ�����
	private static final String PASSWORD = "1234";
	 
	
	
	
	
	//����һ��������ӵķ���
		public static Connection createConnection() {
		Connection conn=null;
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	// �ͷ���Դ
	public static void closeAll(Connection conn,PreparedStatement pst,ResultSet rs) {
		try {
			if(rs != null)
				rs.close();
			if(pst != null)
				pst.close();
			if(conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//��ɾ�ĵ�ͨ�÷���
	
	public static int executeUpdate(String sql,Object ... parms) {
		Connection conn=createConnection();
		PreparedStatement pst=null;
		try {
			pst=conn.prepareStatement(sql);
			//����������ݲ�Ϊ��
			if(parms !=null) {
				//Ϊռλ����ֵ
				for(int i=0; i<parms.length;i++){
					pst.setObject((i+1), parms[i]);
				}
			}
			//���÷��������ؽ��
			return pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeAll(conn, pst, null);
		}
		
		return 0;
	}
	
	
	//ͨ�ò�ѯ����
	public static ResultSet queryAll(String sql,Object ... params) {
		ResultSet rs=null;
		Connection conn=createConnection();
		PreparedStatement pst=null;
		try {
			pst=conn.prepareStatement(sql);
			//����������ݲ�Ϊ��
			if(params !=null) {
				//Ϊռλ����ֵ
				for(int i=0; i<params.length;i++){
					pst.setObject((i+1), params[i]);
				}
			}
			rs=pst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	

}

