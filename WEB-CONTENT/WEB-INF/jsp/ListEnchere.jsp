<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../fragments/header.jsp" flush="true" />
<div class="container">
  <div class="row">
    <div class="col-6">
      <jsp:include page="../fragments/link.jsp" flush="true" />
    </div>
    <div class="col-6">
      <a href="<%= request.getContextPath() %>/login" class="text-end">S'inscrire - Se connecter</a>
      <c:if test="${not empty utilisateur}">
	      <nav class="navbar navbar-expand-lg">
	            <div class="container-fluid">
	            <div class="collapse navbar-collapse justify-content-end" id="navbarNavDropdown">
	                <ul class="navbar-nav">
	                <li class="nav-item">
	                    <a class="nav-link" href="#">Enchères</a>
	                </li>
	                <li class="nav-item dropdown">
	                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Vendre un article</a>
	                    <ul class="dropdown-menu">
	                    <li><a class="dropdown-item" href="#">Creer</a></li>
	                    <li><a class="dropdown-item" href="#">Modifier</a></li>
	                    </ul>
	                </li>
	                <li class="nav-item">
	                    <a class="nav-link" href="#">Mon Profil</a>
	                </li>
	                <li class="nav-item">
	                    <a class="nav-link" href="#">Deconnexion</a>
	                </li>
	                </ul>
	            </div>
	            </div>
	        </nav>
      </c:if>
        
    </div>
  </div>
  <div class="row">
    <div class="col-12">
      <h1 class="text-center">Liste des enchères</h1>
    </div>
  </div>
  <form action="" method="post">
    <div class="row">
      <div class="col-6">
        <strong>Filtres :</strong>
        <div class="input-group mb-3">
          <span class="input-group-text" id="basic-addon1">
            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
              <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"/>
            </svg>
          </span>
          <input type="text" class="form-control" placeholder="Le nom de l'article contient" aria-label="Le nom de l'article contient" aria-describedby="basic-addon1"></input>
        </div>                      
      </div>
      <div class="col-12">
        <label for="categorie">Catégorie :</label>
        <select name="categorie" id="categorie">
          <option value="all">Toutes</option>
          <c:forEach items="${categories}" var="option">
            <option value="<%-- <%= option.getId() %> --%>"><%-- <%= option.getLibelle() %> --%></option>
          </c:forEach>
        </select>
      </div>
      <div class="col-6">
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio1" value="Achats">
            <label class="form-check-label" for="inlineRadio1">Achats</label>
            <div class="form-check">
              <input class="form-check-input" type="checkbox" value="enchères terminées" id="defaultCheck1">
              <label class="form-check-label" for="defaultCheck1">
                enchères ouvertes
              </label>
            </div>
            <div class="form-check">
              <input class="form-check-input" type="checkbox" value="mes enchères en cours" id="defaultCheck2">
              <label class="form-check-label" for="defaultCheck2">
                mes enchères en cours
              </label>
            </div>
            <div class="form-check">
              <input class="form-check-input" type="checkbox" value="mes enchères remportées" id="defaultCheck3">
              <label class="form-check-label" for="defaultCheck3">
                mes emchères remportées
              </label>
            </div>
          </div>
          <div class="form-check form-check-inline">
            <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio2" value="Ventes">
            <label class="form-check-label" for="inlineRadio2">Mes ventes</label>
            <div class="form-check">
              <input class="form-check-input" type="checkbox" value="mes enchères en cours" id="defaultCheck4">
              <label class="form-check-label" for="defaultCheck4">
                mes enchères en cours
              </label>
            </div>
            <div class="form-check">
              <input class="form-check-input" type="checkbox" value="ventes non terminées" id="defaultCheck5">
              <label class="form-check-label" for="defaultCheck5">
                ventes non débutées
              </label>
            </div>
            <div class="form-check">
              <input class="form-check-input" type="checkbox" value="ventes terminées" id="defaultCheck6">
              <label class="form-check-label" for="defaultCheck6">
                ventes terminées
              </label>
            </div>
          </div>
        </div>
        <div class="col-6">
          <div class="form-check form-check-inline">
            <input type="submit" class="btn btn-primary" value="Rechercher">
          </div>
        </div>
      </div>
    </div>
  </form>

  <!-- <div class="card mb-3" style="max-width: 540px;">
      <div class="row g-0">
          <div class="col-md-4">
              <img src="..." class="img-fluid rounded-start" alt="...">
          </div>
          <div class="col-md-8">
              <div class="card-body">
                  <h5 class="card-title">Card title</h5>
                  <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                  <p class="card-text"><small class="text-body-secondary">Last updated 3 mins ago</small></p>
              </div>
          </div>
      </div>
  </div> -->
</div>
<script src="<%= request.getContextPath() %>/vendor/jquery/jquery.js"></script>
<script src="<%= request.getContextPath() %>/js/ListEnchereConnected.js"></script>
<jsp:include page="../fragments/footer.jsp" flush="true" />