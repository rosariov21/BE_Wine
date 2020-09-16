package com.rose.Company.RoseCompany;







import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "new_users")
public class Employee  {
	
	
	@Id
    @GeneratedValue
    @Column(name= "use_id")
	
	
	private Long id;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Column
	private String firstName;
	
	@Column
    private String lastName;
	@Column
    private String email;
	
	@Column
	private String mobile;
	
	@Column 
	private int age;
	
	@Column
	private String password;
	
	
    public Employee() {
    	
    }
public Employee(Long id, String firstName, String lastName, String email, String mobile, int age, String password) {
	
	this.id = id;
	this.firstName= firstName;
	this.lastName = firstName;
	this.email = email;
	this.mobile = mobile;
	this.age = age;
	this.password = password;
	
	
	
}
	public int getAge() {
	return age;
}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

		
	
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	

	
    public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

		
	}