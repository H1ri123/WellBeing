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
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Servlet implementation class UserLogIn
 */
public class UserLogIn extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserLogIn() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		try {
			String userName = request.getParameter("Uname");
			String passWord = request.getParameter("Upass");

			System.out.println(userName);
			System.out.println(passWord);

			String desicisionMaking = "ErrorPage.jsp";
			UserDTO uservalidate = new UserDTO();
			uservalidate.setUserName(userName);
			uservalidate.setPassWord(passWord);

			UserRegistrationService userRegistrationService = new UserRegistrationServiceImpl();
			UserDTO logInvalidate = userRegistrationService.userValidate(uservalidate);
			if (logInvalidate.getRoleOfPerson().equals("Admin")) {

				desicisionMaking = "LoadAllPaitentDetails";
				System.out.println("AdminEntry");

			} else if (logInvalidate.getRoleOfPerson().equals("Doctor")) {
				desicisionMaking = "LoadPatientDetailsDoctor";
				request.setAttribute("doctorName", logInvalidate.getDoctorName());
				System.out.println("DoctorEntry");

			} else {
				desicisionMaking = "ErrorPage.jsp";
			}

			// desicisionMaking = "ErrorPage.jsp";
			/*
			 * if(userName.equals("hari")&&passWord.equals("haran")); Null="confimFile.jsp";
			 */

			// System.out.println("this statement is wrong");
			RequestDispatcher rd = request.getRequestDispatcher(desicisionMaking);

			rd.forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
