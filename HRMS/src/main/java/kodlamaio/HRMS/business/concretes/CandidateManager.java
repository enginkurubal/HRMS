package kodlamaio.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.CandidateCheckService;
import kodlamaio.HRMS.business.abstracts.CandidateService;
import kodlamaio.HRMS.core.helpers.FakeMernisService;
import kodlamaio.HRMS.core.helpers.MailService;
import kodlamaio.HRMS.core.utilities.DataResult;
import kodlamaio.HRMS.core.utilities.ErrorResult;
import kodlamaio.HRMS.core.utilities.Result;
import kodlamaio.HRMS.core.utilities.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.CandidateDao;
import kodlamaio.HRMS.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService {

	private CandidateDao candidateDao;
	private CandidateCheckService candidateCheckService;
	private FakeMernisService fakeMernisService;
	private MailService mailService;
	
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao, CandidateCheckService candidateCheckService,
			FakeMernisService fakeMernisService,MailService mailService) {
		super();
		this.candidateDao = candidateDao;
		this.candidateCheckService = candidateCheckService;
		this.fakeMernisService = fakeMernisService;
		this.mailService = mailService;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>
		(this.candidateDao.findAll(),"İş arayanlar listelendi.");
	}

	@Override
	public Result add(Candidate candidate) {
		if(!this.fakeMernisService.ifRealPerson(candidate)) {
			return new ErrorResult("TC kimlik numarası tanımlanamadı.");
		}else if(!this.candidateCheckService.checkIfMailExist(candidate)) {
			return new ErrorResult("E-posta adresi mevcut.");
		}else if(!this.candidateCheckService.checkIfIdentityExist(candidate)) {
			return new ErrorResult("TC kimlik numarası kayıtlı.");
		}else if(!this.mailService.checkMailActivation()){
			return new ErrorResult("E-posta aktivasyon işlemi tamamlanamadı.");
		}
		return new SuccessResult("Kayıt işlemi başarılı. "+ candidate.getFirstName()+" Hoşgeldiniz..");
	}

}
