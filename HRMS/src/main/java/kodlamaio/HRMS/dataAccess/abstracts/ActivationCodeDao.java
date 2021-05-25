package kodlamaio.HRMS.dataAccess.abstracts;

import org.springframework.stereotype.Repository;

import kodlamaio.HRMS.entities.concretes.User;
@Repository
public interface ActivationCodeDao {
	User findByActivationCode(String activationCode);
}
