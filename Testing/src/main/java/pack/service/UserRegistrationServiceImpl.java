package pack.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.dao.UserDAO;

import pack.dto.UserDTO;

public class UserRegistrationServiceImpl implements UserRegistrationService {

	public void saveRegisterUser(UserDTO user) throws ClassNotFoundException, SQLException {
		UserDAO userDao = new UserDAO();
		String userRegisterQuery = "insert into Register(FISRTNAME,LASTNAME,GENDER,AGE,EMAIL,MOBILE_NO,DISEASE,DOCTER_NAME,ROLE,USERNAME,PASSWORD) values(?,?,?,?,?,?,?,?,?,?,?)";

		userDao.saveRegisterUser(user, userRegisterQuery);
	}
	
	public UserDTO userValidate(UserDTO userValidate) throws Exception , SQLException {
		// TODO Auto-generated method stub
		
		UserDAO userDao=new UserDAO();
		String loginCheckQuery="Select * from Register where USERNAME ='"+userValidate.getUserName()+"' and PASSWORD = '"+userValidate.getPassWord()+"'";
		UserDTO  flag = userDao.userValidate(userValidate, loginCheckQuery);
		return flag;
		}

	
	
}
