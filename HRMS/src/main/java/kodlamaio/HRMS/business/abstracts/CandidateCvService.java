package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import org.mapstruct.Mapper;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.HRMS.core.utilities.DataResult;
import kodlamaio.HRMS.core.utilities.Result;
import kodlamaio.HRMS.entities.concretes.CandidateCv;

@Mapper
public interface CandidateCvService {
	
	DataResult<List<CandidateCv>> getAll();
	Result add(CandidateCv candidateCv);
	Result saveImage(MultipartFile file,int id);
	
	
}
