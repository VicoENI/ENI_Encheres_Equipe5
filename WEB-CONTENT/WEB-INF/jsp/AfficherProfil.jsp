<%@page import="fr.eni.encheres.bo.Utilisateur"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<%Utilisateur utilisateur = (Utilisateur)request.getAttribute("utilisateur"); %>

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
          
        </ul>
      </div>
    </div>
</div>

 

<jsp:include page="../fragments/footer.jsp" flush="true" />