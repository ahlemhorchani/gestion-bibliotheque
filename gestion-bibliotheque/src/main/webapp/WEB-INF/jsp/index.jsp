<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gestion de Bibliothèque</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <div class="row">
            <div class="col-12 text-center mb-4">
                <h1 class="display-4 text-primary">
                    <i class="fas fa-book"></i> Gestion de Bibliothèque
                </h1>
                <p class="lead">Système de gestion des auteurs et livres</p>
            </div>
        </div>

        <!-- Messages d'alerte -->
        <c:if test="${not empty success}">
            <div class="alert alert-success alert-dismissible fade show" role="alert">
                ${success}
                <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
            </div>
        </c:if>
        <c:if test="${not empty error}">
            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                ${error}
                <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
            </div>
        </c:if>

        <div class="row">
            <!-- Carte Auteurs -->
            <div class="col-md-6 mb-4">
                <div class="card text-white bg-primary h-100">
                    <div class="card-body text-center">
                        <i class="fas fa-users fa-3x mb-3"></i>
                        <h3 class="card-title">Auteurs</h3>
                        <h2 class="display-4">${nombreAuteurs}</h2>
                        <p class="card-text">Auteurs enregistrés</p>
                    </div>
                    <div class="card-footer text-center">
                        <a href="/web/auteurs" class="btn btn-light btn-lg">
                            <i class="fas fa-list"></i> Gérer les Auteurs
                        </a>
                    </div>
                </div>
            </div>

            <!-- Carte Livres -->
            <div class="col-md-6 mb-4">
                <div class="card text-white bg-success h-100">
                    <div class="card-body text-center">
                        <i class="fas fa-book-open fa-3x mb-3"></i>
                        <h3 class="card-title">Livres</h3>
                        <h2 class="display-4">${nombreLivres}</h2>
                        <p class="card-text">Livres enregistrés</p>
                    </div>
                    <div class="card-footer text-center">
                        <a href="/web/livres" class="btn btn-light btn-lg">
                            <i class="fas fa-book"></i> Gérer les Livres
                        </a>
                    </div>
                </div>
            </div>
        </div>

        <div class="row mt-4">
            <div class="col-12 text-center">
                <div class="btn-group" role="group">
                    <a href="/web/auteurs/nouveau" class="btn btn-outline-primary btn-lg">
                        <i class="fas fa-user-plus"></i> Nouvel Auteur
                    </a>
                    <a href="/web/livres/nouveau" class="btn btn-outline-success btn-lg">
                        <i class="fas fa-plus-circle"></i> Nouveau Livre
                    </a>
                    <a href="/api/auteurs" class="btn btn-outline-info btn-lg" target="_blank">
                        <i class="fas fa-code"></i> API Auteurs
                    </a>
                    <a href="/api/livres" class="btn btn-outline-info btn-lg" target="_blank">
                        <i class="fas fa-code"></i> API Livres
                    </a>
                </div>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>