<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<jsp:include page="../fragments/header.jsp" flush="true" />
<div class="container">
    <div class="row">
        <div class="col-6">
            <jsp:include page="../fragments/link.jsp" flush="true" />
        </div>
    </div>
    <div class="row">
        <form class="center" action="<%= request.getContextPath() %>/login" method="POST">
            <div class="col-12">
                <label for="pseudo" class="form-label">Identifiant</label>
                <input type="text" class="form-control" id="pseudo">
            </div>
            <div class="col-12">
                <label for="password" class="form-label">Mot de passe</label>
                <input type="password" class="form-control" id="password">
            </div>
            <!-- <div class="mb-3 form-check">
                <input type="checkbox" class="form-check-input" id="exampleCheck1">
                <label class="form-check-label" for="exampleCheck1">Se souvenir de moi</label>
            </div> -->
            <div class="col-12">
                <button type="submit" class="btn btn-primary" name="button" value="connexion">Connexion</button>
            </div>
        </form>
    </div>
    <div class="row">
        <form action="<%= request.getContextPath() %>/inscription" method="get">
            <div class="d-grid gap-2 col-6 mx-auto">
                <button type="submit" class="btn btn-primary" name="button" value="createAccount">Créer un compte</button>
            </div>
        </form>
    </div>
</div>
<jsp:include page="../fragments/footer.jsp" flush="true" />