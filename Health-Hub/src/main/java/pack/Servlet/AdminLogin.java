package pack.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import pack.Dto.UserDetails;

import java.io.IOException;

/**
 * Servlet implementation class AdminLogin
 */
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogin() {
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
			String email=request.getParameter("email");
			String password=request.getParameter("password");
			HttpSession session=request.getSession();
			if("admin@gmail.com".equals(email)&&"admin".equals((password)))
					{
				        session.setAttribute("adminObj",new UserDetails());
				        response.sendRedirect("admin/index.jsp");
					} else
					{
						session.setAttribute("errorMsg","Invalid Password & email");
				        response.sendRedirect("admin_Login.jsp");
					}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
