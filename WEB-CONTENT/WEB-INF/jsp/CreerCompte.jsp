<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<jsp:include page="../fragments/header.jsp" flush="true" />
<div class="container">
    <div class="row">
        <div class="col-6">
            <jsp:include page="../fragments/link.jsp" flush="true" />
        </div>
	 </div>
      <form class="row g-3">
      <h2 class="text-center">Mon profil</h2>
	  <div class="col-md-6">
	    <label for="inputPseudo" class="form-label">Pseudo *</label>
	    <input type="text" class="form-control" id="inputPseudo" required>
	  </div>
	  <div class="col-md-6">
	    <label for="inputNom" class="form-label">Nom *</label>
	    <input type="text" class="form-control" id="inputNom" required>
	  </div>
	  <div class="col-md-6">
	    <label for="inputPenom" class="form-label">Prénom *</label>
	    <input type="text" class="form-control" id="inputPrenom" required>
	  </div>
	  <div class="col-md-6">
	    <label for="inputEmail4" class="form-label">Email *</label>
	    <input type="email" class="form-control" id="inputEmail4" required>
	  </div>
	  <div class="col-md-6">
	    <label for="inputTelephone" class="form-label">Téléphone</label>
	    <input type="text" class="form-control" id="inputTelephone">
	  </div>
	  <div class="col-md-6">
	    <label for="inputRue" class="form-label">Rue *</label>
	    <input type="text" class="form-control" id="inputRue" required>
	  </div>
	  <div class="col-md-6">
	    <label for="inputEmail4" class="form-label">Code Postal *</label>
	    <input type="number" class="form-control" id="inputCodePostal" required>
	  </div>
	  <div class="col-md-6">
	    <label for="inputVille" class="form-label">Ville *</label>
	    <input type="text" class="form-control" id="inputVille" required>
	  </div>
	  <div class="col-md-6">
	    <label for="inputPassword4" class="form-label">Mot de passe *</label>
	    <input type="password" class="form-control" id="password" required>
	  </div>
	  <div class="col-md-6">
	    <label for="inputPassword4" class="form-label">Confirmation *</label>
	    <input type="password" class="form-control" id="passwordConfirmation" required>
	  </div>
	  <div class="d-grid gap-5 d-md-flex justify-content-center ">
		<button type="submit" class="btn btn-primary btn-lg">Créer</button>
		<button type="submit" class="btn btn-primary btn-lg">Annuler</button>
	  </div>
	</form>
</div>
<jsp:include page="../fragments/footer.jsp" flush="true" />