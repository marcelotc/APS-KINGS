package Controllers.DAO;

import Models.Client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ClientDAO extends DAO<Client> {

	public static HashMap<Integer, Client> cacheClients;
	private static ClientDAO ourInstance = new ClientDAO();

	public static ClientDAO getInstance() {
		return ourInstance;
	}

	private ClientDAO() {
		path = "C:\\Users\\Win10\\Desktop\\cliente.txt";
		cacheClients = new HashMap<>();
		loadAlunos();
	}

	@Override
	public Client get(int id) throws Exception {
		if (!cacheClients.containsKey(id))
			throw new Exception("Nao existe cliente para este codigo");
		return cacheClients.get(id);
	}

	@Override
	public void put(Client aluno) throws Exception {
		if (cacheClients.containsKey(aluno.getId()))
			throw new Exception("Ja existe cliente para este codigo");
		cacheClients.put(aluno.getId(), aluno);
		persistir();
	}

	@Override
	public void remove(int id) throws Exception {
		if (!cacheClients.containsKey(id))
			throw new Exception("Esse cliente nao existe");
		cacheClients.remove(id);
		persistir();
	}

	@Override
	public List<Client> getList() {
		List<Client> funcionarios = new ArrayList<>(cacheClients.values());
		return funcionarios;
	}

	public void persistir() throws IOException {
		super.persistir(cacheClients);
	}

	public void loadAlunos() {
		try {
			cacheClients = super.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}