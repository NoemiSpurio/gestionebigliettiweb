<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="it" class="h-100">
<head>
<meta charset="ISO-8859-1">
	<jsp:include page="../header.jsp" />
	<title>Risultato</title>
</head>
<body class="d-flex flex-column h-100">
<jsp:include page="../navbar.jsp"></jsp:include>
	
		<main class="flex-shrink-0">
		  <div class="container">
		  
		  		<div class="alert alert-success alert-dismissible fade show  ${successMessage==null?'d-none':'' }" role="alert">
				  ${successMessage}
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
				        <h5>Lista dei risultati</h5> 
				    </div>
				    <div class='card-body'>
				    	<a class="btn btn-primary " href="${pageContext.request.contextPath}/admin/PrepareInsertBigliettoServlet">Aggiungi biglietto</a>
				    
				        <div class='table-responsive'>
				            <table class='table table-striped ' >
				                <thead>
				                    <tr>
			                         	<th>Id</th>
				                        <th>Provenienza</th>
				                        <th>Destinazione</th>
				                        <th>Prezzo</th>
				                        <th>Data</th>
				                        <th>Azioni</th>
				                    </tr>
				                </thead>
				                <tbody>
				                	<c:forEach items="${listaBigliettiAttribute}" var="bigliettoItem">
				                    <tr >
				                        <td>${bigliettoItem.id}</td>
				                        <td>${bigliettoItem.provenienza}</td>
				                        <td>${bigliettoItem.destinazione}</td>
				                        <td>${bigliettoItem.prezzo}</td>
				                        <td><fmt:formatDate pattern="dd-MM-yyyy" value="${bigliettoItem.data}"/></td>
				                        <td>
											<a class="btn  btn-sm btn-outline-secondary" href="ExecuteVisualizzaBigliettoServlet?idBiglietto=${bigliettoItem.id}">Visualizza</a>
											<a class="btn  btn-sm btn-outline-primary ml-2 mr-2" href="${pageContext.request.contextPath}/admin/PrepareUpdateBigliettoServlet?idBiglietto=${bigliettoItem.id}">Modifica</a>
											<a class="btn btn-outline-danger btn-sm" href="${pageContext.request.contextPath}/admin/PrepareDeleteBigliettoServlet?idBiglietto=${bigliettoItem.id}">Rimuovi</a>
										</td>
				                    </tr>
				                    </c:forEach>
				                    
				                </tbody>
				            </table>
				        </div>
				   
					<!-- end card-body -->			   
			    </div>
			<!-- end card -->
			</div>	
		 
		   
		 <!-- end container -->  
		  </div>
		  
		</main>
		
		<!-- Footer -->
		<jsp:include page="../footer.jsp" />
</body>
</html>