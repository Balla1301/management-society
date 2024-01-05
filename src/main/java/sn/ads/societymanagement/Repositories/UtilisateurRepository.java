package sn.ads.societymanagement.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;
import sn.ads.societymanagement.Entities.Utilisateur;

import java.util.List;
@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

    List<Utilisateur> findBySocieteId(Long societeId);
}
