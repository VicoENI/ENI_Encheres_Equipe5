<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../fragments/header.jsp" flush="true" />
<div class="container">
    <div class="row">
      <div class="col-12">
        <jsp:include page="../fragments/link.jsp" flush="true" />
      </div>
    </div>
    <h2 class="text-center">Détails du profil</h2>
        <div class="row">
          <div class="col-8">
        <ul class="list-group">
          <li class="list-group-item">Pseudo : <%= utilisateur.getPseudo() %></li>
          <li class="list-group-item">Nom : <%= utilisateur.getNom() %></li>
          <li class="list-group-item">Prenom : <%= utilisateur.getPrenom() %></li>
          <li class="list-group-item">Email : <%= utilisateur.getEmail() %></li>
          <li class="list-group-item">Téléphone : <%= utilisateur.getTelephone() %></li>
          <li class="list-group-item">Rue : <%= utilisateur.getRue() %></li>
          <li class="list-group-item">Code Postal : <%= utilisateur.getCodePostal() %></li>
          <li class="list-group-item">Ville : <%= utilisateur.getVille() %></li>
        </ul>
      </div>
    </div>
</div>

 

<jsp:include page="../fragments/footer.jsp" flush="true" />