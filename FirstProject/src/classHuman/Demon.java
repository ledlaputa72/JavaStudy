package classHuman;

public class Demon {
	private String weapon;
	private String skill;
	private String skull;
	private int stamina;
	
	public String getWeapon() {
		return weapon;
	}
	public void setWeapon(String weapon) {
		this.weapon = weapon;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	public String getSkull() {
		return skull;
	}
	public void setSkull(String skull) {
		this.skull = skull;
	}
	public int getStamina() {
		return stamina;
	}
	public void setStamina(int stamina) {
		this.stamina = stamina;
	}
	
	public Demon(String weapon, String skill, String skull, int stamina) {
		super();
		this.weapon = weapon;
		this.skill = skill;
		this.skull = skull;
		this.stamina = stamina;
	}
	
	
}
