package Controllers.DAO;

import java.io.*;
import java.util.HashMap;
import java.util.List;

public abstract class DAO<T> {

	public String path = "";

	public void persistir(HashMap<Integer, T> usuario) throws IOException {
		try {
			FileOutputStream fileOut = new FileOutputStream(path);

			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(usuario);
			out.flush();
			out.close();
			fileOut.close();

		} catch (FileNotFoundException var4) {
			var4.printStackTrace();
		} catch (IOException var5) {
			var5.printStackTrace();
		}

	}

	public HashMap<Integer, T> load() throws IOException {
		try {
			FileInputStream fileIn = new FileInputStream(path);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			HashMap<Integer, T> usuario = (HashMap<Integer, T>) in.readObject();
			in.close();
			fileIn.close();
			return usuario;
		} catch (IOException var4) {
			return new HashMap<>();
		} catch (ClassNotFoundException var5) {
			return new HashMap<>();
		}
	}

	public abstract T get(int id) throws Exception;

	public abstract void put(T usuario) throws Exception;

	public abstract void remove(int id) throws Exception;

	public abstract List<T> getList();

}