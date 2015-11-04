package CONTROLLER;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import MODEL.MODEL_Konto;

@WebServlet("/Controller")
public class CONTROLLER extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CONTROLLER_Access as;
	private HttpSession session;

	public CONTROLLER() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

		session = request.getSession(true);
		String site = (String) session.getAttribute("site");

		if (site.equals(CONTROLLER_Statments.caller.index.toString())) {
			
			String name = request.getParameter("i_username");
			String password = request.getParameter("i_passwort");
			String password_aes = request.getParameter("i_passwort_aes");
			String db = request.getParameter("i_datenbank");
			String ip = request.getParameter("i_host");
			
			
			as = CONTROLLER_Access.init();
			as.login(name, password, db,ip,password_aes);

			if (as.status()) {
				as.auslesen();

				session.setAttribute(CONTROLLER_Statments.session.mvecModel.toString(), as.getMvecModel());
				response.sendRedirect(CONTROLLER_Statments.redirect.VIEW_Konto.toString());
			} else {
				response.sendRedirect(CONTROLLER_Statments.redirect.error.toString());
			}
		}
		
		
		else if(site.equals(CONTROLLER_Statments.caller.Insert_Konto.toString()))
		{
			as.SQLModifizieren(((MODEL_Konto)session.getAttribute(CONTROLLER_Statments.session.Insert_Konto.toString())).SQLinsert(as.getAes()));
			as.auslesen();

		}
		else if(site.equals(CONTROLLER_Statments.caller.Update_Konto.toString()))
		{
			as.SQLModifizieren(((MODEL_Konto)session.getAttribute(CONTROLLER_Statments.session.Update_Konto.toString())).SQLUpdate(as.getAes()));
			as.auslesen();

		}
		else if(site.equals(CONTROLLER_Statments.caller.Delete_Konto.toString()))
		{		
			MODEL_Konto tmp = new MODEL_Konto();
			as.SQLModifizieren(tmp.SQLdelete((int)session.getAttribute(CONTROLLER_Statments.session.Delete_Konto.toString())));
			as.auslesen();
		
		}
		

	}

}
