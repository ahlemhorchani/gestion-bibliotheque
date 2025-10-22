package tn.isimm.sfax.bibliotheque.controller;

import tn.isimm.sfax.bibliotheque.entity.Auteur;
import tn.isimm.sfax.bibliotheque.service.AuteurService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.Collections;

@RestController
@RequestMapping("/api/auteurs")
@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS}) // CORRECTION : Réactivé et spécifique (inclut OPTIONS pour preflight)
public class AuteurController {

    @Autowired
    private AuteurService auteurService;

    // ... (le reste du code inchangé : createAuteur, getAllAuteurs, etc.)
    // POST /api/auteurs - Ajouter un auteur
    @PostMapping
    public ResponseEntity<Auteur> createAuteur(@Valid @RequestBody Auteur auteur) {
        try {
            if (auteurService.findByNomAndPrenom(auteur.getNom(), auteur.getPrenom()) != null) {
                return ResponseEntity.badRequest().body(null);
            }
            Auteur savedAuteur = auteurService.createAuteur(auteur);
            return ResponseEntity.ok(savedAuteur);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    // GET /api/auteurs - Lister tous les auteurs
    @GetMapping
    public ResponseEntity<List<Auteur>> getAllAuteurs() {
    	  try {
              List<Auteur> auteurs = auteurService.getAllAuteurs();
              // Force array vide si null (rare, mais safe)
              if (auteurs == null) {
                  auteurs = Collections.emptyList();
              }
              System.out.println("Auteurs chargés: " + auteurs.size()); // NOUVEAU : Log backend pour debug
              return ResponseEntity.ok(auteurs);
          } catch (Exception e) {
              e.printStackTrace(); // Log exception
              return ResponseEntity.ok(Collections.emptyList()); // Fallback [] au lieu d'erreur 500
          }
    }

    // GET /api/auteurs/{id} - Récupérer un auteur par ID
    @GetMapping("/{id}")
    public ResponseEntity<Auteur> getAuteurById(@PathVariable Long id) {
        Optional<Auteur> auteur = auteurService.getAuteurById(id);
        return auteur.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // PUT /api/auteurs/{id} - Mettre à jour un auteur
    @PutMapping("/{id}")
    public ResponseEntity<Auteur> updateAuteur(@PathVariable Long id, @Valid @RequestBody Auteur auteurDetails) {
        Optional<Auteur> optionalAuteur = auteurService.getAuteurById(id);
        if (optionalAuteur.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        try {
            Auteur auteur = optionalAuteur.get();
            auteur.setNom(auteurDetails.getNom());
            auteur.setPrenom(auteurDetails.getPrenom());
            Auteur updatedAuteur = auteurService.updateAuteur(auteur);
            return ResponseEntity.ok(updatedAuteur);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    // DELETE /api/auteurs/{id} - Supprimer un auteur
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuteur(@PathVariable Long id) {
        try {
            if (!auteurService.getAuteurById(id).isPresent()) {
                return ResponseEntity.notFound().build();
            }
            auteurService.deleteAuteur(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    // GET /api/auteurs/search - Recherche par nom et prénom
    @GetMapping("/search")
    public ResponseEntity<Auteur> searchAuteur(@RequestParam String nom, @RequestParam String prenom) {
        Auteur auteur = auteurService.findByNomAndPrenom(nom, prenom);
        if (auteur == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(auteur);
    }
   
}