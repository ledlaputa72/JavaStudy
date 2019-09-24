package sawonpkg;

public class SawonVO {
	
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
		return "사원의 id는 " + id + ", 사원이름은 " + name + "이라는~~";
	}

}
