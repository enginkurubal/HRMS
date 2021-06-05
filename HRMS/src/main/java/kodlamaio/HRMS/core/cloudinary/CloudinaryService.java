package kodlamaio.HRMS.core.cloudinary;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.HRMS.core.utilities.DataResult;

public interface CloudinaryService {
	DataResult<?> save(MultipartFile file);
}
