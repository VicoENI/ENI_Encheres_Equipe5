<%@page import="fr.eni.encheres.dal.UtilisateurDAO"%>
<%@page import="fr.eni.encheres.bo.Utilisateur"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="../fragments/header.jsp" flush="true" />

<%Utilisateur utilisateur = (Utilisateur)session.getAttribute("utilisateur"); %>

<div class="container">
    <div class="row">
        <div class="col-6">
            <jsp:include page="../fragments/link.jsp" flush="true" />
        </div>
	 </div>
	 <h2 class="text-center">Modifier mon profil</h2>
	 	
	 <c:if test="${not empty errorMessage}">
	 	 <div class="alert alert-danger">${errorMessage}</div>
	 </c:if>
	
	 
	 <form class="row g-3" action="<%= request.getContextPath() %>/modification" method="POST">
		<input type="hidden" name="csrf_token" value="${sessionScope.csrfToken}" />       
        <%-- Récupérer les informations de l'utilisateur correspondant dans la base de données --%>
	  <div class="col-md-6">
		<label for="inputPseudo" class="form-label">Pseudo</label>
		<input type="text" class="form-control" id="pseudo" name="pseudo" value="<%= utilisateur.getPseudo() %>" required>
	  </div>
	  <div class="col-md-6">
		<label for="inputNom" class="form-label">Nom</label>
		<input type="text" class="form-control" id="nom" name="nom" value="<%= utilisateur.getNom() %>" required>
	  </div>
	  <div class="col-md-6">
		<label for="inputPenom" class="form-label">Prénom</label>
		<input type="text" class="form-control" id="inputPrenom" name="prenom" value="<%= utilisateur.getPrenom() %>" required>
	  </div>
	  <div class="col-md-6">
		<label for="inputEmail4" class="form-label">Email</label>
		<input type="email" class="form-control" id="inputEmail4" name="email" value="<%= utilisateur.getEmail() %>" required>
	  </div>
	  <div class="col-md-6">
		<label for="inputTelephone" class="form-label">Téléphone</label>
		<input type="text" class="form-control" id="inputTelephone" name="telephone" value="<%= utilisateur.getTelephone() %>" required>
	  </div>
	  <div class="col-md-6">
		<label for="inputRue" class="form-label">Rue</label>
		<input type="text" class="form-control" id="inputRue" name="rue" value="<%= utilisateur.getRue() %>" required>
	  </div>
	  <div class="col-md-6">
		<label for="inputEmail4" class="form-label">Code Postal</label>
		<input type="number" class="form-control" id="inputCodePostal" name="codepostal" value="<%= utilisateur.getCodePostal() %>" required>
	  </div>
	  <div class="col-md-6">
		<label for="inputVille" class="form-label">Ville</label>
		<input type="text" class="form-control" id="inputVille" name="ville" value="<%= utilisateur.getVille() %>" required>
	  </div>
	  <div class="row">
	  <div class="col-md-6">
		<label for="inputPassword4" class="form-label">Mot de passe actuel</label>
		<input type="password" class="form-control" name="motdepasse" id="inputPassword4" required>
	  </div> 
	  </div>
	  
	  
	  <div class="d-grid gap-5 d-md-flex justify-content-center">
		<button type="submit" class="btn btn-primary">Enregistrer</button>
		<button type="reset" class="btn btn-primary">Annuler la modification</button>
	  </div>
	</form>
</div>

<script src="<%= request.getContextPath() %>/vendor/jquery/jquery.min.js"></script>
<jsp:include page="../fragments/footer.jsp" flush="true" />