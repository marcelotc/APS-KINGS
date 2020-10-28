package Controllers;

import java.util.Random;

import View.EmployeeScreen;
import View.Admin.AdminScreen;

public class MainController implements java.io.Serializable {

	private static MainController ourInstance = new MainController();

	public EmployeeScreen funcionarioTela;
	public AdminScreen adminScreen;

	public static MainController getInstance() {
		return ourInstance;
	}

	public void inicia() throws Exception {
		AdminScreen.inicializaTela();
	}

	public int geraCodigoRandomicoUnico() throws Exception {
		int i = 0;
		while (i < 1000) {
			int randomNumber = new Random().ints(1, 999).limit(1).findFirst().getAsInt();
			return randomNumber;
		}
		throw new Exception();
	}
}
