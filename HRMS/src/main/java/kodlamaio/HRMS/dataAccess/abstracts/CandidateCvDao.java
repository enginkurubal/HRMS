package kodlamaio.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HRMS.entities.concretes.CandidateCv;

public interface CandidateCvDao extends JpaRepository<CandidateCv, Integer>{

}
