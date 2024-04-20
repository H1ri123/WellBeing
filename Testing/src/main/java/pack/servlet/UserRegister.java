package pack.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pack.dto.UserDTO;
import pack.service.UserRegistrationService;
import pack.service.UserRegistrationServiceImpl;

import java.io.IOException;

/**
 * Servlet implementation class UserRegister
 */
public class UserRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		try {
		String userFname=request.getParameter("fname");
		String userLname=request.getParameter("lname");
		String userGender=request.getParameter("uGender");
		String userAge=request.getParameter("age");
		String userEmail=request.getParameter("email");
		String userMobileNo=request.getParameter("mobileNo");
		String userDisease=request.getParameter("discessType");
		String userDoctorNames=request.getParameter("doctorName");
		String roleOfPerson=request.getParameter("roleOfPerson");
		String userName=request.getParameter("newname");
		String userPassword=request.getParameter("newpass");
		
		System.out.println(userFname);
		System.out.println(userLname);
		System.out.println(userGender);	
		System.out.println(userAge);	
		System.out.println(userEmail);
		System.out.println(userMobileNo);
		System.out.println(userDisease);
		System.out.println(userDoctorNames);
		System.out.println(roleOfPerson);
		System.out.println(userName);
		System.out.println(userPassword);
		  String h="LogInpage.jsp";
		 
		UserDTO user = new UserDTO();
	    user.setFirstName(userFname);
	    user.setLastName(userLname);
	    user.setUserEmail(userEmail);
	    user.setAge(userAge);
	    user.setUserName(userName);
	    user.setPassWord(userPassword);
	    user.setGender(userGender);
	    user.setMobileNo(userMobileNo);
	    user.setTypeOfDisease(userDisease);
	    user.setDoctorName(userDoctorNames);
	    user.setRoleOfPerson(roleOfPerson);
	    
	    
	    UserRegistrationService userRegistrationService=new UserRegistrationServiceImpl();
	    userRegistrationService.saveRegisterUser(user);
	    
	    
		System.out.println("ready");
	  			RequestDispatcher dispatcher =(RequestDispatcher) request.getRequestDispatcher(h);
	  		    dispatcher.forward(request, response);
		}catch (Exception e){
			System.out.println(e);
			e.printStackTrace();
		}
		
	}
		
		
		}


