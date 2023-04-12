<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<jsp:include page="../fragments/header.jsp" flush="true" />
<div class="container">
    <div class="row">
        <div class="col-6">
            <jsp:include page="../fragments/link.jsp" flush="true" />
        </div>
	 </div>
	 <h2 class="text-center">Mon profil</h2>
      <form class="row g-3" action="" method="POST">
		<input type="hidden" name="csrf_token" value="${sessionScope.csrfToken}" />
		<div class="col-md-6">
			<label for="pseudo" class="form-label">Pseudo *</label>
			<input type="text" class="form-control" id="pseudo" name="pseudo" required>
		</div>
		<div class="col-md-6">
			<label for="nom" class="form-label">Nom *</label>
			<input type="text" class="form-control" id="nom" name="nom" required>
		</div>
		<div class="col-md-6">
			<label for="prenom" class="form-label">Prénom *</label>
			<input type="text" class="form-control" id="prenom" name="prenom" required>
		</div>
		<div class="col-md-6">
			<label for="email" class="form-label">Email *</label>
			<input type="email" class="form-control" id="email" name="email" required>
		</div>
		<div class="col-md-6">
			<label for="telephone" class="form-label">Téléphone</label>
			<input type="text" class="form-control" id="telephone" name="telephone">
		</div>
		<div class="col-md-6">
			<label for="rue" class="form-label">Rue *</label>
			<input type="text" class="form-control" id="rue" name="rue" required>
		</div>
		<div class="col-md-6">
			<label for="codepostal" class="form-label">Code Postal *</label>
			<input type="number" class="form-control" id="codepostal" name="codepostal" required>
		</div>
		<div class="col-md-6">
			<label for="ville" class="form-label">Ville *</label>
			<input type="text" class="form-control" id="ville" name="ville" required>
		</div>
		<div class="col-md-6">
			<label for="motdepasse" class="form-label">Mot de passe *</label>
			<input type="password" class="form-control" id="motdepasse" name="motdepasse" required>
		</div>
		<div class="col-md-6">
			<label for="confirmationmdp" class="form-label">Confirmation *</label>
			<input type="password" class="form-control" id="confirmationmdp" name="confirmationmdp" required>
		</div>
		<div class="d-grid gap-5 d-md-flex justify-content-center">
			<button type="submit" class="btn btn-primary">Enregistrer</button>
			<button type="reset" class="btn btn-primary">Annuler la modification</button>
		  </div>
	</form>
</div>
<script src="<%= request.getContextPath() %>/vendor/jquery/jquery.min.js"></script>
<jsp:include page="../fragments/footer.jsp" flush="true" />