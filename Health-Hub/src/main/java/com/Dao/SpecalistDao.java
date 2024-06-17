package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pack.Dto.Specalist;
import pack.jdbc.Connection.JdbcConnection;

public class SpecalistDao {
      public boolean specialist_List(Specalist s, String insert_specalist) throws ClassNotFoundException, SQLException {
    	    boolean specialist=false;
    	    Connection mysqlConn=JdbcConnection.getMySqlConnection();
    	   // JdbcConnection dBConnect= new JdbcConnection();
    		//Connection mysqlConn=dBConnect.getMySqlConnection();
    		PreparedStatement ps=mysqlConn.prepareStatement(insert_specalist);
    		ps.setString(1,s.getSpecalistName());
    		int  count=ps.executeUpdate();
    		if(count==1)
    		{
    			specialist=true;
    		}
		return specialist;
    	  
      }
      
		/*
		 * public List<Specalist> allSpecalistList(String result_ListOfspecalist) throws
		 * SQLException, ClassNotFoundException { JdbcConnection dBConnect= new
		 * JdbcConnection(); Connection mysqlConn=dBConnect.getMySqlConnection();
		 * List<Specalist> list=new ArrayList<Specalist>(); Specalist s=null;
		 * PreparedStatement ps=mysqlConn.prepareStatement(result_ListOfspecalist);
		 * ResultSet rs=ps.executeQuery(); while(rs.next()) { s=new Specalist();
		 * s.setId(rs.getInt(1)); s.setSpecalistName(rs.getString(2)); list.add(s); }
		 * return list;
		 * 
		 * }
		 */
      public List<Specalist> getAllSpecialist() throws ClassNotFoundException, SQLException
      {
    	    //Connection mysqlConn=JdbcConnection.getMySqlConnection();
    	  //JdbcConnection dBConnect= new JdbcConnection();
  		   Connection mysqlConn=JdbcConnection.getMySqlConnection();
    	  List<Specalist> list=new ArrayList<Specalist>();
    		Specalist s=null;
    		try {
    			 String result_ListOfspecalist="Select * from specialist";
    			 PreparedStatement ps=mysqlConn.prepareStatement(result_ListOfspecalist);
    		    	ResultSet rs=ps.executeQuery();
    		    	while(rs.next())
    		    	{
    		    		s=new Specalist();
    		    		s.setId(rs.getInt(1));
    		    		s.setSpecalistName(rs.getString(2));
    		    		list.add(s);
    		    	}
    				
    		    	  
    			 
    		}
    		catch(Exception e)
    		{
    			e.printStackTrace();
    		}
    		return list;
    		}
      }

 
