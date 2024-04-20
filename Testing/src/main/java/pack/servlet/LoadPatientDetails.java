package pack.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pack.dto.UserDTO;
import pack.service.PatientServiceImpl;

import java.io.IOException;

/**
 * Servlet implementation class LoadPatientDetails
 */
public class LoadPatientDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoadPatientDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("load patient details");
		doGet(request, response);
		String userId = request.getParameter("userId");
		String decision = request.getParameter("loginFlag");
		System.out.println("user id to load" + userId);
		String pageToLoad = "ErrorPage.jsp";
		try {
			UserDTO loadPatient = new UserDTO();
			loadPatient.setUserId(userId);
			PatientServiceImpl patientDetials = new PatientServiceImpl();
			UserDTO userDto = patientDetials.loadPatientDetails(loadPatient);
			if (userDto != null) {
				pageToLoad = "PatientDetails.jsp";
				request.setAttribute("patientDetails", userDto);
				request.setAttribute("loadFlag", decision);
				System.out.println("details loaded success");
			} else {
				pageToLoad = "ErrorPage";
			}

			RequestDispatcher rd = request.getRequestDispatcher(pageToLoad);

			rd.forward(request, response);
		} catch (Exception e) {

		}

	}
}