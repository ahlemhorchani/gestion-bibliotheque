<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gestion des Auteurs</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-4">
        <!-- En-tête -->
        <div class="d-flex justify-content-between align-items-center mb-4">
            <h1 class="text-primary">
                <i class="fas fa-users"></i> Gestion des Auteurs
            </h1>
            <div>
                <a href="/web/" class="btn btn-outline-secondary">
                    <i class="fas fa-home"></i> Accueil
                </a>
                <a href="/web/auteurs/nouveau" class="btn btn-primary">
                    <i class="fas fa-user-plus"></i> Nouvel Auteur
                </a>
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

        <!-- Tableau des auteurs -->
        <div class="card">
            <div class="card-header bg-primary text-white">
                <h5 class="mb-0">
                    <i class="fas fa-list"></i> Liste des Auteurs (${auteurs.size()})
                </h5>
            </div>
            <div class="card-body">
                <c:choose>
                    <c:when test="${not empty auteurs}">
                        <div class="table-responsive">
                            <table class="table table-striped table-hover">
                                <thead class="table-dark">
                                    <tr>
                                        <th>ID</th>
                                        <th>Nom</th>
                                        <th>Prénom</th>
                                        <th>Actions</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="auteur" items="${auteurs}">
                                        <tr>
                                            <td>${auteur.id}</td>
                                            <td>${auteur.nom}</td>
                                            <td>${auteur.prenom}</td>
                                            <td>
                                                <a href="/web/livres/auteur/${auteur.id}" class="btn btn-info btn-sm">
                                                    <i class="fas fa-book"></i> Livres
                                                </a>
                                                <a href="/web/auteurs/supprimer/${auteur.id}" 
                                                   class="btn btn-danger btn-sm"
                                                   onclick="return confirm('Êtes-vous sûr de vouloir supprimer cet auteur ?')">
                                                    <i class="fas fa-trash"></i> Supprimer
                                                </a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class="alert alert-warning text-center">
                            <i class="fas fa-exclamation-triangle"></i> Aucun auteur trouvé.
                        </div>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>