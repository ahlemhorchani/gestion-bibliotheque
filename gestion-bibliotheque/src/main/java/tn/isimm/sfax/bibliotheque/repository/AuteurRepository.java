package tn.isimm.sfax.bibliotheque.repository;

import tn.isimm.sfax.bibliotheque.entity.Auteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuteurRepository extends JpaRepository<Auteur, Long> {
    // Recherche par nom et prénom
    Auteur findByNomAndPrenom(String nom, String prenom);
}