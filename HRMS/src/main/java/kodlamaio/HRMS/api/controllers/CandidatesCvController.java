package kodlamaio.HRMS.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.HRMS.business.abstracts.CandidateCvService;
import kodlamaio.HRMS.core.utilities.DataResult;
import kodlamaio.HRMS.core.utilities.Result;
import kodlamaio.HRMS.entities.concretes.CandidateCv;

@RestController
@RequestMapping("/api/candidateCv")
public class CandidatesCvController {
	
	private CandidateCvService candidateCvService;

	
	@Autowired
	public CandidatesCvController(CandidateCvService candidateCvService) {
		super();
		this.candidateCvService = candidateCvService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<CandidateCv>> getAll(){
		return this.candidateCvService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CandidateCv candidateCv) {
		return this.candidateCvService.add(candidateCv);
	}
	
	@PutMapping("/uploadImage")
	public Result saveImage(@RequestBody MultipartFile file, @RequestParam int id) {
		return this.candidateCvService.saveImage(file, id);
	}
	
	
}
