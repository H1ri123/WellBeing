package pack.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import pack.Dto.Doctor;

import java.io.IOException;

import com.Dao.DoctorDao;

/**
 * Servlet implementation class UpdateDoctor
 */
public class UpdateDoctor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDoctor() {
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
			
		   int  id=Integer.parseInt(request.getParameter("id"));
			
			
			Doctor d=new Doctor( id,fullname, dob, qualification, spec, email, mobno, password);		
			DoctorDao dao=new DoctorDao();
		    boolean doctorNames=dao.ubdateDoctor(d);
			HttpSession session=request.getSession();
			if(doctorNames)
			{
				 session.setAttribute("succMsg", " Doctor Update Sucessfully...");
				 response.sendRedirect("admin/View_Doctor.jsp");
			}else
			{

				 session.setAttribute("errorMsg", "Something wrong in server...");
				 response.sendRedirect("admin/View_Doctor.jsp");
			}
		}catch(Exception e)
		{
			
		}
	}
	
	}

