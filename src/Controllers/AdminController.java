package Controllers;

import Controllers.DAO.AdminDAO;
import Models.Admin;
import Models.User;

import java.util.List;

public class AdminController {

	private AdminDAO adminDAO;

	private static AdminController ourInstance = new AdminController();

	public static AdminController getInstance() {
		return ourInstance;
	}

	public AdminController() {
		adminDAO = AdminDAO.getInstance();
	}

	public List<Admin> getAdmins() {
		return adminDAO.getList();
	}

	public void addAdmin(int id, String name, String cpf, float salary)
			throws Exception {
		adminDAO.put(new Admin(id, name, cpf, salary));
	}

	public void updateAdmin(int id, String name, String cpf, float salary) throws Exception {
		Admin a = (Admin) this.getAdmin(id);
		
		a.setName(name);
		a.setCpf(cpf);
		a.setSalary(salary);
	}

	public User getAdmin(int id) throws Exception {
		return adminDAO.get(id);
	}

	public void deleteAdmin(int id) throws Exception {
		adminDAO.remove(id);
	}

}
