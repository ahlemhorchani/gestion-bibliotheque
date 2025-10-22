package tn.isimm.sfax.bibliotheque.service;

import tn.isimm.sfax.bibliotheque.entity.Auteur;
import tn.isimm.sfax.bibliotheque.repository.AuteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.Collections;
@Service
public class AuteurService {

    @Autowired
    private AuteurRepository auteurRepository;

    // Créer un auteur (amélioré avec vérif doublon)
    public Auteur createAuteur(Auteur auteur) {
        // Vérification doublon (si existe, ne pas créer)
        if (findByNomAndPrenom(auteur.getNom(), auteur.getPrenom()) != null) {
            throw new RuntimeException("Auteur avec ce nom et prénom existe déjà"); // Exception pour controller
        }
        return auteurRepository.save(auteur);
    }

   
    // Récupérer un auteur par ID
    public Optional<Auteur> getAuteurById(Long id) {
        return auteurRepository.findById(id);
    }

    // Rechercher par nom et prénom (inchangé, mais maintenant utilisé)
    public Auteur findByNomAndPrenom(String nom, String prenom) {
        return auteurRepository.findByNomAndPrenom(nom, prenom);
    }

    // Mettre à jour un auteur (NOUVEAU)
    public Auteur updateAuteur(Auteur auteur) {
        return auteurRepository.save(auteur);
    }

    // Supprimer un auteur (amélioré)
    public void deleteAuteur(Long id) {
        if (!getAuteurById(id).isPresent()) {
            throw new RuntimeException("Auteur non trouvé"); // Exception pour controller
        }
        auteurRepository.deleteById(id);
    }
 // ... (inchangé, mais confirmez getAllAuteurs)
 
     public List<Auteur> getAllAuteurs() {
         List<Auteur> auteurs = auteurRepository.findAll();
         return auteurs != null ? auteurs : Collections.emptyList(); // NOUVEAU : Fallback si null
     }

    // ... (autres méthodes)
}