<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../fragments/header.jsp" flush="true" />
<div class="container">
    <div class="row">
        <div class="col-6">
            <jsp:include page="../fragments/link.jsp" flush="true" />
        </div>
        <div class="col-6">
            <a href="">S'inscrire - Se connecter</a>
        </div>
    </div>
    <div class="row">
        <div class="col-12">
            <h1>Liste des enchères</h1>
        </div>
    </div>
    <div class="row">
        <form action="" method="post">
            <div class="col-9">
                <label for="articleName">
                    <strong>
                        Filtres :
                    </strong>
                </label>
                <input type="text" name="articleName" id="articleName" placeholder="Le nom de l'article contient">
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
            <div class="col-3">
                <input type="submit" value="Rechercher">
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
<jsp:include page="../fragments/footer.jsp" flush="true" />