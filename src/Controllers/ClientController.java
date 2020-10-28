package Controllers;

import Controllers.DAO.ClientDAO;
import Models.Client;
import Models.User;

import java.util.List;

public class ClientController {

	private ClientDAO alunoDAO;

	private static ClientController ourInstance = new ClientController();

	public static ClientController getInstance() {
		return ourInstance;
	}

	public ClientController() {
		alunoDAO = ClientDAO.getInstance();
	}

	public List<Client> getAlunos() {
		return alunoDAO.getList();
	}

	public void adicionaAluno(int id, String nome, String cpf, float peso, float altura, int idade)
			throws Exception {
		alunoDAO.put(new Client(id, nome, cpf, peso, altura, idade));
	}

	public void alteraCadastro(int id, String name, String cpf, float weight, float altura, int age) throws Exception {

		Client a = (Client) this.recuperaAluno(id);
		
		a.setName(name);
		a.setHeight(altura);
		a.setAge(age);
		a.setWeight(weight);

	}

	public User recuperaAluno(int id) throws Exception {
		return alunoDAO.get(id);
	}

	public void deletaAluno(int id) throws Exception {
		alunoDAO.remove(id);
	}

}
