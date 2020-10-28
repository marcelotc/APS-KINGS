package Controllers.DAO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Models.Client;
import Models.Employee;

public class EmployeeDAO extends DAO<Employee>{

	public static HashMap<Integer, Employee> cacheEmployees;
	
	private static EmployeeDAO ourInstance = new EmployeeDAO();

	public static EmployeeDAO getInstance() {
		return ourInstance;
	}

	
	private EmployeeDAO() {
		path = "C:\\Users\\nicol\\Desktop\\employee.txt";
		cacheEmployees = new HashMap<>();
		loadEmployees();
	}
	
	
	
	@Override
	public Employee get(int id) throws Exception {
		if (!cacheEmployees.containsKey(id))
			throw new Exception("Nao existe funcion�rio para este codigo");
		return cacheEmployees.get(id);
	}

	@Override
	public void put(Employee employee) throws Exception {
		if (cacheEmployees.containsKey(employee.getId()))
			throw new Exception("Ja existe funcion�rio para este codigo");
		cacheEmployees.put(employee.getId(), employee);
		persistir();
		
	}

	@Override
	public void remove(int id) throws Exception {
		if (!cacheEmployees.containsKey(id))
			throw new Exception("Esse funcion�rio nao existe");
		cacheEmployees.remove(id);
		persistir();
		
	}

	@Override
	public List<Employee> getList() {
		List<Employee> employees = new ArrayList<>(cacheEmployees.values());
		return employees;
	}

	public void persistir() throws IOException {
		super.persistir(cacheEmployees);
	}
	
	public void loadEmployees() {
		try {
			cacheEmployees = super.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
