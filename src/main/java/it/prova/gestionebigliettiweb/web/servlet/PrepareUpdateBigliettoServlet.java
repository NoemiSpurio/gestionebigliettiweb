package it.prova.gestionebigliettiweb.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;

import it.prova.gestionebigliettiweb.model.Biglietto;
import it.prova.gestionebigliettiweb.service.BigliettoService;
import it.prova.gestionebigliettiweb.service.MyServiceFactory;

/**
 * Servlet implementation class PrepareUpdateBigliettoServlet
 */
@WebServlet("/admin/PrepareUpdateBigliettoServlet")
public class PrepareUpdateBigliettoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// binding
		String idDaModificare = request.getParameter("idBiglietto");
		BigliettoService bigliettoServiceInstance = MyServiceFactory.getBigliettoServiceInstance();

		// validazione
		if (!NumberUtils.isCreatable(idDaModificare)) {
			request.setAttribute("errorMessage", "Attenzione, si e' verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		
		// logica di business
		Biglietto result = new Biglietto();
		try {
			result = bigliettoServiceInstance.caricaSingoloElemento(Long.parseLong(idDaModificare));
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		
		// forwarding
		request.setAttribute("dettaglioBigliettoDaModificare", result);
		request.getRequestDispatcher("/biglietto/update.jsp").forward(request, response);
	}
}
