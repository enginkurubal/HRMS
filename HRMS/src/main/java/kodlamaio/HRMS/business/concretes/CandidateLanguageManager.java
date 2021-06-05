package kodlamaio.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.CandidateLanguageService;
import kodlamaio.HRMS.core.dtoConverter.DtoConverterService;
import kodlamaio.HRMS.core.utilities.DataResult;
import kodlamaio.HRMS.core.utilities.Result;
import kodlamaio.HRMS.core.utilities.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.CandidateLanguageDao;
import kodlamaio.HRMS.entities.concretes.CandidateLanguage;
import kodlamaio.HRMS.entities.dtos.CandidateLanguageDto;

@Service
public class CandidateLanguageManager implements CandidateLanguageService{
	
	private CandidateLanguageDao candidateLanguageDao;
	private DtoConverterService dtoConverterService;
	
	@Autowired
	public CandidateLanguageManager(CandidateLanguageDao candidateLanguageDao,DtoConverterService dtoConverterService) {
		super();
		this.candidateLanguageDao = candidateLanguageDao;
		this.dtoConverterService = dtoConverterService;
	}

	@Override
	public DataResult<List<CandidateLanguage>> getAll() {
		
		return new SuccessDataResult<List<CandidateLanguage>>
		(this.candidateLanguageDao.findAll(),"Yabancı diller listelendi.");
	}

	@Override
	public Result add(CandidateLanguageDto candidateLanguageDto) {
		this.candidateLanguageDao.save
		((CandidateLanguage) dtoConverterService.dtoClassConverter(candidateLanguageDto, CandidateLanguage.class));
		return new SuccessResult("Yabancı dil eklendi.");
	}

}
