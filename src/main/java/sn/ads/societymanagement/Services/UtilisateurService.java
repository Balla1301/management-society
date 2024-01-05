package sn.ads.societymanagement.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sn.ads.societymanagement.Entities.ResponseRequest;
import sn.ads.societymanagement.Entities.Societe;
import sn.ads.societymanagement.Entities.Utilisateur;
import sn.ads.societymanagement.Interfaces.IUtilisateur;
import sn.ads.societymanagement.Repositories.SocieteRepository;
import sn.ads.societymanagement.Repositories.UtilisateurRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UtilisateurService implements IUtilisateur {

    private final UtilisateurRepository utilisateurRepository;
    private final SocieteRepository societeRepository;
    @Override
    public ResponseRequest create(Utilisateur utilisateur, Long societeId) {
        if(societeRepository.existsById(societeId)){
            Societe societe=societeRepository.findById(societeId).orElseThrow();
            utilisateur.setSociete(societe);
            Utilisateur userSaved=utilisateurRepository.save(utilisateur);
            if (userSaved!=null)
                return new ResponseRequest(false, "Utilisateur "+userSaved.getPrenom()+" - "+userSaved.getNom() +" enregistré avec succés");
        }
        return new ResponseRequest(true, "Enregistrement de l'utilsateur echoué, Veuillez réessayer plus tard!!!");
    }

    @Override
    public Utilisateur find(Long id) {
        return utilisateurRepository.findById(id).orElseThrow(()-> new RuntimeException("Utilisateur Introuvable !!!"));
    }

    @Override
    public List<Utilisateur> findAll(Long societeId) {
        return utilisateurRepository.findBySocieteId(societeId);
    }

    @Override
    public List<Utilisateur> findAll() {
        return utilisateurRepository.findAll();
    }
}
