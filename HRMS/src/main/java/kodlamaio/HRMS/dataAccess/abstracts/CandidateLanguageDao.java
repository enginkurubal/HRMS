package kodlamaio.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HRMS.entities.concretes.CandidateLanguage;

public interface CandidateLanguageDao extends JpaRepository<CandidateLanguage, Integer>{

}
