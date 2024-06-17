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
 * Servlet implementation class EditProfile
 */
public class EditProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProfile() {
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
			
			
		   int  id=Integer.parseInt(request.getParameter("id"));
			
			
			Doctor d=new Doctor( id,fullname, dob, qualification, spec, email, mobno, "");		
			DoctorDao dao=new DoctorDao();
		    boolean doctor_Edit=dao.edit_Doctor_Profile(d);
			HttpSession session=request.getSession();
			if(doctor_Edit)
			{
				Doctor update_Doctor=dao.getDoctorById(id);			
				session.setAttribute("succMsgd", " Doctor Update Sucessfully...");
				session.setAttribute("docObj",update_Doctor);
				 response.sendRedirect("Doctor/edit_Profile.jsp");
			}else
			{

				 session.setAttribute("errorMsgd", "Something wrong in server...");
				 response.sendRedirect("Doctor/edit_Profile.jsp");
			}
		}catch(Exception e)
		{
			
		}
	}
		
	}


