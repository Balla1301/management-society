package sn.ads.societymanagement.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.ads.societymanagement.Entities.Societe;

@Repository
public interface SocieteRepository extends JpaRepository<Societe, Long> {
}
