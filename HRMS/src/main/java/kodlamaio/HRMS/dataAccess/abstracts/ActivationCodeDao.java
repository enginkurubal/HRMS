package kodlamaio.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.HRMS.entities.concretes.ActivationCode;

@Repository
public interface ActivationCodeDao extends JpaRepository<ActivationCode, Integer>{
	ActivationCode findByActivationCode(String activationCode);
	boolean existsByActivationCode(String activationCode);
	
}
