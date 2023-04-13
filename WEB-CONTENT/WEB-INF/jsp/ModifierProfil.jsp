<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="../fragments/header.jsp" flush="true" />
<div class="container">
    <div class="row">
        <div class="col-6">
            <jsp:include page="../fragments/link.jsp" flush="true" />
        </div>
	 </div>
	 <h2 class="text-center">Modifier mon profil</h2>
	 <form class="row g-3" action="<%= request.getContextPath() %>/modification" method="POST">
		<input type="hidden" name="csrf_token" value="${sessionScope.csrfToken}" />
        <%-- Récupérer le pseudo de l'utilisateur connecté --%>
        <% String pseudo = (String) session.getAttribute("pseudo"); %>
        <%-- Récupérer les informations de l'utilisateur correspondant dans la base de données --%>
        <% Utilisateur utilisateur = UtilisateurDAO.getUtilisateurByPseudo(pseudo); %>
	  <div class="col-md-6">
		<label for="inputPseudo" class="form-label">Pseudo</label>
		<input type="text" class="form-control" id="inputPseudo" value="<%= utilisateur.getPseudo() %>" required>
	  </div>
	  <div class="col-md-6">
		<label for="inputNom" class="form-label">Nom</label>
		<input type="text" class="form-control" id="inputNom" value="<%= utilisateur.getNom() %>" required>
	  </div>
	  <div class="col-md-6">
		<label for="inputPenom" class="form-label">Prénom</label>
		<input type="text" class="form-control" id="inputPrenom" value="<%= utilisateur.getPrenom() %>" required>
	  </div>
	  <div class="col-md-6">
		<label for="inputEmail4" class="form-label">Email</label>
		<input type="email" class="form-control" id="inputEmail4" value="<%= utilisateur.getEmail() %>" required>
	  </div>
	  <div class="col-md-6">
		<label for="inputTelephone" class="form-label">Téléphone</label>
		<input type="text" class="form-control" id="inputTelephone" value="<%= utilisateur.getTelephone() %>" required>
	  </div>
	  <div class="col-md-6">
		<label for="inputRue" class="form-label">Rue</label>
		<input type="text" class="form-control" id="inputRue" value="<%= utilisateur.getRue() %>" required>
	  </div>
	  <div class="col-md-6">
		<label for="inputEmail4" class="form-label">Code Postal</label>
		<input type="number" class="form-control" id="inputCodePostal" value="<%= utilisateur.getCodePostal() %>" required>
	  </div>
	  <div class="col-md-6">
		<label for="inputVille" class="form-label">Ville</label>
		<input type="text" class="form-control" id="inputVille" value="<%= utilisateur.getVille() %>" required>
	  </div>
	  <div class="row">
	  <div class="col-md-6">
		<label for="inputPassword4" class="form-label">Mot de passe actuel</label>
		<input type="password" class="form-control" id="inputPassword4" required>
	  </div> 
	  </div>
	  <div class="col-md-6">
		<label for="inputPassword4" class="form-label">Nouveau mot de passe</label>
		<input type="password" class="form-control" id="inputPassword4" required>
	  </div>
	  <div class="col-md-6">
		<label for="inputPassword4" class="form-label"> Confirmation</label>
		<input type="password" class="form-control" id="inputPassword4" required>
	  </div>
	  <div class="d-grid gap-5 d-md-flex justify-content-center">
		<button type="submit" class="btn btn-primary">Enregistrer</button>
		<button type="submit" class="btn btn-primary">Annuler la modification</button>
	  </div>
	</form>
</div>

<script src="<%= request.getContextPath() %>/vendor/jquery/jquery.min.js"></script>
<jsp:include page="../fragments/footer.jsp" flush="true" />