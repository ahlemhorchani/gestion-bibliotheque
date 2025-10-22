<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gestion des Livres</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-4">
        <!-- En-tête -->
        <div class="d-flex justify-content-between align-items-center mb-4">
            <h1 class="text-success">
                <i class="fas fa-book"></i> Gestion des Livres
            </h1>
            <div>
                <a href="/web/" class="btn btn-outline-secondary">
                    <i class="fas fa-home"></i> Accueil
                </a>
                <a href="/web/livres/nouveau" class="btn btn-success">
                    <i class="fas fa-plus-circle"></i> Nouveau Livre
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

        <!-- Tableau des livres -->
        <div class="card">
            <div class="card-header bg-success text-white">
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
                                        <th>Auteur</th>
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
                                                <span class="badge bg-primary">
                                                    ${livre.auteur.prenom} ${livre.auteur.nom}
                                                </span>
                                            </td>
                                            <td>
                                                <button class="btn btn-warning btn-sm" 
                                                        data-bs-toggle="modal" 
                                                        data-bs-target="#modifierTitreModal"
                                                        data-livre-id="${livre.id}"
                                                        data-livre-titre="${livre.titre}">
                                                    <i class="fas fa-edit"></i> Modifier
                                                </button>
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
                            <i class="fas fa-exclamation-triangle"></i> Aucun livre trouvé.
                        </div>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </div>

    <!-- Modal pour modifier le titre -->
    <div class="modal fade" id="modifierTitreModal" tabindex="-1">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Modifier le titre du livre</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                </div>
                <form action="/web/livres/modifier-titre" method="post">
                    <div class="modal-body">
                        <input type="hidden" id="livreId" name="id">
                        <div class="mb-3">
                            <label for="nouveauTitre" class="form-label">Nouveau titre :</label>
                            <input type="text" class="form-control" id="nouveauTitre" name="nouveauTitre" required>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Annuler</button>
                        <button type="submit" class="btn btn-primary">Modifier</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <script>
        // Script pour le modal de modification
        var modifierTitreModal = document.getElementById('modifierTitreModal');
        modifierTitreModal.addEventListener('show.bs.modal', function (event) {
            var button = event.relatedTarget;
            var livreId = button.getAttribute('data-livre-id');
            var livreTitre = button.getAttribute('data-livre-titre');
            
            var modalInputId = modifierTitreModal.querySelector('#livreId');
            var modalInputTitre = modifierTitreModal.querySelector('#nouveauTitre');
            
            modalInputId.value = livreId;
            modalInputTitre.value = livreTitre;
        });
    </script>
</body>
</html>