package SQL;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import CONTROLLER.CONTROLLER_Statments;
import MODEL.MODEL_Konto;

/**
 * Servlet implementation class Add_Produkt_SQL
 */
@WebServlet("/INSERT_Konto_SQL")
public class INSERT_Konto_SQL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public INSERT_Konto_SQL() {
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
		
		  PrintWriter out = response.getWriter(  ); 
			HttpSession session = request.getSession(true);

			session.setAttribute(CONTROLLER_Statments.session.Insert_Konto.toString(),new MODEL_Konto(
					-1,
							request.getParameter("mstrDienst"),		
							request.getParameter("mstrUsername"),
							request.getParameter("mstrantworta"),
							request.getParameter("mstrantwortb"),
							request.getParameter("mstremail"),
					request.getParameter("mstrerstellt"),
					request.getParameter("mstrfragea"),
					request.getParameter("mstrfrageb"),
					request.getParameter("mstrgeanertam"),
					request.getParameter("mstrkontakt"),
					request.getParameter("mstrpasswort"),
					request.getParameter("mstrresetemail"),
					request.getParameter("mstrreseturl"),
					request.getParameter("mstrwebseite")));

							
									
			session.setAttribute("site",CONTROLLER_Statments.caller.Insert_Konto.toString()); 

			
			
			out.println("Konto erfolgreich hinzugefuegt");
			RequestDispatcher rd = request.getRequestDispatcher(CONTROLLER_Statments.redirect.Controller.toString());
			rd.include(request, response);
			
			response.sendRedirect(CONTROLLER_Statments.redirect.VIEW_Konto.toString());	}

}
