package kodlamaio.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.CandidateJobExperienceService;
import kodlamaio.HRMS.core.dtoConverter.DtoConverterService;
import kodlamaio.HRMS.core.utilities.DataResult;
import kodlamaio.HRMS.core.utilities.Result;
import kodlamaio.HRMS.core.utilities.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.CandidateJobExperienceDao;
import kodlamaio.HRMS.entities.concretes.CandidateJobExperience;
import kodlamaio.HRMS.entities.dtos.CandidateJobExperienceDto;

@Service
public class CandidateJobExperienceManager implements CandidateJobExperienceService{
	
	private CandidateJobExperienceDao candidateJobExperienceDao;
	private DtoConverterService dtoConverterService;  
	
	@Autowired
	public CandidateJobExperienceManager(CandidateJobExperienceDao candidateJobExperienceDao,DtoConverterService dtoConverterService) {
		super();
		this.candidateJobExperienceDao = candidateJobExperienceDao;
		this.dtoConverterService = dtoConverterService;
	}

	
	
	
	@Override
	public DataResult<List<CandidateJobExperience>> getAll() {
		return new SuccessDataResult<List<CandidateJobExperience>>
		(this.candidateJobExperienceDao.findAll(),"İş tecrübeleri listelendi.");
	}

	@Override
	public Result add(CandidateJobExperienceDto candidateJobExperienceDto) {
		this.candidateJobExperienceDao.save
		((CandidateJobExperience) dtoConverterService.dtoClassConverter(candidateJobExperienceDto, CandidateJobExperience.class));
		return new SuccessResult("İş tecrübesi eklendi.");
	}




	@Override
	public DataResult<List<CandidateJobExperienceDto>> findByCandidateCvIdOrderByEndDateDesc(int id) {
		List<CandidateJobExperienceDto> jobExperiences = candidateJobExperienceDao.findByCandidateCvIdOrderByEndDateDesc(id);
		return new SuccessDataResult<List<CandidateJobExperienceDto>>
		(dtoConverterService.dtoConverter(jobExperiences, CandidateJobExperienceDto.class),"İş tevrübeleri tarihe göre sıralandı.");
	}
	

}
