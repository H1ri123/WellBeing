package pack.service;

import java.sql.SQLException;

import com.Dao.UserDao;

import pack.Dto.UserDetails;


public class UserRegistionServiceImpl implements UserRegistionService {

	@Override
	public boolean SaveRegisterUser(UserDetails u) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		UserDao userDao=new UserDao();
		String insert_User="insert into user_Dets(full_name,email,password) values(?,?,?)";
		
		return userDao.SaveRegisterUser(u,insert_User);
	}
	
	
	@Override
	public UserDetails UserLogincheck(UserDetails u) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		UserDao userDao=new UserDao();
		
		String userLogin_Check="Select * from user_Dets where email ='"+u.getEmail()+"' and password = '"+u.getPassword()+"'";
		System.out.println("result user validate");
		UserDetails  flag = userDao.Logincheck(u, userLogin_Check);
		return flag;
		
	}

}
