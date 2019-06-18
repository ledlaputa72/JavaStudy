package classHuman;

public class Main {

	public static void main(String[] args) {

		Knight k1=new Knight("Red Knight", "Human", 34, 175, 200, "Sword", "PlateArmor", "Metal Shild",200);
		Knight k2=new Knight("Dark Knight", "Elf", 300, 185, 100, "Darger", "ElfArmor", "Sliver Shild",300);
		
		System.out.println("Name"+"\t\t"+"Age"+"\t"+"Race"+"\t"+"Weapon"+"\t"+"Power");
		System.out.println("=============================================");
		k1.show();
		k2.show();
		
	}

}
