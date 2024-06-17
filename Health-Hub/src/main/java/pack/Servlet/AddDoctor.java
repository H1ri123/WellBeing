package pack.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import pack.Dto.Doctor;

import java.io.IOException;

import com.Dao.DoctorDao;

/**
 * Servlet implementation class AddDoctor
 */
public class AddDoctor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDoctor() {
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
			String dob=request.getParameter("dob");
			String qualification=request.getParameter("qualification");
			String spec=request.getParameter("spec");
			String email=request.getParameter("email");
			String mobno=request.getParameter("mobno");
			String password=request.getParameter("password");
			Doctor d=new Doctor(fullname, dob, qualification, spec, email, mobno, password);		
			DoctorDao dao=new DoctorDao();
		    boolean doctorNames=dao.registerDoctor(d);
			HttpSession session=request.getSession();
			if(doctorNames)
			{
				 session.setAttribute("succMsg", " Doctor Added Sucessfully...");
				 response.sendRedirect("admin/Doctor.jsp");
			}else
			{

				 session.setAttribute("errorMsg", "Something wrong in server...");
				 response.sendRedirect("admin/Doctor.jsp");
			}
		}catch(Exception e)
		{
			
		}
	}

}
