package Day020_Class1;

class BBang3 { 
	private String jong; // 按眉 加己 
	private int ka;
	
	// 捞努赋胶甫 捞侩茄 getter,setter 磊悼 积己 
	
	public String getJong() {
		return jong;
	}
	public void setJong(String jong) {
		this.jong = jong;
	}
	public int getKa() {
		return ka;
	}
	public void setKa(int ka) {
		this.ka = ka;
	} 
	
}
public class Bread3 {
	public static void main(String[] args) {
		BBang3 b1=new BBang3();
		
		b1.setJong("酱农覆户"); 
		b1.setKa(2000);
				
		System.out.println(b1.getJong());
		System.out.println(b1.getKa());
		
		BBang3 b2=new BBang3(); 
		
		b2.setJong("酱农覆户");
		b2.setKa(2000);
		
		System.out.println(b2.getJong()); 
		System.out.println(b2.getKa());
	}

}
