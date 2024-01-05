package sn.ads.societymanagement.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.ads.societymanagement.Entities.ResponseRequest;
import sn.ads.societymanagement.Entities.Societe;
import sn.ads.societymanagement.Services.SocieteService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/societe")
@RequiredArgsConstructor
public class SocieteController {

    private final SocieteService societeService;
    @PostMapping("/add")
    public ResponseEntity<ResponseRequest> create(@RequestBody Societe societe){
        ResponseRequest societeSaved=societeService.create(societe);
        return new ResponseEntity<>(societeSaved, HttpStatus.ACCEPTED);
    }
    @GetMapping("/find/{societeId}")
    public ResponseEntity<Optional<Societe>> find(@PathVariable("societeId") Long societeId) {
        Optional<Societe> societe = societeService.find(societeId);
        return ResponseEntity.ok(societe);
    }
    @GetMapping("/find-all")
    public ResponseEntity<List<Societe>> findAllSociete() {
        List <Societe> societes = societeService.findAll();
        return ResponseEntity.ok(societes);
    }

}
