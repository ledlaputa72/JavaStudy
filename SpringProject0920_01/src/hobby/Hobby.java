package hobby;

import sawonpkg.Sawon;

public class Hobby {
	
	private Sawon sawon;	
	
	public Hobby ( ) {	}
	
	//�����ڰ� �޴´�. 
	public Hobby (Sawon sawon) {
		this.sawon = sawon;
	}
	
	
	
	public Sawon getSawon() {
		return sawon;
	}

	public void setSawon(Sawon sawon) {
		this.sawon = sawon;
	}

	public String kajaHobby() {
        return sawon.hobbyString();
 }

}
