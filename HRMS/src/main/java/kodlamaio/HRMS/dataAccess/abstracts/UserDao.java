package kodlamaio.HRMS.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.HRMS.entities.concretes.User;
@Repository
public interface UserDao extends JpaRepository<User, Integer>{
	List<User> findByEmail(String email);
	
	
	
}
