package Models;


public class Client extends User implements java.io.Serializable {

	private int age;
	private float weight;
	private float height;

	public Client(int id, String name, String cpf, float weight, float height, int age) {
		super(id, name, cpf);
		this.weight = weight;
		this.height = height;
		this.age = age;
	}

	public float getWeight() {
		return this.weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public float getHeight() {
		return this.height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
