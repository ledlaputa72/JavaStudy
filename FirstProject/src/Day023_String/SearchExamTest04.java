package Day023_String;

class Sinsang{
		private String bb;
		private int cc;
		private String dd;
		private String ee;
		
		//선생님 방법일때 사용되는 생성자 
		public Sinsang(String bb, int cc, String ee, String dd) {
			this.bb=bb;
			this.cc=cc;
			this.dd=dd;
			this.ee=ee;
		}
		
		//내 방법은 getter setter를 사용
		public String getBb() {
			return bb;
		}
		public void setBb(String bb) {
			this.bb = bb;
		}
		public int getCc() {
			return cc;
		}
		public void setCc(int cc) {
			this.cc = cc;
		}
		public String getDd() {
			return dd;
		}
		public void setDd(String dd) {
			this.dd = dd;
		}
		public String getEe() {
			return ee;
		}
		public void setEe(String ee) {
			this.ee = ee;
		}

	public String toString() {
		 return "손님! "+this.getBb()+"가격은 "+this.getCc()/10000+"만원입니다. "+this.getDd()+"샵 담당자 "+this.getEe()+"입니다";
	}
}

public class SearchExamTest04 {

	public static void main(String[] args) {

		String aa="handbag**120000**dongdaemoon**choeunwoo";

		/*
		//getter, setter를 사용하는 방법 
		Sinsang s1=new Sinsang(); //객체 생성
		
		s1.setBb(aa.substring(0, 7));
		s1.setCc(Integer.parseInt(aa.substring(9, 15)));
		s1.setDd(aa.substring(17, 28));
		s1.setEe(aa.substring(30, 39));*/
		
		//선생님 방법 getter, setter 를 사용하지 않고 생성자로 바로 값을 넣는 방식 
		  String bb=aa.substring(0, 7);
		  int cc=Integer.parseInt(aa.substring(9, 15));
		  String dd=aa.substring(17, 28);
		  String ee=aa.substring(30, 39);
		  
		  Sinsang s1=new Sinsang(bb,cc,dd,ee); //생성자로 바로 넘긴다. 
		 
		System.out.println(s1.toString());
	}

}
