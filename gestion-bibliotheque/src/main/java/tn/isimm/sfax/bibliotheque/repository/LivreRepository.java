package tn.isimm.sfax.bibliotheque.repository;

import tn.isimm.sfax.bibliotheque.entity.Livre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LivreRepository extends JpaRepository<Livre, Long> {
    // Rechercher les livres par auteur
    List<Livre> findByAuteurId(Long auteurId);
    
    // Rechercher par titre (contient)
    List<Livre> findByTitreContainingIgnoreCase(String titre);
    
    // Vérifier si un ISBN existe
    boolean existsByIsbn(String isbn);
}