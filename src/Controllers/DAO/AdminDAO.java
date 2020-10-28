package Controllers.DAO;

import Models.Admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AdminDAO extends DAO<Admin> {

	public static HashMap<Integer, Admin> cacheAdmins;
	private static AdminDAO ourInstance = new AdminDAO();

	public static AdminDAO getInstance() {
		return ourInstance;
	}

	private AdminDAO() {
		path = "C:\\Users\\Win10\\Desktop\\admins.txt";
		cacheAdmins = new HashMap<>();
		loadAdmins();
	}

	@Override
	public Admin get(int id) throws Exception {
		if (!cacheAdmins.containsKey(id))
			throw new Exception("Nao existe admin para este codigo");
		return cacheAdmins.get(id);
	}

	@Override
	public void put(Admin admin) throws Exception {
		if (cacheAdmins.containsKey(admin.getId()))
			throw new Exception("Ja existe admin para este codigo");
		cacheAdmins.put(admin.getId(), admin);
		persist();
	}

	@Override
	public void remove(int id) throws Exception {
		if (!cacheAdmins.containsKey(id))
			throw new Exception("Esse admin nao existe");
		cacheAdmins.remove(id);
		persist();
	}

	@Override
	public List<Admin> getList() {
		List<Admin> admins = new ArrayList<>(cacheAdmins.values());
		return admins;
	}

	public void persist() throws IOException {
		super.persistir(cacheAdmins);
	}

	public void loadAdmins() {
		try {
			cacheAdmins = super.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}