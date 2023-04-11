<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../fragments/header.jsp" flush="true" />
<div class="container">
    <div class="row">
        <div class="col-6">
            <jsp:include page="../fragments/link.jsp" flush="true" />
        </div>
        <div class="col-6">
            <a href="<%= request.getContextPath() %>/ServletConnection" class="text-end">S'inscrire - Se connecter</a>
        </div>
    </div>
    <div class="row">
        <div class="col-12" class="text-center">
            <h1>Liste des enchères</h1>
        </div>
    </div>
    <div class="row">
        <form action="" method="post">
            <div class="col-9">
                <label for="articleName">
                    <div>
                        <strong>
                        Filtres :
                        </strong>
                        <div class="input-group mb-3">
                            <span class="input-group-text" id="basic-addon1">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
                                    <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"/>
                                </svg>
                            </span>
                            <input type="text" class="form-control" placeholder="Le nom de l'article contient" aria-label="Le nom de l'article contient" aria-describedby="basic-addon1"></input>
                      </div>                      
                </label>
                <div input type="text" name="articleName" id="articleName" placeholder="Le nom de l'article contient">
                <label for="categorie">
                    Catégorie :
                </label>
                <select name="categorie" id="categorie">
                    <option value="all">Toutes</option>
                    <c:forEach items="${categories}" var="option">
                        <option value="<%-- <%= option.getId() %> --%>"><%-- <%= option.getLibelle() %> --%></option>
                    </c:forEach>
                </select>
            </div>
                <div class="form-check form-check-inline">
                    <c:if isConnected(true)>
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
                  <div class="form-check form-check-inline">
                    <input type="submit" class="btn btn-primary" value="Rechercher">
                  </div>
                </c:if>
                </div>
            </div>
        </form>
    </div>
    <div class="card mb-3" style="max-width: 540px;">
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
    </div>
</div>
<script src="/WEB-CONTENT/ListEnchereConnected.js"></script>
<jsp:include page="../fragments/footer.jsp" flush="true" />