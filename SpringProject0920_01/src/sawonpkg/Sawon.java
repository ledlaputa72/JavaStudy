package sawonpkg;

public class Sawon {
	
	private int id;
	private String name;
	
	public Sawon() { }
	
	//생성자 
	public Sawon(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	
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
		return "사원의 id는 " + id + ", 사원이름은 " + name + "이라는~~";
	}
	
	public String hobbyString() {
		
		return "나의 취미는 게임이야~~";
	}

}
