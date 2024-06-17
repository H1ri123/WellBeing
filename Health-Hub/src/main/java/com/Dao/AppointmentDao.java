package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import pack.Dto.Appointment;
import pack.jdbc.Connection.JdbcConnection;

public class AppointmentDao {
	
	public boolean addAppointment(Appointment ap)
	{
		boolean appoint=false;
		try {
			 Connection mysqlConn=JdbcConnection.getMySqlConnection();
			 String appointment_Query="insert into appointment(user_id,full_name,gender,age,appoint_date,email,ph_No,diseases,doctor_id,address,status) values(?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps=mysqlConn.prepareStatement(appointment_Query);
			ps.setInt(1, ap.getUserId());
			ps.setString(2, ap.getFullName());
			ps.setString(3,ap.getGender());
			ps.setString(4, ap.getAge());
			ps.setString(5, ap.getAppointDate());
			ps.setString(6, ap.getEmail());
			ps.setString(7, ap.getPhNo());
			ps.setString(8, ap.getDiseases());
			ps.setInt(9, ap.getDoctorId());
			ps.setString(10, ap.getAddress());
			ps.setString(11, ap.getStatus());
			
       int i=ps.executeUpdate();
       if(i==1)
       {
    	   appoint=true;
       }
		} catch(Exception e)
		{
			e.printStackTrace();
		}
		return appoint;
	}
		
		public List<Appointment> getAllAppointmentByLoginUser(int userId)
		{
			List<Appointment> list=new ArrayList<Appointment>();
			Appointment ap=null;
			
			try
			{
				Connection mysqlConn=JdbcConnection.getMySqlConnection();
				String apointment_List_Query="select * from appointment where user_id=?";
				PreparedStatement ps=mysqlConn.prepareStatement(apointment_List_Query);
				ps.setInt(1, userId);
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					ap=new Appointment();
					ap.setId(rs.getInt(1));
					ap.setUserId(rs.getInt(2));
					ap.setFullName(rs.getString(3));
					ap.setGender(rs.getString(4));
					ap.setAge(rs.getString(5));
					ap.setAppointDate(rs.getString(6));
					ap.setEmail(rs.getString(7));
					ap.setPhNo(rs.getString(8));
					ap.setDiseases(rs.getString(9));
					ap.setDoctorId(rs.getInt(10));
					ap.setAddress(rs.getString(11));
					ap.setStatus(rs.getString(12));
					list.add(ap);
					
				}
			} 
			catch (Exception e)
			{
				e.printStackTrace();
			}
			return list;
		}
		
		
		
		
		public List<Appointment> getAllAppointmentByDoctorLogin(int doctorId)
		{
			List<Appointment> list=new ArrayList<Appointment>();
			Appointment ap=null;
			
			try
			{
				Connection mysqlConn=JdbcConnection.getMySqlConnection();
				String apointment_List_Query="select * from appointment where doctor_id=?";
				PreparedStatement ps=mysqlConn.prepareStatement(apointment_List_Query);
				ps.setInt(1, doctorId);
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					ap=new Appointment();
					ap.setId(rs.getInt(1));
					ap.setUserId(rs.getInt(2));
					ap.setFullName(rs.getString(3));
					ap.setGender(rs.getString(4));
					ap.setAge(rs.getString(5));
					ap.setAppointDate(rs.getString(6));
					ap.setEmail(rs.getString(7));
					ap.setPhNo(rs.getString(8));
					ap.setDiseases(rs.getString(9));
					ap.setDoctorId(rs.getInt(10));
					ap.setAddress(rs.getString(11));
					ap.setStatus(rs.getString(12));
					list.add(ap);
					
				}
			} 
			catch (Exception e)
			{
				e.printStackTrace();
			}
			return list;
		}
		
		public Appointment getAllAppointmentById(int id)
		{
			
			Appointment ap=null;
			
			try
			{
				Connection mysqlConn=JdbcConnection.getMySqlConnection();
				String commend_Entry_Query="select * from appointment where id=?";
				PreparedStatement ps=mysqlConn.prepareStatement(commend_Entry_Query);
				ps.setInt(1, id);
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					ap=new Appointment();
					ap.setId(rs.getInt(1));
					ap.setUserId(rs.getInt(2));
					ap.setFullName(rs.getString(3));
					ap.setGender(rs.getString(4));
					ap.setAge(rs.getString(5));
					ap.setAppointDate(rs.getString(6));
					ap.setEmail(rs.getString(7));
					ap.setPhNo(rs.getString(8));
					ap.setDiseases(rs.getString(9));
					ap.setDoctorId(rs.getInt(10));
					ap.setAddress(rs.getString(11));
					ap.setStatus(rs.getString(12));
					
					
				}
			} 
			catch (Exception e)
			{
				e.printStackTrace();
			}
			return ap;
		}
		
		public boolean updateCommmentStatus(int id, int doctId, String comm)
		{
			boolean UpdateCommend=false;
			try {
				Connection mysqlConn=JdbcConnection.getMySqlConnection();
				String update_Commend_Query="update appointment set status=? where id=? and doctor_id=?";
				
				PreparedStatement ps=mysqlConn.prepareStatement(update_Commend_Query);
				ps.setString(1,comm);
				ps.setInt(2, id);
				ps.setInt(3, doctId);
				int i=ps.executeUpdate();
				if(i==1)
				{
					UpdateCommend=true;
				}
			} catch (Exception e) {
				
			}
			return UpdateCommend;
		}
		
		
		public List<Appointment> getAllAppointment()
		{
			List<Appointment> list=new ArrayList<Appointment>();
			Appointment ap=null;
			
			try
			{
				Connection mysqlConn=JdbcConnection.getMySqlConnection();
				String apointment_Admin_Query="select * from appointment order by id desc";
				PreparedStatement ps=mysqlConn.prepareStatement(apointment_Admin_Query);
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					ap=new Appointment();
					ap.setId(rs.getInt(1));
					ap.setUserId(rs.getInt(2));
					ap.setFullName(rs.getString(3));
					ap.setGender(rs.getString(4));
					ap.setAge(rs.getString(5));
					ap.setAppointDate(rs.getString(6));
					ap.setEmail(rs.getString(7));
					ap.setPhNo(rs.getString(8));
					ap.setDiseases(rs.getString(9));
					ap.setDoctorId(rs.getInt(10));
					ap.setAddress(rs.getString(11));
					ap.setStatus(rs.getString(12));
					list.add(ap);
					
				}
			} 
			catch (Exception e)
			{
				e.printStackTrace();
			}
			return list;
		}
	}
