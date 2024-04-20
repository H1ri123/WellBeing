package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.ArrayList;

import pack.dto.PatientDTO;
import pack.dto.UserDTO;
import pack.jdbc.connections.JdbcConnection;
import pack.servlet.SavePatientDetails;

public class PatientDAO {
	public UserDTO loadPatientDetails( UserDTO loadPatient , String loadPatientquery) throws ClassNotFoundException, SQLException {
		JdbcConnection userDbConnection = new JdbcConnection();
		Connection mySqlCon = userDbConnection.getMySqlConnection();
		Statement ps = mySqlCon.createStatement();
		ResultSet rs = ps.executeQuery(loadPatientquery);
		UserDTO loadDetailsForPatient=new UserDTO();
		while(rs.next()) {
			loadDetailsForPatient.setUserId(rs.getString(1));
			loadDetailsForPatient.setFirstName(rs.getString(2));
			loadDetailsForPatient.setLastName(rs.getString(3));
			loadDetailsForPatient.setGender(rs.getString(4));
			loadDetailsForPatient.setAge(rs.getString(5));
			loadDetailsForPatient.setTypeOfDisease(rs.getString(8));
			loadDetailsForPatient.setRoleOfPerson(rs.getString(10));
			loadDetailsForPatient.setDoctorName(rs.getString(9));
		    System.out.println("patient details loaded successfully");
		}
		return loadDetailsForPatient  ;
	}
	
	public boolean savePatientDetails(PatientDTO savePatient,String patientsaveQuery ) throws ClassNotFoundException, SQLException {
		JdbcConnection userDbConnection = new JdbcConnection();
		Connection mySqlCon = userDbConnection.getMySqlConnection();
		PreparedStatement ps = mySqlCon.prepareStatement(patientsaveQuery);
		PatientDTO saveDetailsForPatient= new PatientDTO();
		ps.setString(1,savePatient.getUserId());
        ps.setString(2,savePatient.getAppointmentDate() );
        
        ps.setString(3,savePatient.getDoctorPrescription());
        ps.setString(4, savePatient.getDocterFees());
        ps.setString(5,savePatient.getBalanceFees());	
        ps.setString(6,savePatient.getNextVisitDate());
        int count = ps.executeUpdate();
		System.out.println(count);
		System.out.println("inserted successfully");
		boolean flag = false;
		if(count> 0) {
              
	  		flag=true;
	  		System.out.println("inserted");
		}
		mySqlCon.close();
		return flag ;
	
	}
	public ArrayList<UserDTO> getpatientDetailsforDoctor(String doctorCheckPatientQuery) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		JdbcConnection userDbConnection = new JdbcConnection();
		Connection mySqlCon = userDbConnection.getMySqlConnection();
		PreparedStatement ps = mySqlCon.prepareStatement(doctorCheckPatientQuery);
		ResultSet rs = ps.executeQuery(doctorCheckPatientQuery);
		ArrayList<UserDTO> doctorcheckedPatientDetails = new ArrayList<UserDTO>();
		UserDTO patientDetailsForDoctor=null;
		while(rs.next()) {
		patientDetailsForDoctor =new UserDTO();
		patientDetailsForDoctor.setUserId(rs.getString(1));
		patientDetailsForDoctor.setFirstName(rs.getString(2));
		patientDetailsForDoctor.setLastName(rs.getString(3));
		patientDetailsForDoctor.setGender(rs.getString(4));
		patientDetailsForDoctor.setAge(rs.getString(5));
		patientDetailsForDoctor.setTypeOfDisease(rs.getString(8));
		patientDetailsForDoctor.setRoleOfPerson(rs.getString(10));
		patientDetailsForDoctor.setDoctorName(rs.getString(9));
		}
		doctorcheckedPatientDetails.add(patientDetailsForDoctor);
		return doctorcheckedPatientDetails;
	}

	
}	
	
	
	
	
	
	
	
	
	
	
	/*public boolean savePatientDetails(PatientDTO savePatient,String patientsaveQuery ) throws ClassNotFoundException, SQLException {
		JdbcConnection userDbConnection = new JdbcConnection();
		Connection mySqlCon = userDbConnection.getMySqlConnection();
		PreparedStatement ps = mySqlCon.prepareStatement(patientsaveQuery);
		PatientDTO saveDetailsForPatient= new PatientDTO();
		boolean flag = false;
		if(flag) {
		saveDetailsForPatient.setAppointmentDate(patientsaveQuery);
		saveDetailsForPatient.setDoctorPrescription(patientsaveQuery);
		saveDetailsForPatient.setDocterFees(patientsaveQuery);
		saveDetailsForPatient.setBalanceFees(patientsaveQuery);
		saveDetailsForPatient.setNextVisitDate(patientsaveQuery);
		flag=true;
		}
		return flag ;
	}*/

	/*
	 * public ArrayList<PatientDTO> getsavePatientDetails(String
	 * patientSaveDetailsQuery) throws SQLException, ClassNotFoundException { //
	 * TODO Auto-generated method stub JdbcConnection userDbConnection = new
	 * JdbcConnection(); Connection mySqlCon =
	 * userDbConnection.getMySqlConnection(); Statement ps =
	 * mySqlCon.createStatement(); ResultSet rs =
	 * ps.executeQuery(patientSaveDetailsQuery); ArrayList<PatientDTO>
	 * savePatientDetails=new ArrayList<PatientDTO>(); while (rs.next()) {
	 * PatientDTO savedPatientDetails = new PatientDTO ();
	 * savedPatientDetails.setUserId(rs.getString(1));
	 * savedPatientDetails.setAppointmentDate(rs.getString(2));
	 * savedPatientDetails.setDoctorPrescription(rs.getString(3));
	 * savedPatientDetails.setDocterFees(rs.getString(4));
	 * savedPatientDetails.setBalanceFees(rs.getString(5));
	 * savedPatientDetails.setNextVisitDate(rs.getString(6));
	 * savePatientDetails.add(savedPatientDetails); } return savePatientDetails ; }
	 */

