package it.prova.gestionebigliettiweb.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;

import it.prova.gestionebigliettiweb.service.MyServiceFactory;

/**
 * Servlet implementation class ExecuteVisualizzaBigliettoServlet
 */
@WebServlet("/ExecuteVisualizzaBigliettoServlet")
public class ExecuteVisualizzaBigliettoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// binding
		String idBiglietto = request.getParameter("idBiglietto");
		
		// validazione
		if (!NumberUtils.isCreatable(idBiglietto)) {
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		
		// logica di business
		try {
			request.setAttribute("visualizza_biglietto_attr", MyServiceFactory.getBigliettoServiceInstance().caricaSingoloElemento(Long.parseLong(idBiglietto)));
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		
		// forwarding
		request.getRequestDispatcher("/biglietto/show.jsp").forward(request, response);
	}

}
