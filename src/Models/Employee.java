package Models;

public class Employee extends User {
	
	private float salary;

	public Employee(int id, String name, String cpf, float salary) {
		super(id, name, cpf);
		this.salary=salary;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

}
