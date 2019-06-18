package classHuman;

public class Mage extends Human{
	private String magic;
	private String cloth;
	private String magicItem;
	private int magica;
	
	public String getMagic() {
		return magic;
	}
	public void setMagic(String magic) {
		this.magic = magic;
	}
	public String getClose() {
		return cloth;
	}
	public void setClose(String close) {
		this.cloth = close;
	}
	public String getMagicItem() {
		return magicItem;
	}
	public void setMagicItem(String magicItem) {
		this.magicItem = magicItem;
	}
	public int getMagica() {
		return magica;
	}
	public void setMagica(int magica) {
		this.magica = magica;
	}
	
	public Mage(String name, String race, int age, int height, int health, String magic, String close, String magicItem,
			int magica) {
		super(name, race, age, height, health);
		this.magic = magic;
		this.cloth = close;
		this.magicItem = magicItem;
		this.magica = magica;
	}
	
}
