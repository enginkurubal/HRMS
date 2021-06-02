package kodlamaio.HRMS.entities.concretes;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employers_activation_by_employees")
public class EmployerActivationByEmployee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	

	@OneToOne(targetEntity = Employer.class)
	@JoinColumn(name = "employer_id",referencedColumnName = "id",nullable = false)
	private Employer employer;
	
	@OneToOne(targetEntity = Employee.class)
	@JoinColumn(name = "confirmed_employee_id",referencedColumnName = "id",nullable = false)
	private Employee employee;
	
	@Column(name = "is_confirmed")
	private boolean isConfirmed;
	
	@Column(name = "confirmed_date")
	private Date confirmedDate;

}
