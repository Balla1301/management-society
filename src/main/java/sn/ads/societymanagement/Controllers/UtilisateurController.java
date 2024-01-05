package sn.ads.societymanagement.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.ads.societymanagement.Entities.ResponseRequest;
import sn.ads.societymanagement.Entities.Utilisateur;
import sn.ads.societymanagement.Services.UtilisateurService;

import java.util.List;

@RestController
@RequestMapping("/utilisateur")
@RequiredArgsConstructor
public class UtilisateurController {

    private final UtilisateurService utilisateurService;

    @PostMapping("/add/{societeId}")
    public ResponseEntity<ResponseRequest> create(@RequestBody Utilisateur utilisateur, @PathVariable("societeId") Long societeId){
        ResponseRequest userSaved=utilisateurService.create(utilisateur, societeId);
        return new ResponseEntity<>(userSaved, HttpStatus.ACCEPTED);
    }
    @GetMapping("/find/{userId}")
    public ResponseEntity<Utilisateur> find(@PathVariable("userId") Long userId) {
        Utilisateur utilisateur = utilisateurService.find(userId);
        return ResponseEntity.ok(utilisateur);
    }
    @GetMapping("/find-all")
    public ResponseEntity<List<Utilisateur>> findAll() {
        List <Utilisateur> utilisateurs = utilisateurService.findAll();
        return ResponseEntity.ok(utilisateurs);
    }

    @GetMapping("/find-all/{societeId}")
    public ResponseEntity<List<Utilisateur>> findAllBySociete(@PathVariable("societeId") Long societeId) {
        List <Utilisateur> utilisateurs = utilisateurService.findAll(societeId);
        return ResponseEntity.ok(utilisateurs);
    }
}
