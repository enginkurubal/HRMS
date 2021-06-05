package kodlamaio.HRMS.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HRMS.entities.concretes.JobPosting;

public interface JobPostingDao extends JpaRepository<JobPosting, Integer>{
	
	
	List<JobPosting> findByIsActiveAndEmployer_CompanyName(boolean isActive,String companyName);
	List<JobPosting> findByIsActive(boolean isActive);
	List<JobPosting> findByIsActiveOrderByApplicationDeadline(boolean isActive);
	
	
	
}
