package hobby;

import sawonpkg.Sawon;

public class Hobby {
	
	private Sawon sawon;	//���⼭�� �ʵ��, �����δ� ��ü 
	//Setter Injection�� ����Ͽ� ��ü�� ó��, ref���
	//���� �� �۾��� xml���� 
	
	public Sawon getSawon() {
		return sawon;
	}

	public void setSawon(Sawon sawon) {
		this.sawon = sawon;
	}

}
