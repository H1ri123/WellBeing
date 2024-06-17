package pack.service;

import java.sql.SQLException;

import pack.Dto.UserDetails;

public interface UserRegistionService {
	public boolean SaveRegisterUser(UserDetails u) throws ClassNotFoundException, SQLException;
	
	public UserDetails UserLogincheck(UserDetails u) throws ClassNotFoundException, SQLException;

}
