package kodlamaio.HRMS.entities.concretes;

import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "candidate_schools")
public class CandidateSchool {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "school_name")
	private String schoolName;
	
	@Column(name = "school_department")
	private String schoolDepartment;
	
	@Column(name = "started_date")
	private Date startedDate;
	
	@Column(name = "end_date")
	private Date endDate;
	
	@Column(name = "added_date")
	private LocalDateTime addedDate = LocalDateTime.now();
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne(targetEntity = CandidateCv.class)
	@JoinColumn(name = "cv_id",referencedColumnName = "id",nullable = false)
	private CandidateCv candidateCv;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne(targetEntity = CandidateSchoolGraduate.class)
	@JoinColumn(name = "graduate_id",referencedColumnName = "id",nullable = false)
	private CandidateSchoolGraduate candidateSchoolGraduate;
}
