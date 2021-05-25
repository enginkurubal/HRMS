package kodlamaio.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.CandidateCheckService;
import kodlamaio.HRMS.core.utilities.DataResult;
import kodlamaio.HRMS.core.utilities.SuccessDataResult;
import kodlamaio.HRMS.dataAccess.abstracts.CandidateDao;
import kodlamaio.HRMS.entities.concretes.Candidate;
@Service
public class CandidateCheckManager implements CandidateCheckService{
	
	private CandidateDao candidateDao;
	
	@Autowired
	public CandidateCheckManager(CandidateDao candidateDao) {
		super();
		this.candidateDao = candidateDao;
	}

	@Override
	public DataResult<List<Candidate>> findByEmailIs(String email) {
		
		return new SuccessDataResult<List<Candidate>>
		(this.candidateDao.findByEmailIs(email));
	}

	@Override
	public DataResult<List<Candidate>> findByIdentityNumberIs(String identityNumber) {
		
		return new SuccessDataResult<List<Candidate>>
		(this.candidateDao.findByIdentityNumber(identityNumber));
	}

	@Override
	public boolean checkIfMailExist(Candidate candidate) {
		if(this.findByEmailIs(candidate.getEmail()).getData().size()!=0) {
			return false;
		}
		return true;
	}

	@Override
	public boolean checkIfIdentityExist(Candidate candidate) {
		if(this.findByIdentityNumberIs(candidate.getIdentityNumber()).getData().size()!=0) {
			return false;
		}
		return true;
	}

}
