package kodlamaio.HRMS.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.HRMS.business.abstracts.CandidateLanguageService;
import kodlamaio.HRMS.core.utilities.DataResult;
import kodlamaio.HRMS.core.utilities.Result;
import kodlamaio.HRMS.entities.concretes.CandidateLanguage;
import kodlamaio.HRMS.entities.dtos.CandidateLanguageDto;

@RestController
@RequestMapping("/api/candidateLanguages")
public class CandidateLanguagesController {

		private CandidateLanguageService candidateLanguageService;

		@Autowired
		public CandidateLanguagesController(CandidateLanguageService candidateLanguageService) {
			super();
			this.candidateLanguageService = candidateLanguageService;
		}
		
		@GetMapping("/getAll")
		public DataResult<List<CandidateLanguage>> getAll(){
			return this.candidateLanguageService.getAll();
		}
		
		@PostMapping("/add")
		public ResponseEntity<?> add(@Valid @RequestBody CandidateLanguageDto candidateLanguageDto) {
			return ResponseEntity.ok(candidateLanguageService.add(candidateLanguageDto));
		}
}
