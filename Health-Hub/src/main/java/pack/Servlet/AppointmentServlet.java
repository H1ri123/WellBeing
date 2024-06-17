package pack.Servlet;

import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import pack.Dto.Appointment;

import java.io.IOException;

import com.Dao.AppointmentDao;

/**
 * Servlet implementation class AppointmentServlet
 */
public class AppointmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AppointmentServlet() {
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
		int userId=Integer.parseInt(request.getParameter("userid"));
		String fullname=request.getParameter("fullname");
		String gender =request.getParameter("gender");
		String age=request.getParameter("age");
		String appoint_date=request.getParameter("appoint_date");
		String email=request.getParameter("email");
		String phno=request .getParameter("phno");
		String diseases=request.getParameter("diseases");    
		int doctor_id=Integer.parseInt(request.getParameter("doct"));
	    System.out.println("doctor ID "+doctor_id);
		String address=request.getParameter("address");
		
		Appointment ap=new Appointment(userId, fullname, gender, age, appoint_date, email, phno, diseases, doctor_id, 
				address,"Pending");
		
		AppointmentDao dao=new AppointmentDao();
		
		HttpSession session=request.getSession();
		
		if(dao.addAppointment(ap))
		{
			session.setAttribute("succMsg", "Appointment SucessFully");
			response.sendRedirect("User_Appointment.jsp");
		}else
		{
			session.setAttribute("errorMsg", "SomethingWrong on Server");
			response.sendRedirect("User_Appointment.jsp");
		}
		
	}

}
