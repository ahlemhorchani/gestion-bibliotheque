package tn.isimm.sfax.bibliotheque.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank; // Ajout pour validation (nouvel import)
import jakarta.validation.constraints.NotNull; // Ajout pour validation
import java.util.List;

@Entity
@Table(name = "auteur")
public class Auteur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotNull(message = "Le nom ne peut pas être null") // Ajout validation
    @NotBlank(message = "Le nom ne peut pas être vide") // Ajout validation
    private String nom;

    @Column(nullable = false)
    @NotNull(message = "Le prénom ne peut pas être null") // Ajout validation
    @NotBlank(message = "Le prénom ne peut pas être vide") // Ajout validation
    private String prenom;

    @OneToMany(mappedBy = "auteur", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Livre> livres;

    // Constructeurs
    public Auteur() {}

    public Auteur(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    // Getters et Setters (inchangés)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public List<Livre> getLivres() { return livres; }
    public void setLivres(List<Livre> livres) { this.livres = livres; }

    @Override
    public String toString() {
        return "Auteur{" + "id=" + id + ", nom='" + nom + '\'' + ", prenom='" + prenom + '\'' + '}';
    }
}