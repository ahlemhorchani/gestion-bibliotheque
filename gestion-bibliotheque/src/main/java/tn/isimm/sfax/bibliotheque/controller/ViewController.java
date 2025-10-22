package tn.isimm.sfax.bibliotheque.controller;

// Import des entités et services nécessaires
// import tn.isimm.sfax.bibliotheque.entity.Auteur;
// import tn.isimm.sfax.bibliotheque.entity.Livre;
// import tn.isimm.sfax.bibliotheque.service.AuteurService;
// import tn.isimm.sfax.bibliotheque.service.LivreService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.*;
// import org.springframework.web.servlet.mvc.support.RedirectAttributes;
// import java.util.List;

// Déclaration de la classe comme contrôleur Spring MVC
// @Controller
// @RequestMapping("/web")
public class ViewController {

    // Injection du service AuteurService
    // @Autowired
    // private AuteurService auteurService;

    // Injection du service LivreService
    // @Autowired
    // private LivreService livreService;

    // =========================
    // PAGE D'ACCUEIL
    // =========================
    // @GetMapping("/")
    // public String index(Model model) {
    //     // Ajouter le nombre total d'auteurs et de livres au modèle
    //     model.addAttribute("nombreAuteurs", auteurService.getAllAuteurs().size());
    //     model.addAttribute("nombreLivres", livreService.getAllLivres().size());
    //     // Retourne la vue JSP "index.jsp"
    //     return "index";
    // }

    // =========================
    // GESTION DES AUTEURS
    // =========================
    // @GetMapping("/auteurs")
    // public String listeAuteurs(Model model) {
    //     List<Auteur> auteurs = auteurService.getAllAuteurs();
    //     model.addAttribute("auteurs", auteurs);
    //     return "auteurs"; // Vue JSP
    // }

    // @GetMapping("/auteurs/nouveau")
    // public String formulaireAuteur(Model model) {
    //     model.addAttribute("auteur", new Auteur());
    //     return "formulaire-auteur"; // Vue JSP
    // }

    // @PostMapping("/auteurs/enregistrer")
    // public String enregistrerAuteur(@ModelAttribute Auteur auteur, RedirectAttributes redirectAttributes) {
    //     try {
    //         auteurService.createAuteur(auteur);
    //         redirectAttributes.addFlashAttribute("success", "Auteur ajouté avec succès!");
    //     } catch (Exception e) {
    //         redirectAttributes.addFlashAttribute("error", "Erreur lors de l'ajout de l'auteur");
    //     }
    //     return "redirect:/web/auteurs";
    // }

    // @GetMapping("/auteurs/supprimer/{id}")
    // public String supprimerAuteur(@PathVariable Long id, RedirectAttributes redirectAttributes) {
    //     try {
    //         auteurService.deleteAuteur(id);
    //         redirectAttributes.addFlashAttribute("success", "Auteur supprimé avec succès!");
    //     } catch (Exception e) {
    //         redirectAttributes.addFlashAttribute("error", "Erreur lors de la suppression de l'auteur");
    //     }
    //     return "redirect:/web/auteurs";
    // }

    // =========================
    // GESTION DES LIVRES
    // =========================
    // @GetMapping("/livres")
    // public String listeLivres(Model model) {
    //     List<Livre> livres = livreService.getAllLivres();
    //     List<Auteur> auteurs = auteurService.getAllAuteurs();
    //     model.addAttribute("livres", livres);
    //     model.addAttribute("auteurs", auteurs);
    //     return "livres"; // Vue JSP
    // }

    // @GetMapping("/livres/nouveau")
    // public String formulaireLivre(Model model) {
    //     List<Auteur> auteurs = auteurService.getAllAuteurs();
    //     model.addAttribute("livre", new Livre());
    //     model.addAttribute("auteurs", auteurs);
    //     return "formulaire-livre"; // Vue JSP
    // }

    // @PostMapping("/livres/enregistrer")
    // public String enregistrerLivre(@ModelAttribute Livre livre, RedirectAttributes redirectAttributes) {
    //     try {
    //         livreService.createLivre(livre);
    //         redirectAttributes.addFlashAttribute("success", "Livre ajouté avec succès!");
    //     } catch (Exception e) {
    //         redirectAttributes.addFlashAttribute("error", "Erreur lors de l'ajout du livre: " + e.getMessage());
    //     }
    //     return "redirect:/web/livres";
    // }

    // @GetMapping("/livres/supprimer/{id}")
    // public String supprimerLivre(@PathVariable Long id, RedirectAttributes redirectAttributes) {
    //     try {
    //         livreService.deleteLivre(id);
    //         redirectAttributes.addFlashAttribute("success", "Livre supprimé avec succès!");
    //     } catch (Exception e) {
    //         redirectAttributes.addFlashAttribute("error", "Erreur lors de la suppression du livre");
    //     }
    //     return "redirect:/web/livres";
    // }

    // @GetMapping("/livres/auteur/{id}")
    // public String livresParAuteur(@PathVariable Long id, Model model) {
    //     List<Livre> livres = livreService.getLivresByAuteur(id);
    //     Auteur auteur = auteurService.getAuteurById(id).orElse(null);
    //     model.addAttribute("livres", livres);
    //     model.addAttribute("auteur", auteur);
    //     return "livres-par-auteur"; // Vue JSP
    // }

    // @PostMapping("/livres/modifier-titre")
    // public String modifierTitreLivre(@RequestParam Long id, @RequestParam String nouveauTitre, RedirectAttributes redirectAttributes) {
    //     try {
    //         livreService.updateLivreTitre(id, nouveauTitre);
    //         redirectAttributes.addFlashAttribute("success", "Titre du livre modifié avec succès!");
    //     } catch (Exception e) {
    //         redirectAttributes.addFlashAttribute("error", "Erreur lors de la modification du titre");
    //     }
    //     return "redirect:/web/livres";
    // }

}
