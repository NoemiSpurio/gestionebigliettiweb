package it.prova.gestionebigliettiweb.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.gestionebigliettiweb.model.Biglietto;
import it.prova.gestionebigliettiweb.service.MyServiceFactory;
import it.prova.gestionebigliettiweb.utility.UtilityBigliettoForm;

/**
 * Servlet implementation class ExecuteUpdateBigliettoServlet
 */
@WebServlet("/admin/ExecuteUpdateBigliettoServlet")
public class ExecuteUpdateBigliettoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// binding
		String provenienzaParam = request.getParameter("provenienza");
		String destinazioneParam = request.getParameter("destinazione");
		String prezzoParam = request.getParameter("prezzo");
		String dataParam = request.getParameter("data");

		// validazione
		Biglietto bigliettoInstance = UtilityBigliettoForm.createBigliettoFromParams(provenienzaParam,
				destinazioneParam, dataParam, prezzoParam);
		if (!UtilityBigliettoForm.validateBigliettoBean(bigliettoInstance)) {
			request.setAttribute("errorMessage", "Attenzione, sono presenti errori di validazione.");
			try {
				request.setAttribute("dettaglioBigliettoDaModificare", MyServiceFactory.getBigliettoServiceInstance()
						.caricaSingoloElemento(Long.parseLong(request.getParameter("idBiglietto"))));
			} catch (Exception e) {
				e.printStackTrace();
			}
			request.getRequestDispatcher("/biglietto/update.jsp").forward(request, response);
			return;
		}
		
		// logica di business
		try {
			bigliettoInstance.setId(Long.parseLong(request.getParameter("idBiglietto")));
			MyServiceFactory.getBigliettoServiceInstance().aggiorna(bigliettoInstance);
			request.setAttribute("listaBigliettiAttribute", MyServiceFactory.getBigliettoServiceInstance().listAll());
			request.setAttribute("successMessage", "Operazione effettuata con successo!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		
		// forwarding
		request.getRequestDispatcher("/biglietto/results.jsp").forward(request, response);
	}

}
