package polymorphism;

public class LgTV implements TV{
	public void powerOn() {
		System.out.println("LgTV--전원 켜기.");
	}

	public void powerOff() {
		System.out.println("LgTV---전원 끄기.");
	}

	public void volumeUp() {
		System.out.println("LgTV---소리 키우기.");
	}

	public void volumeDown() {
		System.out.println("LgTV---소리 줄이기.");
	}
}