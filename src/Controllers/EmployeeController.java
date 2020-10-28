package Controllers;

import View.ListClientsScreen;
import View.UpdateClientScreen;
import View.DeleteClientScreen;

public class EmployeeController {

	private static EmployeeController ourInstance = new EmployeeController();

	public ListClientsScreen mostraAlunos;
	public DeleteClientScreen deletaCadastroAluno;
	public UpdateClientScreen atualizaCadastroAluno;

	public static EmployeeController getInstance() {
		return ourInstance;
	}

	private EmployeeController() {
		mostraAlunos = new ListClientsScreen();
	}
}
