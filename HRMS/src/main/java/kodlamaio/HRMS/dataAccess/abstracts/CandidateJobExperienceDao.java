package kodlamaio.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HRMS.entities.concretes.CandidateJobExperience;

public interface CandidateJobExperienceDao extends JpaRepository<CandidateJobExperience, Integer> {

}
