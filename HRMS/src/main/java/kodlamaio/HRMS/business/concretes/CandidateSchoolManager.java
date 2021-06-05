package kodlamaio.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.CandidateSchoolService;
import kodlamaio.HRMS.core.dtoConverter.DtoConverterService;
import kodlamaio.HRMS.core.utilities.DataResult;
import kodlamaio.HRMS.core.utilities.Result;
import kodlamaio.HRMS.core.utilities.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.CandidateSchoolDao;
import kodlamaio.HRMS.entities.concretes.CandidateSchool;
import kodlamaio.HRMS.entities.dtos.CandidateSchoolDto;

@Service
public class CandidateSchoolManager implements CandidateSchoolService{
	
	private CandidateSchoolDao candidateSchoolDao;
	private DtoConverterService dtoConverterService;
	
	@Autowired
	public CandidateSchoolManager(CandidateSchoolDao candidateSchoolDao,DtoConverterService dtoConverterService) {
		super();
		this.candidateSchoolDao = candidateSchoolDao;
		this.dtoConverterService = dtoConverterService;
	}

	@Override
	public DataResult<List<CandidateSchool>> getAll() {
		return new SuccessDataResult<List<CandidateSchool>>
		(this.candidateSchoolDao.findAll(),"Mezun olunan okullar listelendi. ");
	}

	@Override
	public Result add(CandidateSchoolDto candidateSchoolDto) {
		this.candidateSchoolDao.save
		((CandidateSchool) dtoConverterService.dtoClassConverter(candidateSchoolDto, CandidateSchool.class));
		return new SuccessResult("Okul eklendi.");
	}

	@Override
	public DataResult<List<CandidateSchoolDto>> findByCandidateCvIdOrderByStartedDateDesc(int id) {
		List<CandidateSchool> school = candidateSchoolDao.findByCandidateCvIdOrderByStartedDateDesc(id);
		return new SuccessDataResult<List<CandidateSchoolDto>>
		(this.dtoConverterService.dtoConverter(school, CandidateSchoolDto.class),"Okullar tarihe göre sıralandı.");
	}

}
