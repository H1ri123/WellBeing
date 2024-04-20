package pack.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pack.dto.PatientDTO;
import pack.service.PatientServiceImpl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Servlet implementation class SavePatientDetails
 */
public class SavePatientDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

//    /**
//     * @see HttpServlet#HttpServlet()
//     */
	public SavePatientDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
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
		try {
			doGet(request, response);
			System.out.println("Save patient details called");
			String decision = request.getParameter("loginFlag");
			String doctorName = request.getParameter("doctorName");
			String UserId = request.getParameter("userId");
			String appointment = request.getParameter("appointment");
			String doctorPrescription = request.getParameter("doctorPrescription");
			String doctorFees = request.getParameter("doctorFees");
			String balanceFees = request.getParameter("balanceFees");
			String nextVisitdate = request.getParameter("nextVisitdate");

			System.out.println(doctorName);
			System.out.println(decision);
			System.out.println(appointment);
			System.out.println(doctorPrescription);
			System.out.println(doctorFees);
			System.out.println(balanceFees);
			System.out.println(nextVisitdate);

			String decisionPage = "ErrorPage.jsp";

			PatientDTO savePatient = new PatientDTO();
			savePatient.setUserId(UserId);
			savePatient.setAppointmentDate(appointment);
			savePatient.setDoctorPrescription(doctorPrescription);
			savePatient.setDocterFees(doctorFees);
			savePatient.setBalanceFees(balanceFees);
			savePatient.setNextVisitDate(nextVisitdate);

			PatientServiceImpl patientService = new PatientServiceImpl();
			boolean flag = patientService.savePatientDetails(savePatient);
			if (flag && decision.equals("doctor")) {
				System.out.println("desicion");
				decisionPage = "LoadPatientDetailsDoctor";
				// request.setAttribute("doctorName", doctorName);
				RequestDispatcher rd = request.getRequestDispatcher(decisionPage);
				rd.forward(request, response);
				return;
			} else {
				System.out.println("desicion1");
				decisionPage = "ErrorPage.jsp";
				RequestDispatcher rd = request.getRequestDispatcher(decisionPage);
				rd.forward(request, response);
				return;
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
