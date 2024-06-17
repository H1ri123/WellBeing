package pack.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import pack.Dto.Specalist;
import pack.Dto.UserDetails;
import pack.service.SpecalistRegistionServiceImpl;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Servlet implementation class AddSpecialist
 */
public class AddSpecialist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSpecialist() {
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
		String specName=request.getParameter("specName");
		Specalist specalist=new Specalist();
		specalist.setSpecalistName(specName);
		SpecalistRegistionServiceImpl specalistRegistionService =new SpecalistRegistionServiceImpl();
		 
			boolean specalistadd=specalistRegistionService.addSpecialiist(specalist);
			HttpSession session=request.getSession();
			if(specalistadd)
					{
				        session.setAttribute("succMsg","Specialist Added");
				        response.sendRedirect("admin/index.jsp");
					} else
					{
						session.setAttribute("errorMsg","Something wrong on server");
				        response.sendRedirect("admin/index.jsp");
					}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
