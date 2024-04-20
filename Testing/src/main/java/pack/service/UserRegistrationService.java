package pack.service;

import java.sql.SQLException;
import java.util.ArrayList;

import pack.dto.UserDTO;

public interface UserRegistrationService {
	public void saveRegisterUser(UserDTO uesr) throws ClassNotFoundException, SQLException;

	public UserDTO userValidate(UserDTO uservalidate)throws ClassNotFoundException, SQLException, Exception;
	
	
    
}
