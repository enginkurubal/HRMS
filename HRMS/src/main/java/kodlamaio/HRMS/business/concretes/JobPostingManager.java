package kodlamaio.HRMS.business.concretes;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.JobPostingService;
import kodlamaio.HRMS.core.dtoConverter.DtoConverterService;
import kodlamaio.HRMS.core.utilities.DataResult;
import kodlamaio.HRMS.core.utilities.Result;
import kodlamaio.HRMS.core.utilities.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.JobPostingDao;
import kodlamaio.HRMS.entities.concretes.JobPosting;
import kodlamaio.HRMS.entities.dtos.JobPostingAddDto;
import kodlamaio.HRMS.entities.dtos.JobPostingDto;
import net.bytebuddy.asm.Advice.This;


@Service
public class JobPostingManager implements JobPostingService{
	
	private JobPostingDao jobPostingDao;
	private ModelMapper modelMapper;
	private DtoConverterService dtoConverterService;
	
	@Autowired
	public JobPostingManager(JobPostingDao jobPostingDao, ModelMapper modelMapper,
			DtoConverterService dtoConverterService) {
		super();
		this.jobPostingDao = jobPostingDao;
		this.modelMapper = modelMapper;
		this.dtoConverterService = dtoConverterService;
	}
	
	
	private JobPosting dtoConvert(JobPostingAddDto jobPostingAddDto) {
		return modelMapper.map(jobPostingAddDto, JobPosting.class);
	}

	@Override
	public DataResult<List<JobPostingDto>>  findByIsActive() {
		
		return new SuccessDataResult<List<JobPostingDto>>
		(this.dtoConverterService.dtoConverter(jobPostingDao.findByIsActive(true),JobPostingDto.class),"Data Listelendi.");
	}

	@Override
	public DataResult<List<JobPostingDto>> findByIsActiveOrderByApplicationDeadline(String applicationDeadline) {
		
		return new SuccessDataResult<List<JobPostingDto>>
		(this.dtoConverterService.dtoConverter
				(jobPostingDao.findByIsActiveOrderByApplicationDeadline(true), JobPostingDto.class)
				,"Data Listelendi.");
	}

	@Override
	public DataResult<List<JobPostingDto>> findByIsActiveAndEmployer_CompanyName(String companyName) {
		
		return new SuccessDataResult<List<JobPostingDto>>
		(this.dtoConverterService.dtoConverter
				(jobPostingDao.findByIsActiveAndEmployer_CompanyName(true, companyName),
						JobPostingDto.class),"Data şirketlere göre listelendi.");
	}

	@Override
	public Result add(JobPostingAddDto JobPostingAddDto) {
		this.jobPostingDao.save(dtoConvert(JobPostingAddDto));
		return new SuccessResult("İş ilanı eklendi.");
	}

	@Override
	public Result delete(JobPosting jobPosting) {
		this.jobPostingDao.delete(jobPosting);
		return new SuccessResult("İş ilanı silindi.");
	}


	

}
