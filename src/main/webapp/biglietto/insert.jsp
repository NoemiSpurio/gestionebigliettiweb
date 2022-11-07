<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="it.prova.gestionebigliettiweb.model.Biglietto"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="it" class="h-100">
<head>
	<meta charset="ISO-8859-1">
	<title>Inserisci Biglietto</title>
	<jsp:include page="../header.jsp" />
</head>
<body class="d-flex flex-column h-100">
	<jsp:include page="../navbar.jsp"></jsp:include>
			
			<main class="flex-shrink-0">
			  <div class="container">
			  
			  		<div class="alert alert-danger alert-dismissible fade show ${errorMessage==null?'d-none':'' }" role="alert">
					  ${errorMessage}
					  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close" ></button>
					</div>
					<div class="alert alert-danger alert-dismissible fade show d-none" role="alert">
					  Operazione fallita!
					  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close" ></button>
					</div>
					<div class="alert alert-info alert-dismissible fade show d-none" role="alert">
					  Aggiungere d-none nelle class per non far apparire
					   <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close" ></button>
					</div>
			  
			  <div class='card'>
				    <div class='card-header'>
				        <h5>Inserisci nuovo elemento</h5> 
				    </div>
				    <div class='card-body'>
		
							<h6 class="card-title">I campi con <span class="text-danger">*</span> sono obbligatori</h6>
		
		
							<form method="post" action="ExecuteInsertBigliettoServlet" class="row g-3" novalidate="novalidate">
							
								<div class="col-md-6">
									<label for="provenienza" class="form-label">Provenienza <span class="text-danger">*</span></label>
									<input type="text" name="provenienza" id="provenienza" class="form-control" placeholder="Inserire la provenienza"  
										value="${insert_biglietto_attr.provenienza}" required>
								</div>
								
								<div class="col-md-6">
									<label for="destinazione" class="form-label">Destinazione <span class="text-danger">*</span></label>
									<input type="text" name="destinazione" id="destinazione" class="form-control" placeholder="Inserire la destinazione"  
										value="${insert_biglietto_attr.destinazione}" required>
								</div>
							
								<div class="col-md-6">
									<label for="prezzo" class="form-label">Prezzo <span class="text-danger">*</span></label>
									<input type="number" class="form-control" name="prezzo" id="prezzo" placeholder="Inserire prezzo" 
									value="${insert_biglietto_attr.prezzo}" required>
								</div>
								
								<div class="col-md-3">
									<label for="data" class="form-label">Data<span class="text-danger">*</span></label>
									<input class="form-control"  name="data" id="data" type="date" placeholder="dd/MM/yy" title="formato : gg/mm/aaaa" 
										value="<fmt:formatDate pattern="dd-MM-yyyy" value="${insert_biglietto_attr.data}"/>" required/>
								</div>
								
								
							<div class="col-12">
								<button  type="submit" name="submit" value="submit" id="submit" class="btn btn-primary">Conferma</button>
							</div>
		
						</form>		   
				    </div>
				</div>		
					   
			  </div>
			  
			</main>
			
			<jsp:include page="../footer.jsp" />
</body>
</html>