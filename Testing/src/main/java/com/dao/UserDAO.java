/**
 * 
 */
package com.dao;

import java.sql.*;
import java.util.ArrayList;

import pack.dto.UserDTO;
import pack.jdbc.connections.JdbcConnection;

/**
 * 
 */

public class UserDAO {

	public void saveRegisterUser(UserDTO user, String userRegisterQuery) throws ClassNotFoundException, SQLException {
		JdbcConnection userDbConnection = new JdbcConnection();
		Connection mySqlCon = userDbConnection.getMySqlConnection();
		PreparedStatement ps = mySqlCon.prepareStatement(userRegisterQuery);
		ps.setString(1, user.getFirstName());
		ps.setString(2, user.getLastName());
		ps.setString(3, user.getGender());
		ps.setString(4, user.getAge());
		ps.setString(5, user.getUserEmail());
		ps.setString(6, user.getMobileNo());
		ps.setString(7, user.getTypeOfDisease());
		ps.setString(8, user.getDoctorName());
		ps.setString(9, user.getRoleOfPerson());
		ps.setString(10, user.getUserName());
		ps.setString(11, user.getPassWord());

		int count = ps.executeUpdate();
		System.out.println(count);
		System.out.println("inserted successfully");

	}

	public UserDTO userValidate(UserDTO userValidate, String loginCheckQuery) throws Exception, SQLException {
		JdbcConnection userDbConnection = new JdbcConnection();
		Connection mySqlCon = userDbConnection.getMySqlConnection();
		Statement ps = mySqlCon.createStatement();
		ResultSet rs = ps.executeQuery(loginCheckQuery);
		UserDTO userDto=null;
		while (rs.next()) {
			userDto=new UserDTO();
			System.out.println("UserName" + rs.getString(11));
			System.out.println("Password" + rs.getString(12));
	        userDto.setDoctorName(rs.getString(9));
	        userDto.setRoleOfPerson(rs.getString(10));
	        System.out.println("DoctorName" + rs.getString(9));
			System.out.println("Role" + rs.getString(10));
			System.out.println("login successfully");
		}
		return userDto  ;
	}

	public ArrayList<UserDTO> getAllPatientDetails(String patientDetailsQuery)
			throws SQLException, ClassNotFoundException {
		JdbcConnection userDbConnection = new JdbcConnection();
		Connection mySqlCon = userDbConnection.getMySqlConnection();
		Statement ps = mySqlCon.createStatement();
		ResultSet rs = ps.executeQuery(patientDetailsQuery);
		ArrayList<UserDTO> patientDetailsList = new ArrayList<UserDTO>();
		while (rs.next()) {
			UserDTO patientDetails = new UserDTO();
			patientDetails.setUserId(rs.getString(1));
			patientDetails.setFirstName(rs.getString(2));
			patientDetails.setLastName(rs.getString(3));
			patientDetails.setGender(rs.getString(4));
			patientDetails.setAge(rs.getString(5));
			patientDetails.setTypeOfDisease(rs.getString(8));
			patientDetails.setRoleOfPerson(rs.getString(10));
			patientDetails.setDoctorName(rs.getString(9));
			// need to add
			patientDetailsList.add(patientDetails);

		}
		return patientDetailsList;

	}


}