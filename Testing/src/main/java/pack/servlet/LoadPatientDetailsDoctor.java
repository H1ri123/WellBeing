package pack.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pack.dto.UserDTO;
import pack.service.PatientServiceImpl;
import pack.service.UserRegistrationService;
import pack.service.UserRegistrationServiceImpl;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Servlet implementation class LoadPatientDetailsDoctor
 */
public class LoadPatientDetailsDoctor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadPatientDetailsDoctor() {
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
	    String doctorName=(String) request.getAttribute("doctorName");
	    String roleName=(String) request.getAttribute("roleOfPerson");
	    System.out.println(doctorName);
	    String doctorName1=request.getParameter("doctorName");
	    System.out.println(doctorName1);
	    if(null == doctorName) {
	    	doctorName = doctorName1;
	    }
	    UserDTO doctorLogin =  new UserDTO();
		String desicisionMaking = "ErrorPage.jsp";
		doctorLogin.setDoctorName(doctorName);
		doctorLogin.setRoleOfPerson(roleName);
	    
	    PatientServiceImpl PatientService = new PatientServiceImpl();
	    
	    ArrayList<UserDTO> patientListbyDoctor=PatientService.getpatientDetailsforDoctor(doctorLogin);
   //  boolean flag= userRegistrationService.doctorValidate(DoctorLogin);
      if(patientListbyDoctor!=null) {
    	  desicisionMaking="SearchUser.jsp";
      }
      else
      {
    	  desicisionMaking = "ErrorPage.jsp";
      }
 	 request.setAttribute("patientdetails", patientListbyDoctor);
 	 request.setAttribute("loadFlag","doctor");
 	 System.out.println("decision"+request.getAttribute("loadFlag"));
      RequestDispatcher rd = request.getRequestDispatcher(desicisionMaking);

		rd.forward(request, response);
	}catch(Exception e) {
		System.out.println(e);
	}
		
		}
	
	}

