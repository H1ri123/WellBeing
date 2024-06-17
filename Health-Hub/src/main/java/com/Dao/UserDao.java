package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import pack.Dto.UserDetails;
import pack.jdbc.Connection.JdbcConnection;

public class UserDao {
	public boolean SaveRegisterUser(UserDetails u, String insert_User) throws ClassNotFoundException, SQLException {
	JdbcConnection dBConnect= new JdbcConnection();
	Connection mysqlConn=dBConnect.getMySqlConnection();
	boolean userSave=false;
	    PreparedStatement ps=mysqlConn.prepareStatement(insert_User);
	    ps.setString(1, u.getFullName());
	    ps.setString(2, u.getEmail());
	    ps.setString(3, u.getPassword());
	    int count = ps.executeUpdate();
	    if(count==1)
	    {
	    	userSave=true;
	    }
		System.out.println(count);
		System.out.println("inserted successfully");
		return userSave;
	}

	public UserDetails Logincheck(UserDetails u, String userLogin_Check) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		JdbcConnection userDbConnection = new JdbcConnection();
		Connection mySqlCon = userDbConnection.getMySqlConnection();
		//PreparedStatement ps=mySqlCon.prepareStatement(userLogin_Check);
		Statement ps = mySqlCon.createStatement();
		ResultSet rs = ps.executeQuery(userLogin_Check);
		UserDetails userDetails=null;
		while (rs.next()) {
			userDetails=new UserDetails();
			userDetails.setId(rs.getInt(1));
			userDetails.setFullName(rs.getString(2));
			userDetails.setEmail(rs.getString(3));
			userDetails.setPassword(rs.getString(4));
		}
		return userDetails ;
	}
		
		 public boolean  checkOldPassword(int userId, String oldPassword)
		{
			boolean oldPs=false;
			
			try {
				String old_password_check="select * from user_Dets where id=? and password=?";
				Connection mysqlConn=JdbcConnection.getMySqlConnection();
				PreparedStatement ps=mysqlConn.prepareStatement(old_password_check);
				ps.setInt(1, userId);
				ps.setString(2, oldPassword);
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					oldPs=true;
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		   return oldPs;
		}
		 
		 
		 public boolean  changePassword(int userId, String newPassword)
			{
				boolean updatePs=false;
				
				try {
					String Update_password_check="update user_Dets set password=? where id=?";
					Connection mysqlConn=JdbcConnection.getMySqlConnection();
					PreparedStatement ps=mysqlConn.prepareStatement(Update_password_check);
					ps.setString(1,newPassword );
					ps.setInt(2,userId);
					int i= ps.executeUpdate();
					if(i==1)
					{
						updatePs=true;
					}
					
				} catch (Exception e) {
					// TODO: handle exception
				}
			   return updatePs;
			}
}
