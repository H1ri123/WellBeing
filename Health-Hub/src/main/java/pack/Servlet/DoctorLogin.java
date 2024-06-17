package pack.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import pack.Dto.Doctor;
import pack.Dto.UserDetails;
import pack.service.UserRegistionServiceImpl;

import java.io.IOException;

import com.Dao.DoctorDao;

/**
 * Servlet implementation class DoctorLogin
 */
public class DoctorLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoctorLogin() {
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
			 DoctorDao dao=new DoctorDao();
			 Doctor  doctor_validate=dao.doctorLogin(email, password);
			if(doctor_validate!=null)
					{
				        session.setAttribute("docObj",doctor_validate);
				        response.sendRedirect("Doctor/index.jsp");
					} else
					{
						session.setAttribute("errorMsg","Invalid Password & email");
				        response.sendRedirect("Doctor_LogIn.jsp");
					}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
