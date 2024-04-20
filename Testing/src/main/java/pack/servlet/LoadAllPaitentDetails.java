package pack.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pack.dto.UserDTO;
import pack.service.PatientService;
import pack.service.PatientServiceImpl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Servlet implementation class LoadAllPaitentDetails
 */
public class LoadAllPaitentDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadAllPaitentDetails() {
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
		System.out.println("load all patient details");
		doGet(request, response);
		PatientService patientService  = new PatientServiceImpl();
		try {
			String decisionMaking = "ErrorPage.jsp";
			
			ArrayList<UserDTO> patientAllaDetails=patientService.getAllPatientDetails();
			
			 if (patientAllaDetails!=null) {
				 decisionMaking="SearchUser.jsp";
				 request.setAttribute("patientdetails", patientAllaDetails);
				 request.setAttribute("loadFlag","admin");
			 }
			 else {
				 decisionMaking="ErrorPage.jsp";
			 }
			 
			 RequestDispatcher rd=request.getRequestDispatcher(decisionMaking);
				
				rd.forward(request,response);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
