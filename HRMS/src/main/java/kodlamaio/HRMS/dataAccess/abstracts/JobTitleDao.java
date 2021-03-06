package kodlamaio.HRMS.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.HRMS.entities.concretes.JobTitle;
@Repository
public interface JobTitleDao extends JpaRepository<JobTitle,Integer>{
		List<JobTitle> findByTitleIs(String title);
}
