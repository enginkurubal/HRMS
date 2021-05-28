package kodlamaio.HRMS.dataAccess.abstracts;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.HRMS.entities.concretes.JobPosting;

public interface JobPostingDao extends JpaRepository<JobPosting, Integer>{
	
	List<JobPosting> getByEmployer(int employerId);
	List<JobPosting> findByPostedDateOrderByPostedDate(Date postedDate);
	
	
}
