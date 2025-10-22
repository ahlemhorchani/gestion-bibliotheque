<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Livres par Auteur</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-4">
        <!-- En-tête -->
        <div class="d-flex justify-content-between align-items-center mb-4">
            <h1 class="text-info">
                <i class="fas fa-book"></i> Livres de ${auteur.prenom} ${auteur.nom}
            </h1>
            <div>
                <a href="/web/auteurs" class="btn btn-outline-secondary">
                    <i class="fas fa-arrow-left"></i> Retour aux Auteurs
                </a>
                <a href="/web/livres" class="btn btn-outline-primary">
                    <i class="fas fa-book"></i> Tous les Livres
                </a>
            </div>
        </div>

        <!-- Livres de l'auteur -->
        <div class="card">
            <div class="card-header bg-info text-white">
                <h5 class="mb-0">
                    <i class="fas fa-list"></i> Liste des Livres (${livres.size()})
                </h5>
            </div>
            <div class="card-body">
                <c:choose>
                    <c:when test="${not empty livres}">
                        <div class="table-responsive">
                            <table class="table table-striped table-hover">
                                <thead class="table-dark">
                                    <tr>
                                        <th>ID</th>
                                        <th>Titre</th>
                                        <th>ISBN</th>
                                        <th>Actions</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="livre" items="${livres}">
                                        <tr>
                                            <td>${livre.id}</td>
                                            <td>${livre.titre}</td>
                                            <td>${livre.isbn}</td>
                                            <td>
                                                <a href="/web/livres/supprimer/${livre.id}" 
                                                   class="btn btn-danger btn-sm"
                                                   onclick="return confirm('Êtes-vous sûr de vouloir supprimer ce livre ?')">
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
                            <i class="fas fa-exclamation-triangle"></i> 
                            Aucun livre trouvé pour cet auteur.
                        </div>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>