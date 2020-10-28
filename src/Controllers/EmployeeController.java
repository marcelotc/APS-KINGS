package Controllers;

import Controllers.DAO.EmployeeDAO;
import Models.Client;
import Models.Employee;
import Models.User;

public class EmployeeController {

	private EmployeeDAO employeeDAO;
	private static EmployeeController ourInstance = new EmployeeController();

	public static EmployeeController getInstance() {
		return ourInstance;
	}

	private EmployeeController() {
		employeeDAO = EmployeeDAO.getInstance();
	}

	public void addEmployee(int id, String nome, String cpf, float salary) throws Exception {
		employeeDAO.put(new Employee(id, nome, cpf, salary));

	}

	public void updateEmployee(int id, float salary) throws Exception {
		Employee a = (Employee) this.recEmployee(id);

		a.setSalary(salary);

	}

	public void delEmployee(int id) throws Exception {
		employeeDAO.remove(id);
	}

	public User recEmployee(int id) throws Exception {
		return employeeDAO.get(id);
	}

}
