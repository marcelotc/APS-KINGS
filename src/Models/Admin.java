package Models;


public class Admin extends User implements java.io.Serializable {
	
	private float salary;
	
	public Admin(int id, String name, String cpf, float salary ) {
		super(id, name, cpf);
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}
	
}
