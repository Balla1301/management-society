package sn.ads.societymanagement.Interfaces;

import sn.ads.societymanagement.Entities.ResponseRequest;
import sn.ads.societymanagement.Entities.Societe;
import sn.ads.societymanagement.Entities.Utilisateur;

import java.awt.geom.RectangularShape;
import java.util.List;

public interface IUtilisateur {

    ResponseRequest create(Utilisateur utilisateur, Long societeId);
    Utilisateur find(Long id);
    List<Utilisateur> findAll(Long societeId);

    List<Utilisateur> findAll();
}
