package kodlamaio.HRMS.business.concretes;

import java.sql.Date;
import java.time.LocalDate;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.ActivationCodeService;
import kodlamaio.HRMS.core.utilities.ErrorResult;
import kodlamaio.HRMS.core.utilities.Result;
import kodlamaio.HRMS.core.utilities.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.ActivationCodeDao;
import kodlamaio.HRMS.dataAccess.abstracts.UserDao;
import kodlamaio.HRMS.entities.concretes.ActivationCode;
import kodlamaio.HRMS.entities.concretes.User;

@Service
public class ActivationCodeManager implements ActivationCodeService{
	
	private UserDao userDao;
	private ActivationCodeDao activationCodeDao;
	
	@Autowired
	public ActivationCodeManager(UserDao userDao, ActivationCodeDao activationCodeDao) {
		super();
		this.userDao = userDao;
		this.activationCodeDao = activationCodeDao;
	}

	@Override
	public String createActivationCode(User user) {
		String aCode = UUID.randomUUID().toString();
		ActivationCode activationCode = new ActivationCode();
		LocalDate n = (LocalDate.now());
		activationCode.setUser(user);
		activationCode.setCreatedDate(Date.valueOf(n));
		activationCode.setActivationCode(aCode);
		this.activationCodeDao.save(activationCode);
		return aCode;
	}

	@Override
	public void sendMail(String email) {
		System.out.println("Email gönderildi.");	
	}

	@Override
	public Result activeUser(String activationCode) {
		if(!this.activationCodeDao.existsByActivationCode(activationCode)) {
			return new ErrorResult("Doğrulama işlemi başarısız.");
		}
		ActivationCode activationCode2 = activationCodeDao.findByActivationCode(activationCode);
		if(this.activationCodeDao.getById(activationCode2.getId()).isConfirmed()) {
			return new ErrorResult("Doğrulama işlemi daha önceden gerçekleştirilmiş.");
		}
		LocalDate n = LocalDate.now();
		activationCode2.setConfirmed(true);
		activationCode2.setConfirmedDate(Date.valueOf(n));
		activationCodeDao.save(activationCode2);
		User activeUser = new User();
		activeUser = userDao.getById(activationCode2.getUser().getId());
		activeUser.setActive(true);
		userDao.save(activeUser);
		
		return new SuccessResult("Doğrulama işlemi başarılı");
	}

	

}
