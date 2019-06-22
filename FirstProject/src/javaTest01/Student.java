package javaTest01;

public class Student {

		public String studentName;
		public int grade;
		public int money;
		public Student(String studentName, int money) {
			super();
			this.studentName = studentName;
			this.money = money;
		}
		
		//버스 메소드
	/*public void takeBus(Bus bus) {
		bus.take(1000);
		this.money -= 1000;
	}*/
		
		//지하철 메소드 
		
		
		public void showInfo() {
			System.out.println(studentName + "님의 남은 돈은 "+money+"입니다. ");
		}
		
}
