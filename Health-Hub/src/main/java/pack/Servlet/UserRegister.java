package pack.Servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import pack.Dto.UserDetails;
import pack.service.UserRegistionServiceImpl;


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
			String fullname=request.getParameter("fullname");
			String email=request.getParameter("email");
			String password=request.getParameter("password");
			UserDetails u=new UserDetails(fullname,email,password);
			u.setFullName(fullname);
			u.setEmail(email);
			u.setPassword(password);
			String nextPage="signup.jsp";
			UserRegistionServiceImpl userRegistionService=new UserRegistionServiceImpl();
		   boolean f= userRegistionService.SaveRegisterUser(u);
			HttpSession session=request.getSession();  
			if(f)
			{
				session.setAttribute("sucMsg","Register SucessFully");
			}
			else
			{
				session.setAttribute("errorMsg","Register Faild");
			}
			System.out.println("ready");
  			RequestDispatcher dispatcher =(RequestDispatcher) request.getRequestDispatcher(nextPage);
  		    dispatcher.forward(request, response);
	}catch (Exception e){
		System.out.println(e);
		e.printStackTrace();
	}

}
}
