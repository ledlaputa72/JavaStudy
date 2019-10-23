package polymorphism;


public class SamsungTV implements TV {
	
	private Speaker speaker;
	private int price;
	
	public SamsungTV() {
		System.out.println("===> SamsungTV(1) 객체 생성");
	}
	
	/*public SamsungTV(Speaker speaker) {
		System.out.println("===> SamsungTV(2) 객체 생성");
		this.speaker = speaker;
	}
	
	public SamsungTV(Speaker speaker, int price) {
		System.out.println("===> SamsungTV(3) 객체 생성");
		this.speaker = speaker;
		this.price = price;
	}*/

	public void setSpeaker(Speaker speaker) {
		System.out.println("===> setSpeaker 호출");
		this.speaker = speaker;
	}

	public void setPrice(int price) {
		System.out.println("===> setPrice 호출");
		this.price = price;
	}

	public void powerOn() {
		System.out.println("SamsungTV--전원 켜기. (가격 : " + price +")");
	}

	public void powerOff() {
		System.out.println("SamsungTV---전원 끄기.");
	}

	public void volumeUp() {
		//System.out.println("SamsungTV---소리 키우기.");
		//speaker = new SonySpeaker();
		speaker.volumeUp();
	}

	public void volumeDown() {
		//System.out.println("SamsungTV---소리 줄이기.");
		//speaker = new SonySpeaker();
		speaker.volumeDown();
	}
}
