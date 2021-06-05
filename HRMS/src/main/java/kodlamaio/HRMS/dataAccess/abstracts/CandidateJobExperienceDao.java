package kodlamaio.HRMS.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HRMS.entities.concretes.CandidateJobExperience;
import kodlamaio.HRMS.entities.dtos.CandidateJobExperienceDto;

public interface CandidateJobExperienceDao extends JpaRepository<CandidateJobExperience, Integer> {
	
	List<CandidateJobExperienceDto> findByCandidateCvIdOrderByEndDateDesc(int id);
	
}
