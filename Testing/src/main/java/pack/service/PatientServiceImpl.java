/**
 * 
 */
package pack.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.dao.PatientDAO;
import com.dao.UserDAO;

import pack.dto.PatientDTO;
import pack.dto.UserDTO;

/**
 * 
 */ 
public  class PatientServiceImpl implements PatientService {

	public UserDTO loadPatientDetails(UserDTO loadPatient) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
	      PatientDAO patientDao= new PatientDAO();
		 String  loadPatientquery="Select * from Register where USER_ID ='"+loadPatient.getUserId()+"'";
		 return patientDao.loadPatientDetails(loadPatient, loadPatientquery);
	}
	@Override
	public  boolean savePatientDetails(PatientDTO savePatient) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		PatientDAO patientDao =new PatientDAO();
		String patientsaveQuery= "insert into PATIENT_DETAILS(USER_ID,APPONITMENT,DOCTOR_PRESCRIPTION,DOCTOR_FEES,BALANCE_FEES,NEXT_VISITDATE)values(?,?,?,?,?,?)";
		boolean flag=patientDao.savePatientDetails(savePatient, patientsaveQuery);
		
		
		return flag;
	}
	
	 @Override
		public ArrayList<UserDTO> getpatientDetailsforDoctor(UserDTO loadPatientDTO) throws ClassNotFoundException, SQLException {
			// TODO Auto-generated method stub
			UserDAO userDao= new UserDAO();
			String doctorCheckPatientQuery="Select * from Register where DOCTER_NAME='"+loadPatientDTO.getDoctorName()+"' and ROLE='patient'";
			System.out.println(doctorCheckPatientQuery);
			return userDao.getAllPatientDetails(doctorCheckPatientQuery);
		}
	@Override
	public ArrayList<UserDTO> getAllPatientDetails() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
	     UserDAO userDao =new UserDAO();
	     String patientDetailsQuery="select * from Register where ROLE='patient'";
		return userDao.getAllPatientDetails(patientDetailsQuery);
	}
	

	}


	


