package kodlamaio.HRMS.dataAccess.abstracts;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HRMS.entities.concretes.JobPosting;

public interface JobPostingDao extends JpaRepository<JobPosting, Integer>{
	
	List<JobPosting> getByEmployer(String companyName);
	List<JobPosting> findByPostedDateOrderByPostedDate(Date postedDate);
	List<JobPosting> findByIsActive(boolean isActive);
	List<JobPosting> findByIsActiveOrderByApplicationDeadline(boolean isActive);
	
	
	
}
