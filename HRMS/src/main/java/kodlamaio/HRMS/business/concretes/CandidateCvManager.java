package kodlamaio.HRMS.business.concretes;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.HRMS.business.abstracts.CandidateCvService;
import kodlamaio.HRMS.core.cloudinary.CloudinaryService;
import kodlamaio.HRMS.core.utilities.DataResult;
import kodlamaio.HRMS.core.utilities.Result;
import kodlamaio.HRMS.core.utilities.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.CandidateCvDao;
import kodlamaio.HRMS.entities.concretes.CandidateCv;

@Service
public class CandidateCvManager implements CandidateCvService{
	
	private CandidateCvDao candidateCvDao;
	private CloudinaryService cloudinaryService;
	
	@Autowired
	public CandidateCvManager(CandidateCvDao candidateCvDao,CloudinaryService cloudinaryService) {
		super();
		this.candidateCvDao = candidateCvDao;
		this.cloudinaryService = cloudinaryService;
	}

	@Override
	public DataResult<List<CandidateCv>> getAll() {
		return new SuccessDataResult<List<CandidateCv>>
		(this.candidateCvDao.findAll(),"İş arayanların CV'leri listelendi. ");
	}

	@Override
	public Result add(CandidateCv candidateCv) {
		this.candidateCvDao.save(candidateCv);
		return new SuccessResult("CV eklendi.");
	}

	@Override
	public Result saveImage(MultipartFile file, int id) {
		Map<String,String> uploader = (Map<String,String>) 
				cloudinaryService.save(file).getData();
		String imageUrl = uploader.get("url");
		CandidateCv candidateCv = candidateCvDao.getOne(id);
		candidateCv.setPhoto(imageUrl);
		candidateCvDao.save(candidateCv);
		return new SuccessResult("Fotoğraf eklendi.");
	}
	
	

}
