<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="it.prova.gestionebigliettiweb.model.Biglietto"%>
<%@page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html>
<html lang="it" class="h-100">
<head>
	<jsp:include page="../header.jsp" />
	<meta charset="ISO-8859-1">
	<title>Conferma cancellazione</title>
</head>
<body class="d-flex flex-column h-100">
	<jsp:include page="../navbar.jsp"></jsp:include>
	<main class="flex-shrink-0">
			  <div class="container">
			  
			  		<div class='card'>
					    <div class='card-header'>
					        <h5>Sei sicuro di voler eliminare questo biglietto?</h5>
					    </div>
					     <% Biglietto bigliettoInPagina = (Biglietto)request.getAttribute("dettaglioBigliettoDaEliminare"); %>
					    
					
					    <div class='card-body'>
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Provenienza</dt>
							  <dd class="col-sm-9"><%=bigliettoInPagina.getProvenienza() %></dd>
					    	</dl>
					    	
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Destinazione:</dt>
							  <dd class="col-sm-9"><%=bigliettoInPagina.getDestinazione() %></dd>
					    	</dl>
					    	
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Prezzo:</dt>
							  <dd class="col-sm-9"><%=bigliettoInPagina.getPrezzo() %></dd>
					    	</dl>
					    	
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Data di Arrivo:</dt>
							  <dd class="col-sm-9"><%=bigliettoInPagina.getData()!=null? new SimpleDateFormat("dd/MM/yyyy").format(bigliettoInPagina.getData()):"N.D."  %></dd>
					    	</dl>
					    	
					    </div>
					    
					    <div class='card-footer'>				        
					        <form method="post" action="ExecuteDeleteBigliettoServlet" class="row g-3" novalidate="novalidate">
					        	<input type="hidden" name="idBiglietto" value=<%=bigliettoInPagina.getId() %>>
					        	<button type="submit" name="submit" value="submit" id="submit" class="btn btn-warning">Conferma</button>
					        </form>
					    </div>
					    
					    <div>
					     	<a href="ListBigliettoServlet" class='btn btn-outline-secondary' style='width:80px'>
					            <i class='fa fa-chevron-left'></i> Back
					        </a>
					    </div>
					</div>	
			  
			  </div>
			  
			</main>
			<jsp:include page="../footer.jsp" />
</body>
</html>