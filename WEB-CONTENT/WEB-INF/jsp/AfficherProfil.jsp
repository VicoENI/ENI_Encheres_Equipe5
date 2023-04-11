<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../fragments/header.jsp" flush="true" />
<div class="container">
    <div class="row">
        <div class="col-6">
            <jsp:include page="../fragments/link.jsp" flush="true" />
        </div>
	 </div>
</div>

<ul class="list-group">
  <li class="list-group-item">Pseudo : </li>
  <li class="list-group-item">Nom :</li>
  <li class="list-group-item">Prenom :</li>
  <li class="list-group-item">Email : </li>
  <li class="list-group-item">Téléphone</li>
  <li class="list-group-item">Rue :</li>
  <li class="list-group-item">Code Postal :</li>
  <li class="list-group-item">Ville : </li>
</ul>
<jsp:include page="../fragments/footer.jsp" flush="true" />