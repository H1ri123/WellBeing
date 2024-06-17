package pack.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.Dao.AppointmentDao;

/**
 * Servlet implementation class UpdateStatus
 */
public class UpdateStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStatus() {
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
			 int id=Integer.parseInt(request.getParameter("id"));
			 int did=Integer.parseInt(request.getParameter("did"));
			 String comm=request.getParameter("comm");
			 
			 AppointmentDao dao=new AppointmentDao();
				
				HttpSession session=request.getSession();
				if(dao.updateCommmentStatus(id, did, comm))
				{
					session.setAttribute("succMsg", "Comment Updated");
					response.sendRedirect("Doctor/patient.jsp");
				}else
				{
					session.setAttribute("errorMsg", "Something Wrong On Server");
					response.sendRedirect("Doctor/patient.jsp");
				}
				
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
