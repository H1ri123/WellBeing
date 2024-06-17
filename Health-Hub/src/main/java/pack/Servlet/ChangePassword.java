package pack.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.Dao.UserDao;

/**
 * Servlet implementation class ChangePassword
 */
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePassword() {
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
		
		int uid=Integer.parseInt((request.getParameter("uid")));
		String oldPassword=request.getParameter("oldPassword");
		String newPassword=request.getParameter("newPassword");
		UserDao dao= new UserDao();
		HttpSession session=request.getSession();
		if(dao.checkOldPassword(uid, oldPassword))
		{
			if(dao.changePassword(uid, newPassword))
			{
				System.out.println("success password change");
			   session.setAttribute("succMsg","Password change Sucessfully...");	
			   response.sendRedirect("changePassword.jsp");
			}else {
				session.setAttribute("errorMsg","Something wrong on Server");	
				   response.sendRedirect("changePassword.jsp");
			}
		}else {
			  session.setAttribute("errorMsg"," Old Password Incorrect");	
			   response.sendRedirect("changePassword.jsp");
		}
	}

}
