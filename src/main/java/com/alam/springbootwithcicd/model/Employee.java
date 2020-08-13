package com.alam.springbootwithcicd.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*@Getter 
@Setter 
@NoArgsConstructor 
@ToString 
@EqualsAndHashCode*/
@Entity
public class Employee implements Serializable{
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empId;
	

	private String empName;
	

	private String empAddress;
	
	
	private int empSalary;
	

	public int getEmpId() {
		return empId;
	}


	
	  public void setEmpId(int empId) { this.empId = empId; }
	  
	  
	  public String getEmpName() { return empName; }
	  
	  
	  public void setEmpName(String empName) { this.empName = empName; }
	  
	  
	  public String getEmpAddress() { return empAddress; }
	  
	  
	  public void setEmpAddress(String empAddress) { this.empAddress = empAddress;
	  }
	  
	  
	  public int getEmpSalary() { return empSalary; }
	  
	  
	  public void setEmpSalary(int empSalary) { this.empSalary = empSalary; }
	  
	 
	

}
