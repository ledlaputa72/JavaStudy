package classHuman;

public class Knight extends Human{
	private String weapon;
	private String armor;
	private String shild;
	private int power;
	
	public String getWeapon() {
		return weapon;
	}
	public void setWeapon(String weapon) {
		this.weapon = weapon;
	}
	public String getArmor() {
		return armor;
	}
	public void setArmor(String armor) {
		this.armor = armor;
	}
	public String getShild() {
		return shild;
	}
	public void setShild(String shild) {
		this.shild = shild;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	
	public Knight(String name, String race, int age, int height, int health, int positionX, String weapon, String armor, String shild,
			int power) {
		super(name, race, age, height, health,positionX, power);
		this.weapon = weapon;
		this.armor = armor;
		this.shild = shild;
		this.power = power;
	}
	
	public void show(){
		System.out.print(this.getName()+"\t"+this.getAge()+"\t"+this.getRace()+"\t"+this.getWeapon()+"\t"+this.getPower());
		System.out.println();
		System.out.println("---------------------------------------------");
	}
	
}