package sn.ads.societymanagement.Interfaces;

import sn.ads.societymanagement.Entities.ResponseRequest;
import sn.ads.societymanagement.Entities.Societe;

import java.util.List;
import java.util.Optional;

public interface ISociete {

    ResponseRequest create(Societe societe);
    Optional<Societe> find(Long id);
    List<Societe> findAll();
}
