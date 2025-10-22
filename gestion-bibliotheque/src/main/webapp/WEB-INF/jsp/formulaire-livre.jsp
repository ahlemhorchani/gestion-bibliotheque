<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Nouveau Livre</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-4">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card">
                    <div class="card-header bg-success text-white">
                        <h4 class="mb-0">
                            <i class="fas fa-plus-circle"></i> Nouveau Livre
                        </h4>
                    </div>
                    <div class="card-body">
                        <form action="/web/livres/enregistrer" method="post">
                            <div class="mb-3">
                                <label for="titre" class="form-label">Titre :</label>
                                <input type="text" class="form-control" id="titre" name="titre" required>
                            </div>
                            
                            <div class="mb-3">
                                <label for="isbn" class="form-label">ISBN :</label>
                                <input type="text" class="form-control" id="isbn" name="isbn" required>
                            </div>
                            
                            <div class="mb-3">
                                <label for="auteur.id" class="form-label">Auteur :</label>
                                <select class="form-select" id="auteur.id" name="auteur.id" required>
                                    <option value="">Sélectionnez un auteur</option>
                                    <c:forEach var="auteur" items="${auteurs}">
                                        <option value="${auteur.id}">
                                            ${auteur.prenom} ${auteur.nom}
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>
                            
                            <div class="d-grid gap-2">
                                <button type="submit" class="btn btn-success">
                                    <i class="fas fa-save"></i> Enregistrer
                                </button>
                                <a href="/web/livres" class="btn btn-secondary">
                                    <i class="fas fa-arrow-left"></i> Retour
                                </a>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>