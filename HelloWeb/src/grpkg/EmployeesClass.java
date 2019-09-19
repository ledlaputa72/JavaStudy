package grpkg;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * EMPLOYEES 모델 클래스.
 * 
 * @author generated by ERMaster
 * @version $Id$
 */
public class EmployeesClass implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** EMPLOYEE_ID. */
	private Integer employeeId;

	/** FIRST_NAME. */
	private String firstName;

	/** LAST_NAME. */
	private String lastName;

	/** EMAIL. */
	private String email;

	/** PHONE_NUMBER. */
	private String phoneNumber;

	/** HIRE_DATE. */
	private Date hireDate;

	/** JOB_ID. */
	private String jobId;

	/** SALARY. */
	private Double salary;

	/** COMMISSION_PCT. */
	private Double commissionPct;

	/** EMPLOYEES. */
	private EmployeesClass managerIdemployees;

	/** DEPARTMENTS. */
	private DepartmentsClass departments;

	/** DEPARTMENTS 목록. */
	private Set<DepartmentsClass> departmentsSet;

	/** EMPLOYEES 목록. */
	private Set<EmployeesClass> employeesSet;

	/**
	 * 생성자.
	 */
	public EmployeesClass() {
		this.departmentsSet = new HashSet<DepartmentsClass>();
		this.employeesSet = new HashSet<EmployeesClass>();
	}

	/**
	 * EMPLOYEE_ID을 설정합니다..
	 * 
	 * @param employeeId
	 *            EMPLOYEE_ID
	 */
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * EMPLOYEE_ID을 가져옵니다..
	 * 
	 * @return EMPLOYEE_ID
	 */
	public Integer getEmployeeId() {
		return this.employeeId;
	}

	/**
	 * FIRST_NAME을 설정합니다..
	 * 
	 * @param firstName
	 *            FIRST_NAME
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * FIRST_NAME을 가져옵니다..
	 * 
	 * @return FIRST_NAME
	 */
	public String getFirstName() {
		return this.firstName;
	}

	/**
	 * LAST_NAME을 설정합니다..
	 * 
	 * @param lastName
	 *            LAST_NAME
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * LAST_NAME을 가져옵니다..
	 * 
	 * @return LAST_NAME
	 */
	public String getLastName() {
		return this.lastName;
	}

	/**
	 * EMAIL을 설정합니다..
	 * 
	 * @param email
	 *            EMAIL
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * EMAIL을 가져옵니다..
	 * 
	 * @return EMAIL
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * PHONE_NUMBER을 설정합니다..
	 * 
	 * @param phoneNumber
	 *            PHONE_NUMBER
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * PHONE_NUMBER을 가져옵니다..
	 * 
	 * @return PHONE_NUMBER
	 */
	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	/**
	 * HIRE_DATE을 설정합니다..
	 * 
	 * @param hireDate
	 *            HIRE_DATE
	 */
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	/**
	 * HIRE_DATE을 가져옵니다..
	 * 
	 * @return HIRE_DATE
	 */
	public Date getHireDate() {
		return this.hireDate;
	}

	/**
	 * JOB_ID을 설정합니다..
	 * 
	 * @param jobId
	 *            JOB_ID
	 */
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	/**
	 * JOB_ID을 가져옵니다..
	 * 
	 * @return JOB_ID
	 */
	public String getJobId() {
		return this.jobId;
	}

	/**
	 * SALARY을 설정합니다..
	 * 
	 * @param salary
	 *            SALARY
	 */
	public void setSalary(Double salary) {
		this.salary = salary;
	}

	/**
	 * SALARY을 가져옵니다..
	 * 
	 * @return SALARY
	 */
	public Double getSalary() {
		return this.salary;
	}

	/**
	 * COMMISSION_PCT을 설정합니다..
	 * 
	 * @param commissionPct
	 *            COMMISSION_PCT
	 */
	public void setCommissionPct(Double commissionPct) {
		this.commissionPct = commissionPct;
	}

	/**
	 * COMMISSION_PCT을 가져옵니다..
	 * 
	 * @return COMMISSION_PCT
	 */
	public Double getCommissionPct() {
		return this.commissionPct;
	}

	/**
	 * EMPLOYEES을 설정합니다..
	 * 
	 * @param managerIdemployees
	 *            EMPLOYEES
	 */
	public void setManagerIdemployees(EmployeesClass managerIdemployees) {
		this.managerIdemployees = managerIdemployees;
	}

	/**
	 * EMPLOYEES을 가져옵니다..
	 * 
	 * @return EMPLOYEES
	 */
	public EmployeesClass getManagerIdemployees() {
		return this.managerIdemployees;
	}

	/**
	 * DEPARTMENTS을 설정합니다..
	 * 
	 * @param departments
	 *            DEPARTMENTS
	 */
	public void setDepartments(DepartmentsClass departments) {
		this.departments = departments;
	}

	/**
	 * DEPARTMENTS을 가져옵니다..
	 * 
	 * @return DEPARTMENTS
	 */
	public DepartmentsClass getDepartments() {
		return this.departments;
	}

	/**
	 * DEPARTMENTS 목록을 설정합니다..
	 * 
	 * @param departmentsSet
	 *            DEPARTMENTS 목록
	 */
	public void setDepartmentsSet(Set<DepartmentsClass> departmentsSet) {
		this.departmentsSet = departmentsSet;
	}

	/**
	 * DEPARTMENTS를 추가합니다..
	 * 
	 * @param departments
	 *            DEPARTMENTS
	 */
	public void addDepartments(DepartmentsClass departments) {
		this.departmentsSet.add(departments);
	}

	/**
	 * DEPARTMENTS 목록을 가져옵니다..
	 * 
	 * @return DEPARTMENTS 목록
	 */
	public Set<DepartmentsClass> getDepartmentsSet() {
		return this.departmentsSet;
	}

	/**
	 * EMPLOYEES 목록을 설정합니다..
	 * 
	 * @param employeesSet
	 *            EMPLOYEES 목록
	 */
	public void setEmployeesSet(Set<EmployeesClass> employeesSet) {
		this.employeesSet = employeesSet;
	}

	/**
	 * EMPLOYEES를 추가합니다..
	 * 
	 * @param employees
	 *            EMPLOYEES
	 */
	public void addEmployees(EmployeesClass employees) {
		this.employeesSet.add(employees);
	}

	/**
	 * EMPLOYEES 목록을 가져옵니다..
	 * 
	 * @return EMPLOYEES 목록
	 */
	public Set<EmployeesClass> getEmployeesSet() {
		return this.employeesSet;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((employeeId == null) ? 0 : employeeId.hashCode());
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		EmployeesClass other = (EmployeesClass) obj;
		if (employeeId == null) {
			if (other.employeeId != null) {
				return false;
			}
		} else if (!employeeId.equals(other.employeeId)) {
			return false;
		}
		return true;
	}

}
