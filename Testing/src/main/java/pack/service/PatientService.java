/**
 * 
 */
package pack.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pack.dto.PatientDTO;
import pack.dto.UserDTO;

/**
 * 
 */
public interface PatientService {
public UserDTO loadPatientDetails(UserDTO loadPatient) throws ClassNotFoundException, SQLException;
public boolean savePatientDetails(PatientDTO savePatient) throws ClassNotFoundException, SQLException;

public ArrayList<UserDTO> getAllPatientDetails() throws ClassNotFoundException, SQLException;

public List<UserDTO> getpatientDetailsforDoctor(UserDTO loadPatientDTO) throws ClassNotFoundException, SQLException;


}
