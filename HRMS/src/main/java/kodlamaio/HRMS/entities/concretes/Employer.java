package kodlamaio.HRMS.entities.concretes;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employers")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","job_postings"})
public class Employer extends User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@NotBlank(message = "Bu alan boş bırakılamaz")
	@Column(name = "company_name")
	private String companyName;
	
	@NotBlank(message = "Bu alan boş bırakılamaz")
	@Column(name = "web_address")
	private String webAddress;
	
	@NotBlank(message = "Bu alan boş bırakılamaz")
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@JsonIgnore
	@Column(name = "is_activated")
	private boolean isActivated;
	
}
