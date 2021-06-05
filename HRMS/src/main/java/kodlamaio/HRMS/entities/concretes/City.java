package kodlamaio.HRMS.entities.concretes;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cities")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","job_postings"})
public class City {
	
	@Id
	@Column(name = "id",nullable=false,unique=true)
	private int id;
	
	@Column(name = "city_name")
	private String cityName;
	
}
