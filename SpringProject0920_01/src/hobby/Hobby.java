package hobby;

import sawonpkg.Sawon;

public class Hobby {
	
	private Sawon sawon;	
	
	public Hobby ( ) {	}
	
	//생성자가 받는다. 
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
