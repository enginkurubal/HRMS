package kodlamaio.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HRMS.entities.concretes.CandidateSchoolGraduate;

public interface CandidateSchoolGraduateDao extends JpaRepository<CandidateSchoolGraduate, Integer>{

}
