package sawonpkg;

public class Sawon {
	
	private int id;
	private String name;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "����� id�� " + id + ", ����̸��� " + name + "�̶��~~";
	}
	
	public void hobbyString() {
		System.out.println("���� ��̴� �����̾�~~");
	}

}
