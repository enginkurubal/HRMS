package kodlamaio.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HRMS.entities.concretes.CandidateTechnology;

public interface CandidateTechnologyDao extends JpaRepository<CandidateTechnology, Integer>{

}
