package tn.isimm.sfax.bibliotheque.controller;

import tn.isimm.sfax.bibliotheque.entity.Livre;
import tn.isimm.sfax.bibliotheque.service.LivreService;
import jakarta.validation.Valid; // NOUVEAU : Pour validation
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.RequestMethod; // NOUVEAU : Pour OPTIONS

@RestController
@RequestMapping("/api/livres")
@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS}) // CORRECTION : Spécifique + OPTIONS pour preflight
public class LivreController {

    @Autowired
    private LivreService livreService;

    // POST /api/livres - Ajouter un livre
    @PostMapping
    public ResponseEntity<Livre> createLivre(@Valid @RequestBody Livre livre) { // NOUVEAU : @Valid
        try {
            if (livreService.isbnExists(livre.getIsbn())) {
                return ResponseEntity.badRequest().body(null); // Ou custom error body
            }
            Livre savedLivre = livreService.createLivre(livre);
            return ResponseEntity.ok(savedLivre);
        } catch (Exception e) {
            e.printStackTrace(); // Log pour debug
            return ResponseEntity.badRequest().build();
        }
    }

    // GET /api/livres - Lister tous les livres
    @GetMapping
    public ResponseEntity<List<Livre>> getAllLivres() {
        List<Livre> livres = livreService.getAllLivres();
        return ResponseEntity.ok(livres);
    }

    // GET /api/livres/auteur/{idAuteur} - Rechercher les livres d'un auteur
    @GetMapping("/auteur/{idAuteur}")
    public ResponseEntity<List<Livre>> getLivresByAuteur(@PathVariable Long idAuteur) {
        List<Livre> livres = livreService.getLivresByAuteur(idAuteur);
        return ResponseEntity.ok(livres);
    }

    // GET /api/livres/{id} - Récupérer un livre par ID
    @GetMapping("/{id}")
    public ResponseEntity<Livre> getLivreById(@PathVariable Long id) {
        Optional<Livre> livre = livreService.getLivreById(id);
        return livre.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // PUT /api/livres/{id} - Mettre à jour un livre COMPLET (CORRECTION : Pas seulement titre)
    @PutMapping("/{id}")
    public ResponseEntity<Livre> updateLivre(@PathVariable Long id, @Valid @RequestBody Livre livreDetails) {
        Optional<Livre> optionalLivre = livreService.getLivreById(id);
        if (optionalLivre.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        try {
            Livre livre = optionalLivre.get();
            livre.setTitre(livreDetails.getTitre());
            livre.setIsbn(livreDetails.getIsbn());
            if (livreDetails.getAuteur() != null && livreDetails.getAuteur().getId() != null) {
                livre.setAuteur(livreService.getAuteurById(livreDetails.getAuteur().getId()).orElse(null)); // Fetch auteur
            }
            Livre updatedLivre = livreService.createLivre(livre); // Reuse save (update)
            return ResponseEntity.ok(updatedLivre);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    // DELETE /api/livres/{id} - Supprimer un livre
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLivre(@PathVariable Long id) {
        try {
            if (!livreService.getLivreById(id).isPresent()) {
                return ResponseEntity.notFound().build();
            }
            livreService.deleteLivre(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }
}