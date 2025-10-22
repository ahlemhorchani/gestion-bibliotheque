package tn.isimm.sfax.bibliotheque.service;

import tn.isimm.sfax.bibliotheque.entity.Livre;
import tn.isimm.sfax.bibliotheque.entity.Auteur;
import tn.isimm.sfax.bibliotheque.repository.LivreRepository;
import tn.isimm.sfax.bibliotheque.repository.AuteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class LivreService {

    @Autowired
    private LivreRepository livreRepository;

    @Autowired
    private AuteurRepository auteurRepository;

    @Autowired
    private AuteurService auteurService;

    // Créer un livre
    public Livre createLivre(Livre livre) {
        // Vérifier si l'auteur existe
        if (livre.getAuteur() != null && livre.getAuteur().getId() != null) {
            Optional<Auteur> auteur = auteurService.getAuteurById(livre.getAuteur().getId());
            if (auteur.isPresent()) {
                livre.setAuteur(auteur.get());
            } else {
                throw new RuntimeException("Auteur non trouvé avec l'ID: " + livre.getAuteur().getId());
            }
        }
        return livreRepository.save(livre);
    }

    // Récupérer tous les livres
    public List<Livre> getAllLivres() {
        return livreRepository.findAll();
    }

    // Récupérer un livre par ID
    public Optional<Livre> getLivreById(Long id) {
        return livreRepository.findById(id);
    }
 // Récupérer un auteur par ID
    public Optional<Auteur> getAuteurById(Long id) {
        return auteurService.getAuteurById(id);
    }

    // Rechercher les livres par auteur
    public List<Livre> getLivresByAuteur(Long auteurId) {
        return livreRepository.findByAuteurId(auteurId);
    }

    // Mettre à jour le titre d'un livre (BONUS)
    public Livre updateLivreTitre(Long id, String nouveauTitre) {
        Optional<Livre> livreOpt = livreRepository.findById(id);
        if (livreOpt.isPresent()) {
            Livre livre = livreOpt.get();
            livre.setTitre(nouveauTitre);
            return livreRepository.save(livre);
        } else {
            throw new RuntimeException("Livre non trouvé avec l'ID: " + id);
        }
    }

    // Supprimer un livre
    public void deleteLivre(Long id) {
        livreRepository.deleteById(id);
    }

    // Vérifier si un ISBN existe
    public boolean isbnExists(String isbn) {
        return livreRepository.existsByIsbn(isbn);
    }
}