package classHuman;

public class Human {
	private String name;
	private String race;
	private int age;
	private int height;
	private int health;
	private int positionX;
	private int positionY;
	
	public int getPositionX() {
		return positionX;
	}
	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}
	public int getPositionY() {
		return positionY;
	}
	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRace() {
		return race;
	}
	public void setRace(String race) {
		this.race = race;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	
	public Human(String name, String race, int age, int height, int health,int positionX, int positionY) {
		super();
		this.name = name;
		this.race = race;
		this.age = age;
		this.height = height;
		this.health = health;
		this.positionX=positionX;
	}
	
}
