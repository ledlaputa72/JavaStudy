package Day023_String;

class Sinsang{
		private String bb;
		private int cc;
		private String dd;
		private String ee;
		
		//������ ����϶� ���Ǵ� ������ 
		public Sinsang(String bb, int cc, String ee, String dd) {
			this.bb=bb;
			this.cc=cc;
			this.dd=dd;
			this.ee=ee;
		}
		
		//�� ����� getter setter�� ���
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
		 return "�մ�! "+this.getBb()+"������ "+this.getCc()/10000+"�����Դϴ�. "+this.getDd()+"�� ����� "+this.getEe()+"�Դϴ�";
	}
}

public class SearchExamTest04 {

	public static void main(String[] args) {

		String aa="handbag**120000**dongdaemoon**choeunwoo";

		/*
		//getter, setter�� ����ϴ� ��� 
		Sinsang s1=new Sinsang(); //��ü ����
		
		s1.setBb(aa.substring(0, 7));
		s1.setCc(Integer.parseInt(aa.substring(9, 15)));
		s1.setDd(aa.substring(17, 28));
		s1.setEe(aa.substring(30, 39));*/
		
		//������ ��� getter, setter �� ������� �ʰ� �����ڷ� �ٷ� ���� �ִ� ��� 
		  String bb=aa.substring(0, 7);
		  int cc=Integer.parseInt(aa.substring(9, 15));
		  String dd=aa.substring(17, 28);
		  String ee=aa.substring(30, 39);
		  
		  Sinsang s1=new Sinsang(bb,cc,dd,ee); //�����ڷ� �ٷ� �ѱ��. 
		 
		System.out.println(s1.toString());
	}

}
