<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../fragments/header.jsp" flush="true" />
<div class="container">
    <div class="row">
        <div class="col-6">
            <jsp:include page="../fragments/link.jsp" flush="true" />
        </div>
    </div>
    <div class="row">
        <div class="col-12">
            <h1>Détails vente</h1>
        </div>
    </div>
    <div>
        <input type="text" name="articleName" id="articleName" placeholder="Le nom de l'article contient">
    </div>
    <div>
        <label for="categorie">
            Catégorie :
        </label>
        <p>Nom du produit : <!--<%= article.getNom() %>--></p>
        <p>Description : <!--<%= article.getDescription() %>--></p>
        <p>Catégorie : <!--<%= article.getCategorie() %>--></p>
        <p>Meilleure offre : <!--<%= article.getMeilleureOffre() %>--> €</p>
        <p>Mise à prix : <!--<%= article.getMiseAPrix() %>--> €</p>
        <p>Fin de l'enchère : <!--<%= article.getDateFinEnchere() %>--></p>
        <p>Retrait : <!--<%= article.getRetrait() %>--></p>
        <p>Vendeur : <!--<%= article.getUtilisateur().getPseudo() %>--></p>
    </div>
    <form method="post">
        <div class="form-group">
            <label for="proposition">Ma proposition :</label>
            <input type="number" step="0.01" class="form-control" id="proposition" name="proposition" required>
        </div>
        <input type="submit" class="btn btn-warning" value="Enchérir">
    </form>
</div>
<jsp:include page="../fragments/footer.jsp" flush="true" />