package pack.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.Dao.DoctorDao;

/**
 * Servlet implementation class DeleteDoctor
 */
public class DeleteDoctor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteDoctor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			int id= Integer.parseInt(request.getParameter("id"));
			
			DoctorDao dao=new DoctorDao();
		   boolean delete_doctor_details=dao.deleteDoctor(id);
			HttpSession session=request.getSession();
			if(delete_doctor_details)
			{
				 session.setAttribute("succMsg", " Doctor Delete Sucessfully...");
				 response.sendRedirect("admin/View_Doctor.jsp");
			}else
			{

				 session.setAttribute("errorMsg", "Something wrong in server...");
				 response.sendRedirect("admin/View_Doctor.jsp");
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}

	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);


	}
}

