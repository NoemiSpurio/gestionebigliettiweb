package it.prova.gestionebigliettiweb.web.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;

import it.prova.gestionebigliettiweb.model.Biglietto;
import it.prova.gestionebigliettiweb.service.MyServiceFactory;

/**
 * Servlet implementation class ExecuteSearchBigliettoServlet
 */
@WebServlet("/ExecuteSearchBigliettoServlet")
public class ExecuteSearchBigliettoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// binding
		Biglietto input = new Biglietto();
		if (!request.getParameter("provenienza").isBlank())
			input.setProvenienza(request.getParameter("provenienza"));
		else
			input.setProvenienza("");
		if (!request.getParameter("destinazione").isBlank())
			input.setDestinazione(request.getParameter("destinazione"));
		else
			input.setDestinazione("");
		if (NumberUtils.isCreatable(request.getParameter("prezzo")))
			input.setPrezzo(Integer.parseInt(request.getParameter("prezzo")));
		else
			input.setPrezzo(0);
		if (!request.getParameter("data").isBlank())
			try {
				input.setData(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("data")));
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
		else
			input.setData(null);

		// logica di business
		try {
			request.setAttribute("listaBigliettiAttribute",
					MyServiceFactory.getBigliettoServiceInstance().trovaByExample(input));
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
