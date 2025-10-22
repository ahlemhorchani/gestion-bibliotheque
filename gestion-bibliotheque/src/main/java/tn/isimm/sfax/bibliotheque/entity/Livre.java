package tn.isimm.sfax.bibliotheque.entity;

import com.fasterxml.jackson.annotation.JsonBackReference; // NOUVEAU : Import pour cycle
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank; // NOUVEAU : Validation
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "livre")
public class Livre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotNull(message = "Le titre ne peut pas être null")
    @NotBlank(message = "Le titre ne peut pas être vide")
    private String titre;

    @Column(unique = true, nullable = false)
    @NotNull(message = "L'ISBN ne peut pas être null")
    @NotBlank(message = "L'ISBN ne peut pas être vide")
    private String isbn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "auteur_id", nullable = false)
    @JsonBackReference // CORRECTION : Brise cycle (ne sérialise pas auteur dans JSON)
    private Auteur auteur;

    // Constructeurs
    public Livre() {}

    public Livre(String titre, String isbn, Auteur auteur) {
        this.titre = titre;
        this.isbn = isbn;
        this.auteur = auteur;
    }

    // Getters et Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitre() { return titre; }
    public void setTitre(String titre) { this.titre = titre; }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public Auteur getAuteur() { return auteur; }
    public void setAuteur(Auteur auteur) { this.auteur = auteur; }

    @Override
    public String toString() {
        return "Livre{" + "id=" + id + ", titre='" + titre + '\'' + ", isbn='" + isbn + '\'' + 
               ", auteur=" + (auteur != null ? auteur.getNom() + " " + auteur.getPrenom() : "null") + '}';
    }
}