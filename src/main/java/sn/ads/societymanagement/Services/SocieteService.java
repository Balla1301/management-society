package sn.ads.societymanagement.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sn.ads.societymanagement.Entities.ResponseRequest;
import sn.ads.societymanagement.Entities.Societe;
import sn.ads.societymanagement.Interfaces.ISociete;
import sn.ads.societymanagement.Repositories.SocieteRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SocieteService implements ISociete {

    private final SocieteRepository societeRepository;
    @Override
    public ResponseRequest create(Societe societe) {
        Societe societeSaved= societeRepository.save(societe);
        if(societe!=null)
            return new ResponseRequest(false, "Société "+societeSaved.getNom() +" enregistré avec succés");
        return new ResponseRequest(true, "Enregistrement de la société echouée, Veuillez réessayer plus tard!!!");
    }

    @Override
    public Optional<Societe> find(Long id) {
        return societeRepository.findById(id);
    }

    @Override
    public List<Societe> findAll() {
        return societeRepository.findAll();
    }
}
